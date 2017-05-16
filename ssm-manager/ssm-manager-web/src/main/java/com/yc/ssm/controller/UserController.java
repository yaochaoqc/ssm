package com.yc.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.ssm.entity.User;
import com.yc.ssm.service.IUserService;

@Controller(value="userController")
@RequestMapping("/user")
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource(name="userService")
	private IUserService userService;
	
	@RequestMapping(value="/index")
    public String index(HttpServletRequest request,Model model){
        return "user/index";
    }

	@RequestMapping(value="/getLogin",method=RequestMethod.GET)
    public String getLogin(HttpServletRequest request,Model model){
        return "user/login/login";
    }
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request,Model model){

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User user = userService.login(userName, password);
        
        List<User> users = userService.obtainUsers(null);
        
        System.out.println(users.size());
        
        log.debug(user.toString());
        model.addAttribute("user", user);
        model.addAttribute("users", users);
        return "user/welcome/welcome";
    }
	
	@RequestMapping(value="/getRegister",method=RequestMethod.GET)
    public String getRegister(HttpServletRequest request,Model model){
        return "user/register/register";
    }
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
    public String register(HttpServletRequest request,Model model){

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        User user = userService.register(userName, password);
//        log.debug(user.toString());
        model.addAttribute("user", user);
        return "user/welcome/welcome";
    }
	
	@ResponseBody
	@RequestMapping(value="/doPostDel",method=RequestMethod.POST)//,consumes="application/json; charset=UTF-8"
    public Map<String, String> doPostDel(HttpServletRequest request,Model model,@RequestParam("userId")String userId){
		Integer num = userService.delUserById(userId);
		String fag = "";
		if (num>0) {
			fag = "ok";
		}else {
			fag = "no";
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("fag", fag);
		map.put("userId", userId);
		return map;
    }
	
	@ResponseBody
	@RequestMapping(value="/doGetDel",method=RequestMethod.GET)
	public String doGetDel(HttpServletRequest request,Model model,String userId) {
		
		
		return "ok";
	}

	@RequestMapping(value = "/upload")
	public String showUploadPage() {
		return "user_admin/file";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			log.info("Process file:{}", file.getOriginalFilename());
		}
		FileUtils.copyInputStreamToFile(file.getInputStream(),
				new File("E:\\", System.currentTimeMillis() + file.getOriginalFilename()));
		return "succes";
	}
}