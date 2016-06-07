package controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.inter.UserBase;
import domain.User;

@Controller
@RequestMapping(value="/user")
public class UserBaseController {
	
	@Inject()
	UserBase userBase;
	
	@RequestMapping("")
	public String login(){
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(String username,String password,Model model){
		User user = userBase.validateUser(username, password);
		model.addAttribute("user",user.toString());
		return "detail";
	}
}
