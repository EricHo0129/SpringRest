package com.eric.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import com.eric.spring.model.ProfileModel;

/**
 * 模擬的資料存取物件
 * @author yung.ho
 *
 */
@Component
public class ProfileDAO {

	private static List<ProfileModel> profileList = new ArrayList<ProfileModel>();
	
	{
		profileList.add(new ProfileModel(100024L, "旗木卡卡西", "0925-223478", 1));
		profileList.add(new ProfileModel(100068L, "木葉警備隊", "0922-412307", 0));
		profileList.add(new ProfileModel(100019L, "宇智波佐助", "0931-350560", 1));
		profileList.add(new ProfileModel(100060L, "自來也", "0920-578717", 1));
		profileList.add(new ProfileModel(100068L, "木葉糾察隊", "0933-354540", 0));
	}
	
	public List<ProfileModel> queryAll() {
		return profileList;
	}
	
	public ProfileModel queryOne(Long pid) {
		for (ProfileModel profile: profileList) {
			if (pid.longValue() == profile.getPid().longValue()) {
				return profile;
			}
		}
		return null;
	}
	
	public boolean create(ProfileModel profile) {
		if (queryOne(profile.getPid()) == null) {
			profileList.add(profile);
		}
		return true;
	}
	
	public boolean delete (Long pid) {
		for (ProfileModel profile: profileList) {
			if (pid.longValue() == profile.getPid().longValue()) {
				profileList.remove(profile);
				return true;
			}
		}
		return false;
	}
	
	public boolean update (ProfileModel profile) {
		ProfileModel existProfile = queryOne(profile.getPid());
		if (existProfile != null) {
			try {				
				BeanUtils.copyProperties(existProfile, profile);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}
}
