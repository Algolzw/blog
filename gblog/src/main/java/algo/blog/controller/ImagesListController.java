package algo.blog.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import algo.blog.model.Beautypic;
import algo.blog.model.Piccate;
import algo.blog.service.inter.ImageService;
import algo.blog.service.inter.PicCateService;

@Controller
@RequestMapping(value="/image")
public class ImagesListController {
	
	@Inject
	private PicCateService picCateService;
	@Inject
	private ImageService imageService;
	
	@RequestMapping("/imagesincate/{cateId}")
	public String showImagesInCate(@PathVariable int cateId, Model model){

		//获取类别
		Piccate cate = getCate(cateId);
		model.addAttribute("cate", cate);
		ArrayList<Beautypic> images = getImages(cateId);
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
		images = (ArrayList<Beautypic>) imageService.getAll(id,"hot");
		return images;
	}
	
	private Piccate getCate(int id){
		return picCateService.getById(id);
	}
}
