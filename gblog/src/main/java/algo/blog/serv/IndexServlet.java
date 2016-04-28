package algo.blog.serv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import algo.blog.model.Piccate;
import algo.blog.service.*;
import algo.blog.service.impl.CateProvider;
import algo.blog.service.inter.PicCateService;

/**
 * Servlet implementation class CateServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		List<Piccate> cates = getAllCate();
		
//		HttpSession session = request.getSession();
//		
//		session.setAttribute("cates", cates);
		request.setAttribute("cates", cates);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	List<Piccate> getAllCate(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("blog-service.xml");
		PicCateService service = (PicCateService)ctx.getBean("cateService");
		ArrayList<Piccate> cates = (ArrayList<Piccate>)service.getAll();
		return cates;
	}

}
