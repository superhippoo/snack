package com.snack.Entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "sd_board")
public class BoardEntity {	
 
    @Id
    @Column
	private String brdNo;
	@Column
	private String val_yn;
    @Column
	private String title;
    @Column
	private String brd_type;
    @Column
	private String reg_id;
    @Column
	private String mdfy_id;
    @Column
	private Timestamp reg_dt;
    @Column
	private Timestamp mdfy_dt;	

    
    public String getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(String brdNo) {
		this.brdNo = brdNo;
	}
	public String getVal_yn() {
		return val_yn;
	}
	public void setVal_yn(String val_yn) {
		this.val_yn = val_yn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrd_type() {
		return brd_type;
	}
	public void setBrd_type(String brd_type) {
		this.brd_type = brd_type;
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

}
