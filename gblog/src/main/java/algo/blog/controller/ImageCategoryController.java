package algo.blog.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import algo.blog.core.img.CateManager;
import algo.blog.model.PicCate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import utility.DateUtil;

@Controller
@RequestMapping(value = "/imagecate")
public class ImageCategoryController {

    private static final String FILE_PATH = "upload-pics";
    private String serverPath = null;
    private static final String defaultPath = "images/default.gif";

    private CateManager cateManager;

    public void setCateManager(CateManager cateManager) {
        this.cateManager = cateManager;
    }

    @RequestMapping("")
    public String ShowCates(Model model) {
//        System.out.println((cateManager == null) + "==============");
        List<PicCate> cates = getAllCate();
        model.addAttribute("cates", cates);
        return "index";
    }

    @RequestMapping("/addcate")
    public String AddCateForm(Model model) {
        model.addAttribute("piccate",
                new PicCate());
        return "admin/addCate";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String SaveCate(@RequestParam("path") MultipartFile path,
                           HttpServletRequest request, @ModelAttribute PicCate piccate, Model model) {
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
            model.addAttribute("fromPage", "imagecate/addcate");
            model.addAttribute("toPage", "imagecate");
            piccate.setCover(FILE_PATH + "/" + picName);
            if (cateManager.create(piccate.getName(), piccate.getComment(), piccate.getCover(), piccate.getMark()) > 0)
                return "admin/result/success";
        }
        return "admin/result/fail";
    }

    // 获取图像类别
    @SuppressWarnings("unchecked")
    private List<PicCate> getAllCate() {
        ArrayList<PicCate> cates = (ArrayList<PicCate>) cateManager.getAll();
        return cates;
    }

}
