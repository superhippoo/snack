package com.snack.dto;

import java.sql.Timestamp;

public class scheduleVO {
	
	private String sid;
	private String fuid;
	private Timestamp act_dt;
	private String fcode;
	private String evcode;
	private String title;
	private String content;
	private int pushterm;
	private String open_yn;
	private String open_range;
	private String place;
	private Timestamp startdate;
	private Timestamp enddate;
	private String reg_id;
	private String mdfy_id;
	private Timestamp reg_dt;
	private Timestamp mdfy_dt;

	private String isowner;
	private Timestamp searchstartdate;
	private Timestamp searchenddate;
	private String searchfcode;
	private String searcheruid;//°Ë»öÀÚ 

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getFuid() {
		return fuid;
	}
	public void setFuid(String fuid) {
		this.fuid = fuid;
	}
	public Timestamp getAct_dt() {
		return act_dt;
	}
	public void setAct_dt(Timestamp act_dt) {
		this.act_dt = act_dt;
	}
	public String getFcode() {
		return fcode;
	}
	public void setFcode(String fcode) {
		this.fcode = fcode;
	}
	public String getEvcode() {
		return evcode;
	}
	public void setEvcode(String evcode) {
		this.evcode = evcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPushterm() {
		return pushterm;
	}
	public void setPushterm(int pushterm) {
		this.pushterm = pushterm;
	}
	public String getOpen_yn() {
		return open_yn;
	}
	public void setOpen_yn(String open_yn) {
		this.open_yn = open_yn;
	}
	public String getOpen_range() {
		return open_range;
	}
	public void setOpen_range(String open_range) {
		this.open_range = open_range;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Timestamp getStartdate() {
		return startdate;
	}
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}
	public Timestamp getEnddate() {
		return enddate;
	}
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
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
	public String getIsowner() {
		return isowner;
	}
	public void setIsowner(String isowner) {
		this.isowner = isowner;
	}
	public Timestamp getSearchstartdate() {
		return searchstartdate;
	}
	public void setSearchstartdate(Timestamp searchstartdate) {
		this.searchstartdate = searchstartdate;
	}
	public Timestamp getSearchenddate() {
		return searchenddate;
	}
	public void setSearchenddate(Timestamp searchenddate) {
		this.searchenddate = searchenddate;
	}
	public String getSearchfcode() {
		return searchfcode;
	}
	public void setSearchfcode(String searchfcode) {
		this.searchfcode = searchfcode;
	}
	public String getSearcheruid() {
		return searcheruid;
	}
	public void setSearcheruid(String searcheruid) {
		this.searcheruid = searcheruid;
	}
}
