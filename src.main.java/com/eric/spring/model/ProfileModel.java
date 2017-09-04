package com.eric.spring.model;

/**
 * 測試用的資料模型
 * @author yung.ho
 *
 */
public class ProfileModel {

	private Long pid;
	private String name;
	private String cellPhone;
	private int sex;
	
	public ProfileModel() {
		
	}
	
	public ProfileModel(Long pid, String name, String cellPhone, int sex) {
		super();
		this.pid = pid;
		this.name = name;
		this.cellPhone = cellPhone;
		this.sex = sex;
	}



	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
}
