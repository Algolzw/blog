package algo.blog.controller;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import algo.blog.model.Beautypic;
import algo.blog.model.Piccate;
import algo.blog.service.inter.ImageService;
import algo.blog.service.inter.PicCateService;

@Controller
public class ImagesListController {
	
	@Inject
	private PicCateService picCateService;
	@Inject
	private ImageService imageService;
	
	@RequestMapping("/image/imagesincate")
	public String showImagesInCate(HttpServletRequest request,Model model){
		String cateId = request.getParameter("cateid");
		if(cateId==null){
			cateId = "1";
		}
		int id = Integer.parseInt(cateId);
		//获取类别
		Piccate cate = getCate(id);
		model.addAttribute("cate", cate);
		ArrayList<Beautypic> images = getImages(id);
		int res =0;
		if (images != null) {
			res = images.size();
		}
		model.addAttribute("size", res);
		model.addAttribute("images", images);
		return "display/images";
	}
	
	
	
	@SuppressWarnings({ "unchecked", "resource" })
	private ArrayList<Beautypic> getImages(int id) {
		ArrayList<Beautypic> images = new ArrayList<>();
		images = (ArrayList<Beautypic>) imageService.getAll(id);
		return images;
	}
	
	private Piccate getCate(int id){
		return picCateService.getById(id);
	}
}
