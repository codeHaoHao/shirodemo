package cn.lijiahao.demo.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class History implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3405173894068517408L;
	private String id;
	private String sys_uid;//用户id
	private String sys_mid;//文章id
	private Timestamp historyTime;//历史时间
	
	//private Moments moment;
	public History(String id, String sys_uid, String sys_mid, Timestamp historyTime) {
		super();
		this.id = id;
		this.sys_uid = sys_uid;
		this.sys_mid = sys_mid;
		this.historyTime = historyTime;
	}
	public History() {
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
	public Timestamp getHistoryTime() {
		return historyTime;
	}
	public void setHistoryTime(Timestamp historyTime) {
		this.historyTime = historyTime;
	}
	
	
}
