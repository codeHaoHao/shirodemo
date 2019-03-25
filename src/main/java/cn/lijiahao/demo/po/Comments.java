package cn.lijiahao.demo.po;

import java.io.Serializable;

public class Comments implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4617836166005005634L;
	private String id;
	private String sys_mid;//文章id
	private String sys_uid;//用户id
	private String content;//评论内容
	private String isdelete;//是否删除
	
	private User user;
	public Comments(String id, String sys_mid, String sys_uid, String content, String isdelete) {
		super();
		this.id = id;
		this.sys_mid = sys_mid;
		this.sys_uid = sys_uid;
		this.content = content;
		this.isdelete = isdelete;
	}
	public Comments() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSys_mid() {
		return sys_mid;
	}
	public void setSys_mid(String sys_mid) {
		this.sys_mid = sys_mid;
	}
	public String getSys_uid() {
		return sys_uid;
	}
	public void setSys_uid(String sys_uid) {
		this.sys_uid = sys_uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}
	
	
}
