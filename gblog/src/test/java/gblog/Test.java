package gblog;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import algo.blog.service.inter.ImageService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("blog-service.xml");
		ImageService img = (ImageService)ctx.getBean("imageProvider");
		//System.out.println(img.getSize());
		System.out.println(System.currentTimeMillis());
		String name = "1234.jpg";
		String[] strs = name.split("\\.");
		System.out.println(strs.length);
	}

}
