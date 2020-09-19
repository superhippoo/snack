package com.snack.dto;

import java.sql.Timestamp;

public class userVO {
	
	private String uid;
	private String email;
	private String user_type;
	private String val_yn;
	private String push_yn;
	private String reg_id;
	private String mdfy_id;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;
	private String message;

	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getVal_yn() {
		return val_yn;
	}
	public void setVal_yn(String val_yn) {
		this.val_yn = val_yn;
	}
	public String getPush_yn() {
		return push_yn;
	}
	public void setPush_yn(String push_yn) {
		this.push_yn = push_yn;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getMdfy_id() {
		return mdfy_id;
	}
	public void setMdfy_id(String mdfy_id) {
		this.mdfy_id = mdfy_id;
	}
	public Timestamp getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Timestamp reg_dt) {
		this.reg_dt = reg_dt;
	}
	public Timestamp getMdfy_dt() {
		return mdfy_dt;
	}
	public void setMdfy_dt(Timestamp mdfy_dt) {
		this.mdfy_dt = mdfy_dt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
