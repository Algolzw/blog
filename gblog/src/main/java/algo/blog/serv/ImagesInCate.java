package algo.blog.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import algo.blog.model.Beautypic;
import algo.blog.service.inter.ImageService;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String cateId = request.getParameter("cateid");
		ArrayList<Beautypic> images = getImages(cateId);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	@SuppressWarnings({ "unchecked", "resource" })
	private ArrayList<Beautypic> getImages(String cateId){
		ArrayList<Beautypic> images = new ArrayList<>();
		int id = Integer.parseInt(cateId);
		ApplicationContext context = new ClassPathXmlApplicationContext();
		ImageService service = (ImageService)context.getBean("imageService");
		images = (ArrayList<Beautypic>)service.getAll(id);
		return images;
	}
}
