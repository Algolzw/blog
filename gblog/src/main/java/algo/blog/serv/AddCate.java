package algo.blog.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import utility.FileUploadTool;
import algo.blog.service.originjdbc.inter.PicCateService;

/**
 * Servlet implementation class AddCate
 */
@WebServlet("/addcate")
public class AddCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_PATH = "upload-pics/";
	private String serverPath = null;
	private static final String defaultPath = "images/default.gif";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		serverPath = this.getServletContext().getRealPath("/")
				.replace("\\", "/");

		response.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"blog-service.xml");
		PicCateService service = (PicCateService) ctx.getBean("cateService");
		String name = null;
		String comment = null;
		String fileName = null;
		int mark = 0;

		try {
			FileUploadTool tool = new FileUploadTool(request, 10 * 1024 * 1024,
					"utf-8");
			name = tool.getParam("name");
			comment = tool.getParam("comment");
			fileName = tool.saveFiles(serverPath + FILE_PATH).get(0);
			String strmark = tool.getParam("mark");
			mark = strmark.equals("") ? 0 : Integer.valueOf(strmark);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String cover = fileName.equals("") ? defaultPath : FILE_PATH + fileName;

		if (service.add(name, comment, cover, mark)) {
			HttpSession session = request.getSession();
			session.setAttribute("cates", null);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("pages/admin/success.jsp");
			request.setAttribute("toPage", "/gblog/pages/admin/index.jsp");
			request.setAttribute("fromPage", "/gblog/pages/admin/addCate.jsp");
			dispatcher.forward(request, response);
		} else {
			PrintWriter writer = response.getWriter();
			writer.println("name:" + name);
			writer.println("file:" + cover);
			writer.println("comment:" + comment);
			writer.println("mark:" + mark);
			writer.println();
			writer.print("���ʧ�ܣ�<a href='/gblog/pages/admin/addCate.jsp'>�������</a>");
			writer.flush();
			writer.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}


}
