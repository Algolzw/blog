package algo.blog.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import algo.blog.model.BeautyPic;
import algo.blog.model.PicCate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import algo.blog.service.originjdbc.inter.ImageService;
import algo.blog.service.originjdbc.inter.PicCateService;

/**
 * Servlet implementation class ImagesInCate
 */
@WebServlet("/imagesincate")
public class ImagesInCate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImagesInCate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		//
		ApplicationContext context = new ClassPathXmlApplicationContext("blog-service.xml");
		//cateid
		String cateId = request.getParameter("cateid");
		if(cateId==null){
			cateId = "1";
		}
		int id = Integer.parseInt(cateId);
		//��ȡ���
		PicCate cate = getCate(context,id);
		request.setAttribute("cate", cate);
		ArrayList<BeautyPic> images = getImages(context,id);
		int res;
		if (images != null) {
			res = images.size();
			request.setAttribute("size", res);
			request.setAttribute("images", images);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/display/images.jsp");
			dispatcher.forward(request, response);
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

	@SuppressWarnings({ "unchecked", "resource" })
	private ArrayList<BeautyPic> getImages(ApplicationContext context,int id) {
		ArrayList<BeautyPic> images = new ArrayList<>();
		ImageService service = (ImageService) context.getBean("imageService");
		images = (ArrayList<BeautyPic>) service.getAll(id);
		return images;
	}
	
	private PicCate getCate(ApplicationContext context,int id){
		PicCateService service = (PicCateService)context.getBean("cateService");
		return service.getById(id);
	}
}
