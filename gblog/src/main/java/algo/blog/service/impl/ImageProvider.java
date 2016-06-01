package algo.blog.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import utility.DateUtil;
import algo.blog.db.DBConnection;
import algo.blog.model.Beautypic;
import algo.blog.service.inter.ImageService;

@Service
public class ImageProvider implements ImageService {

	private DBConnection conn = null;
	private PreparedStatement pstmt = null;

	@Override
	public boolean add(String name, String urlPath, int size) {
		conn = new DBConnection();
		boolean res = false;
		try {
			String sql = "INSERT INTO beautypic(name,urlpath,size) VALUES(?,?,?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, urlPath);
			pstmt.setInt(3, size);
			res = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public boolean add(int cateId, String name, String urlPath, int size) {
		conn = new DBConnection();
		boolean res = false;
		try {
			String sql1 = "INSERT INTO beautypic(name,urlpath,size) VALUES(?,?,?) ";
			pstmt = conn
					.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, name);
			pstmt.setString(2, urlPath);
			pstmt.setInt(3, size);
			int key = -1;
			if (pstmt.executeUpdate() > 0) {
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					if (rs.next()) {
						key = rs.getInt(1);
					}
				} finally {
					pstmt.close();
				}
			}
			if (key != -1) {
				String sql2 = "INSERT INTO picincate(cateid,picid) VALUES(?,?)";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, cateId);
				pstmt.setInt(2, key);
				res = pstmt.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public boolean add(int cateId, String name, String urlPath, int size,
			int hot, String comment, String cn1) {
		conn = new DBConnection();
		boolean res = false;
		try {
			String sql = "INSERT INTO beautypic(name,urlpath,size,hot,comment,cn1) VALUES(?,?,?,?,?,?) ";
			pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, name);
			pstmt.setString(2, urlPath);
			pstmt.setInt(3, size);
			pstmt.setInt(4, hot);
			pstmt.setString(5, comment);
			pstmt.setString(6, cn1);
			int key = -1;
			if (res = pstmt.executeUpdate() > 0) {
				try(ResultSet rs = pstmt.getGeneratedKeys()){
					if(rs.next()){
						key = rs.getInt(1);
					}
				}finally{
					pstmt.close();
				}
			}
			if(key !=-1){
				String sql2 = "INSERT INTO picincate(cateid,picid) VALUES(?,?)";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, cateId);
				pstmt.setInt(2, key);
				res = pstmt.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public boolean update(Beautypic pic) {
		boolean res = false;
		conn = new DBConnection();
		try {
			String sql = "UPDATE beautypic SET name=?,urlpath=?,uploadtime=?,size=?,hot=?,comment=?,deleted=?,cn1=? WHERE picid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pic.getName());
			pstmt.setString(2, pic.getUrlPath());
			pstmt.setTimestamp(3, DateUtil.toTimeStamp(pic.getUploadTime()));
			pstmt.setInt(4, pic.getSize());
			pstmt.setInt(5, pic.getHot());
			pstmt.setString(6, pic.getComment());
			pstmt.setBoolean(7, pic.isDeleted());
			pstmt.setString(8, pic.getCn1());
			pstmt.setInt(9, pic.getPicId());
			res = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public boolean delete(int picId) {
		boolean res = false;
		conn = new DBConnection();
		try {
			String sql = "UPDATE beautypic SET deleted=true WHERE picid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, picId);
			res = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public boolean delete(int picId, boolean forever) {
		boolean res = false;
		conn = new DBConnection();
		String sql = "";
		if (forever) {
			sql = "DELETE FROM beautypic WHERE picid=?";
		} else {
			sql = "UPDATE beautypic SET deleted=true WHERE picid=?";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, picId);
			res = pstmt.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public Beautypic getById(int picId) {
		conn = new DBConnection();
		Beautypic pic = null;
		String sql = "SELECT name,urlpath,uploadtime,size,hot,comment,cn1 FROM beautypic WHERE picid=? AND deleted=0";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, picId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				pic = new Beautypic();
				pic.setPicId(picId);
				pic.setName(rs.getString("name"));
				pic.setUrlPath(rs.getString("urlpath"));
				pic.setUploadTime(rs.getDate("uploadtime"));
				pic.setSize(rs.getInt("size"));
				pic.setHot(rs.getInt("hot"));
				pic.setComment(rs.getString("comment"));
				pic.setCn1(rs.getString("cn1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return pic;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getAll() {
		conn = new DBConnection();
		List pics = new ArrayList<Beautypic>();
		String sql = "SELECT picid,name,urlpath,uploadtime,size,hot,comment,cn1 FROM beautypic WHERE deleted=0 ORDER BY hot,uploadtime";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Beautypic pic = null;
			while (rs.next()) {
				pic = new Beautypic();
				pic.setPicId(rs.getInt("picid"));
				pic.setName(rs.getString("name"));
				pic.setUrlPath(rs.getString("urlpath"));
				pic.setUploadTime(rs.getDate("uploadtime"));
				pic.setSize(rs.getInt("size"));
				pic.setHot(rs.getInt("hot"));
				pic.setComment(rs.getString("comment"));
				pic.setCn1(rs.getString("cn1"));
				pics.add(pic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return pics;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getAll(String orderby) {
		conn = new DBConnection();
		List pics = new ArrayList<Beautypic>();
		String sql = "SELECT picid,name,urlpath,uploadtime,size,hot,comment,cn1 FROM beautypic WHERE deleted=0 ORDER BY "
				+ orderby;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Beautypic pic = null;
			while (rs.next()) {
				pic = new Beautypic();
				pic.setPicId(rs.getInt("picid"));
				pic.setName(rs.getString("name"));
				pic.setUrlPath(rs.getString("urlpath"));
				pic.setUploadTime(rs.getDate("uploadtime"));
				pic.setSize(rs.getInt("size"));
				pic.setHot(rs.getInt("hot"));
				pic.setComment(rs.getString("comment"));
				pic.setCn1(rs.getString("cn1"));
				pics.add(pic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return pics;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getAll(int cateId){
		conn = new DBConnection();
		List pics = new ArrayList<Beautypic>();
		String sql = "SELECT B.picid,B.name,B.urlpath,B.uploadtime,B.size,B.hot,B.comment,B.cn1 "
				+ "FROM beautypic AS B JOIN picincate AS P ON B.picid=P.picid WHERE B.deleted=0 ORDER BY B.hot,B.uploadtime";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Beautypic pic = null;
			while (rs.next()) {
				pic = new Beautypic();
				pic.setPicId(rs.getInt("picid"));
				pic.setName(rs.getString("name"));
				pic.setUrlPath(rs.getString("urlpath"));
				pic.setUploadTime(rs.getDate("uploadtime"));
				pic.setSize(rs.getInt("size"));
				pic.setHot(rs.getInt("hot"));
				pic.setComment(rs.getString("comment"));
				pic.setCn1(rs.getString("cn1"));
				pics.add(pic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return pics;
	}
	
	@SuppressWarnings("rawtypes")
	public List getAll(int cateId,String orderby){
		List<Beautypic> images = new ArrayList<>();
		conn = new DBConnection();
		String sql = "SELECT B.picid,B.name,B.urlpath,B.uploadtime,B.size,B.hot,B.comment,B.cn1 "
				+ "FROM beautypic AS B JOIN picincate AS P ON B.picid=P.picid WHERE B.deleted=0 ORDER BY B."+orderby;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Beautypic pic = null;
			while (rs.next()) {
				pic = new Beautypic();
				pic.setPicId(rs.getInt("picid"));
				pic.setName(rs.getString("name"));
				pic.setUrlPath(rs.getString("urlpath"));
				pic.setUploadTime(rs.getDate("uploadtime"));
				pic.setSize(rs.getInt("size"));
				pic.setHot(rs.getInt("hot"));
				pic.setComment(rs.getString("comment"));
				pic.setCn1(rs.getString("cn1"));
				images.add(pic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return images;
	}

	@Override
	public int getSize() {
		conn = new DBConnection();
		int count = 0;
		String sql = "SELECT count(*) FROM beautypic WHERE deleted=0";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return count;
	}

}
