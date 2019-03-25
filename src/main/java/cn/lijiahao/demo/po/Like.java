package cn.lijiahao.demo.po;

import java.io.Serializable;

public class Like implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8357245054835534325L;
	private String id;
	private String sys_uid;
	private String sys_mid;
	private int islike;//是否喜欢，1为喜欢
	
	//private Moments moment;
	public Like(String id, String sys_uid, String sys_mid, int islike) {
		super();
		this.id = id;
		this.sys_uid = sys_uid;
		this.sys_mid = sys_mid;
		this.islike = islike;
	}
	public Like() {
		super();
	}
	
	/*public Moments getMoment() {
		return moment;
	}
	public void setMoment(Moments moment) {
		this.moment = moment;
	}*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSys_uid() {
		return sys_uid;
	}
	public void setSys_uid(String sys_uid) {
		this.sys_uid = sys_uid;
	}
	public String getSys_mid() {
		return sys_mid;
	}
	public void setSys_mid(String sys_mid) {
		this.sys_mid = sys_mid;
	}
	public int getIslike() {
		return islike;
	}
	public void setIslike(int islike) {
		this.islike = islike;
	}
	
	
}
