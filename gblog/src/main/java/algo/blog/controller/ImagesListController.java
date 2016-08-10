package algo.blog.controller;

import java.util.ArrayList;

import algo.blog.core.img.CateManager;
import algo.blog.core.img.ImgManager;
import algo.blog.model.BeautyPic;
import algo.blog.model.PicCate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/image")
public class ImagesListController {

	private CateManager cateManager;

	private ImgManager imgManager;

	public void setCateManager(CateManager cateManager){
		this.cateManager = cateManager;
	}

	public void setImgManager(ImgManager imgManager){
		this.imgManager = imgManager;
	}

	@RequestMapping("/imagesincate/{cateId}")
	public String showImagesInCate(@PathVariable int cateId, Model model){

		PicCate cate = getCate(cateId);
		model.addAttribute("cate", cate);
		ArrayList<BeautyPic> images = getImages(cateId);
		int res =0;
		if (images != null) {
			res = images.size();
		}
		model.addAttribute("size", res);
		model.addAttribute("images", images);
		return "display/images";
	}

	@SuppressWarnings({ "unchecked", "resource" })
	private ArrayList<BeautyPic> getImages(int id) {
		ArrayList<BeautyPic> images = new ArrayList<>();
		images = (ArrayList<BeautyPic>) imgManager.getPicsInCate(id,"hot","asc");
		return images;
	}
	
	private PicCate getCate(int id){
		return cateManager.getById(id);
	}
}
