package com.snack.dto;

import java.sql.Timestamp;

public class familyVO {
	
	private String fuid;
	private String uid;
	private String fcode;
	private String membername;
	private String title;
	private String color;
	private int sequence;
	private String base_yn;
	private String open_yn; //오너만 수정가능
	private String vld_stat; //오너만 수정가능 Y or N, 초대시에  S
	private String reg_id;
	private String mdfy_id;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;	
	private String message; 
	private String inviteemail;
	private String confirm_yn;
	
	public String getFuid() {
		return fuid;
	}
	public void setFuid(String fuid) {
		this.fuid = fuid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFcode() {
		return fcode;
	}
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getBase_yn() {
		return base_yn;
	}
	public void setBase_yn(String base_yn) {
		this.base_yn = base_yn;
	}
	public String getOpen_yn() {
		return open_yn;
	}
	public void setOpen_yn(String open_yn) {
		this.open_yn = open_yn;
	}
	public String getVld_stat() {
		return vld_stat;
	}
	public void setVld_stat(String vld_stat) {
		this.vld_stat = vld_stat;
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
	public String getInviteemail() {
		return inviteemail;
	}
	public void setInviteemail(String inviteemail) {
		this.inviteemail = inviteemail;
	}
	public String getConfirm_yn() {
		return confirm_yn;
	}
	public void setConfirm_yn(String confirm_yn) {
		this.confirm_yn = confirm_yn;
	}
	
}
