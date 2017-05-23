package com.dxc.zurich.zip.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dxc.zurich.innovation.entity.Idea;
import com.dxc.zurich.zip.web.service.IIdeaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class MasterController {
	private final Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	@Autowired
	private IIdeaService ideaService = null;
	
	@RequestMapping(value = "/zip", method = RequestMethod.GET)
	public @ResponseBody String getIdeasPostedByUser(@RequestParam String username) throws Exception {
		logger.info("Fetching Ideas posted by User::"+username);
		List<Idea> ideasByUser = ideaService.getIdeasPostedByUser(username);
		
		Gson gson = new GsonBuilder().create();
		String questionsJSon = "{UserId:"+username+",Questions:"+gson.toJson(ideasByUser)+"}";
		
		return questionsJSon;
	}
}
