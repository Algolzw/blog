package algo.blog.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import utility.DateUtil;
import algo.blog.model.Piccate;
import algo.blog.service.inter.PicCateService;

@Controller
@RequestMapping(value = "/imagecate")
public class ImageCategoryController {
	private static final String FILE_PATH = "upload-pics";
	private String serverPath = null;
	private static final String defaultPath = "images/default.gif";

	@Inject
	private PicCateService cateService;

	@RequestMapping("")
	public String ShowCates(Model model) {
		List<Piccate> cates = getAllCate();
		model.addAttribute("cates", cates);
		return "index";
	}

	@RequestMapping("/addcate")
	public String AddCateForm(Model model) {
		model.addAttribute("piccate",
				new Piccate());
		return "admin/addCate";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String SaveCate(@RequestParam("path") MultipartFile path,
			HttpServletRequest request, @ModelAttribute Piccate piccate,Model model) {
		serverPath = request.getSession().getServletContext()
				.getRealPath(FILE_PATH);

		if (!path.isEmpty()) {
			//String picName = path.getOriginalFilename();
			String picName = DateUtil.getNowStrDate("yyyyMMddHHmmssSSS");
			File target = new File(serverPath, picName);
			if (!target.exists()) {
				target.mkdirs();
			}
			try {
				path.transferTo(target);
			} catch (Exception e) {
				e.printStackTrace();
				return "index";
				
			}
			model.addAttribute("fromPage","imagecate/addcate");
			model.addAttribute("toPage","imagecate");
			piccate.setCover(FILE_PATH + "/" + picName);
			if(cateService.add(piccate.getName(), piccate.getComment(), piccate.getCover(), piccate.getMark()))
				return "admin/result/success";
		}
		return "admin/result/fail";
	}

	// 获取所有类别
	@SuppressWarnings("unchecked")
	private List<Piccate> getAllCate() {
		ArrayList<Piccate> cates = (ArrayList<Piccate>) cateService.getAll();
		return cates;
	}

}
