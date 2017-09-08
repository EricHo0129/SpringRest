package com.eric.spring.controller;
/**
 * API的輸出在此定義
 * @author yung.ho
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eric.spring.dao.ProfileDAO;
import com.eric.spring.model.ProfileModel;

@RestController
public class ProfileRestController {

	@Autowired
	private ProfileDAO profileDAO;
	
	/*這種寫法無法控制回傳status,但吐出去一樣是JSON*/
	@GetMapping("/profiles")
	public List<ProfileModel> getProfiles() {
		return profileDAO.queryAll();
	}
	
	@GetMapping("/profileList")
	public ResponseEntity<List<ProfileModel>> getProfileList() {
		return new ResponseEntity<List<ProfileModel>>(profileDAO.queryAll(), HttpStatus.OK);
	}
	
	@GetMapping("/profile/{pid}")
	public ResponseEntity<ProfileModel> getProfile(@PathVariable("pid") Long pid) {
		//return profileDAO.queryOne(pid);
		return new ResponseEntity<ProfileModel>(profileDAO.queryOne(pid), HttpStatus.OK);
	}
	
	@DeleteMapping("/profile/{pid}")
	public ResponseEntity<Boolean> deleteProfile(@PathVariable("pid") Long pid) {
		return new ResponseEntity<Boolean>( profileDAO.delete(pid), HttpStatus.OK);
	}
}
