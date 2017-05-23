package com.dxc.zurich.zip.web.service;

import java.util.List;

import com.dxc.zurich.innovation.entity.Idea;

public interface IIdeaService {
	public List<Idea> getIdeasPostedByUser(String username);
}
