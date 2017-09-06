package com.eric.spring.controller;
/**
 * API的輸出在此定義
 * @author yung.ho
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.spring.dao.ProfileDAO;
import com.eric.spring.model.ProfileModel;

@RestController
public class ProfileRestController {

	@Autowired
	private ProfileDAO profileDAO;
	
	@GetMapping("/profileList")
	public List<ProfileModel> getProfileList() {
		return profileDAO.queryAll();
	}
}
