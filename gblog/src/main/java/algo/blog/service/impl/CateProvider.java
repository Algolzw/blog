package algo.blog.service.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import algo.blog.db.DBConnection;
import algo.blog.model.Piccate;
import algo.blog.service.inter.PicCateService;

public class CateProvider implements PicCateService {

	DBConnection conn = null;
	PreparedStatement pstmt = null;

	@Override
	public boolean add(String name, String comment, String cover, int mark) {
		boolean res = false;
		conn = new DBConnection();
		String sql = "INSERT INTO piccate(name,comment,cover,mark) VALUES(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, comment);
			pstmt.setString(3, cover);
			pstmt.setInt(4, mark);
			res = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public boolean update(Piccate cate) {
		boolean res = false;
		conn = new DBConnection();
		String sql = "UPDATE piccate SET name=?,comment=?,cover=?,mark=?,deleted=?,cn1=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cate.getName());
			pstmt.setString(2, cate.getComment());
			pstmt.setString(3, cate.getCover());
			pstmt.setInt(4, cate.getMark());
			pstmt.setBoolean(5, cate.isDeleted());
			pstmt.setString(6, cate.getCn1());
			res = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public boolean delete(int cateId) {
		boolean res = false;
		conn = new DBConnection();
		String sql = "UPDATE piccate SET deleted=true WHERE cateid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cateId);
			res = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

	@Override
	public Piccate getById(int cateId) {
		Piccate cate = null;
		conn = new DBConnection();
		String sql = "SELECT name,comment,cover,mark,cn1 FROM piccate WHERE cateid=? AND deleted=false";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cateId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				cate = new Piccate();
				cate.setCateId(cateId);
				cate.setName(rs.getString("name"));
				cate.setComment(rs.getString("comment"));
				cate.setCover(rs.getString("cover"));
				cate.setMark(rs.getShort("mark"));
				cate.setCn1(rs.getString("cn1"));
				cate.setDeleted(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return cate;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getAll() {
		List cates = new ArrayList<Piccate>();
		conn = new DBConnection();
		String sql = "SELECT cateid,name,comment,cover,mark,cn1 FROM piccate WHERE deleted=false ORDER BY mark,name";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Piccate cate = null;
			while (rs.next()) {
				cate = new Piccate();
				cate.setCateId(rs.getInt("cateid"));
				cate.setName(rs.getString("name"));
				cate.setComment(rs.getString("comment"));
				cate.setCover(rs.getString("cover"));
				cate.setMark(rs.getShort("mark"));
				cate.setCn1(rs.getString("cn1"));
				cate.setDeleted(false);
				cates.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return cates;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getAll(String orderby) {
		List cates = new ArrayList<Piccate>();
		conn = new DBConnection();
		String sql = "SELECT cateid,name,comment,cover,mark,cn1 FROM piccate WHERE deleted=false ORDER BY "
				+ orderby;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Piccate cate = null;
			while (rs.next()) {
				cate = new Piccate();
				cate.setCateId(rs.getInt("cateid"));
				cate.setName(rs.getString("name"));
				cate.setComment(rs.getString("comment"));
				cate.setCover(rs.getString("cover"));
				cate.setMark(rs.getShort("mark"));
				cate.setCn1(rs.getString("cn1"));
				cate.setDeleted(false);
				cates.add(cate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return cates;
	}

	@Override
	public int count() {
		int count = 0;
		conn = new DBConnection();
		String sql = "SELECT count(*) FROM piccate WHERE deleted=false";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return count;
	}

	@Override
	public boolean existName(String name) {
		boolean res = false;
		conn = new DBConnection();
		String sql = "SELECT count(*) FROM piccate WHERE name=? AND deleted=false";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				res = rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return res;
	}

}
