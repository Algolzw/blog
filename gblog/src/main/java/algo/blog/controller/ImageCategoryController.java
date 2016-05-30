package algo.blog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import algo.blog.model.Piccate;
import algo.blog.service.inter.PicCateService;


@Controller
@RequestMapping(value="/imagecate")
public class ImageCategoryController {
	private static final String FILE_PATH = "upload-pics/";
	private String serverPath = null;
	private static final String defaultPath = "images/default.gif";

	@Inject
	private PicCateService cateService;
	
	@RequestMapping("")
	public String ShowCates(Model model){
		List<Piccate> cates = getAllCate();
		model.addAttribute("cates",cates);
		return "index";
	}
	
	@RequestMapping("/addcate")
	public String AddCateForm(Model model){
		model.addAttribute("piccate",new Piccate("123","12",(short) 3,false));
		return "admin/addCate";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String SaveCate(@ModelAttribute Piccate piccate){
		return "admin/success";
	}
	
	
	
	//获取所有类别
	@SuppressWarnings("unchecked")
	private List<Piccate> getAllCate(){
		ArrayList<Piccate> cates = (ArrayList<Piccate>)cateService.getAll();
		return cates;
	}
	
}
