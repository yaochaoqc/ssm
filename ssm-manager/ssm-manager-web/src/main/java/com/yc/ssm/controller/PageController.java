package com.yc.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value="pageController")
@RequestMapping("/page")
public class PageController {
	private static Logger log = LoggerFactory.getLogger(PageController.class);
	
	@RequestMapping(value="/index")
    public String index(HttpServletRequest request,Model model){
        return "index";
    }
	
	@RequestMapping(value="/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}