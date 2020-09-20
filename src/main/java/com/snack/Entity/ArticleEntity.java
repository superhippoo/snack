package com.snack.Entity;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "sd_article")
public class ArticleEntity {	

	@Id
    @Column
	private String article_id;
	@Column
	private String brdNo;
	@Column
	private String title;
    @Column
	private String content;
    @Column
	private String val_yn;
    @Column
	private String reg_id;
    @Column
	private String mdfy_id;
    @Column
	private Timestamp reg_dt;
    @Column
	private Timestamp mdfy_dt;	

	
    public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getBrdNo() {
		return brdNo;
	}
	public void setBrdNo(String brdNo) {
		this.brdNo = brdNo;
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
	public String getVal_yn() {
		return val_yn;
	}
	public void setVal_yn(String val_yn) {
		this.val_yn = val_yn;
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
