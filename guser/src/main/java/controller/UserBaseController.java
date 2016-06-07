package controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.inter.UserService;
import dao.inter.UserBase;
import domain.User;

@Controller
@RequestMapping(value="/user")
public class UserBaseController {
	
	@Inject()
	UserService userService;
	
	@RequestMapping("")
	public String login(){
		return "home";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody User login(String username,String password){
		User user = userService.login(username, password);
		return user;
	}
	
	
	
	
}
