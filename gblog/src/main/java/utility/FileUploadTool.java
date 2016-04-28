package utility;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadTool {
	private HttpServletRequest req = null;
	private List<FileItem> items = null;
	private Map<String, List<String>> datas = new HashMap<>();
	private Map<String, FileItem> files = new HashMap<>();

	public FileUploadTool(HttpServletRequest req, int maxSize, String format)
			throws IOException, FileUploadException {
		this.req = req;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		if (maxSize > 0) {
			upload.setFileSizeMax(maxSize);
		}
		this.items = upload.parseRequest(req);
		this.init(format);
	}

	/***
	 * 初始化
	 * 
	 * @param format
	 *            设置字符串编码
	 * @throws IOException
	 */
	public void init(String format) throws IOException {
		Iterator<FileItem> iter = this.items.iterator();
		while (iter.hasNext()) {
			FileItem item = iter.next();
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString(format);
				List<String> temps = null;
				if (this.datas.containsKey(name)) {
					temps = this.datas.get(name);
				} else {
					temps = new ArrayList<String>();
				}
				temps.add(value);
				datas.put(name, temps);
			} else {
				String fileName = item.getName().toLowerCase();
				fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
				this.files.put(fileName, item);
			}
		}
	}

	/***
	 * 获取单个表单数据
	 * 
	 * @param name
	 *            标签名称
	 * @return
	 */
	public String getParam(String name) {
		String res = null;
		List<String> temps = this.datas.get(name);
		if (temps != null) {
			res = temps.get(0);
		}
		return res;
	}

	/***
	 * 获取复选框之类的有多个数据的表单值
	 * 
	 * @param name
	 *            标签名
	 * @return
	 */
	public String[] getParams(String name) {
		String[] res = null;
		List<String> temps = this.datas.get(name);
		if (temps != null) {
			res = temps.toArray(new String[temps.size()]);
		}
		return res;
	}

	public Map<String, FileItem> getFiles() {
		return this.files;
	}

	/***
	 * 保存上传的文件
	 * 
	 * @param path
	 *            文件保存路劲
	 * @return 文件名称集合
	 * @throws IOException
	 */
	public List<String> saveFiles(String path) throws IOException {
		List<String> srcs = new ArrayList<>();
		if (files.size() > 0) {
			Set<String> keys = files.keySet();
			File file = null;
			String filename = "";
			for (String key : keys) {
				FileItem item = this.files.get(key);
				filename = System.currentTimeMillis() + "."
						+ key.substring(key.lastIndexOf(".") + 1);
				file = new File(path+filename);
				if (!file.exists()) {
					try (InputStream input = item.getInputStream();
							OutputStream output = new FileOutputStream(file)) {
						int tmp = 0;
						byte[] data = new byte[512];
						while ((tmp = input.read(data, 0, 512)) != -1) {
							output.write(data);
						}
					}
				}
				srcs.add(filename);
			}
		}
		return srcs;
	}

}
