package cn.lijiahao.demo.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class Moments implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3675988270198559976L;
	private String id;
	private String sys_uid;
	private String sys_cid;
	private String title;
	private String image;
	private String content;
	private Timestamp time;
	private String slogan;
	private int amountOfReading;//阅读量
	private int isdelete;//是否删除
	private String transpondBy;
	/*private List<Comments> comments;//评论
	private List<Category> categorys;//文章类型*/
	/*以下数据不存在与相对应数据库*/
	private String authorName;
	private String categoryName;
	private String transpondByName;
	
	public Moments() {
		super();
	}
	
	
	
	public Moments(String id, String sys_uid, String sys_cid, String title, String image, String content,
			Timestamp time, String slogan, int amountOfReading, int isdelete, String transpondBy) {
		super();
		this.id = id;
		this.sys_uid = sys_uid;
		this.sys_cid = sys_cid;
		this.title = title;
		this.image = image;
		this.content = content;
		this.time = time;
		this.slogan = slogan;
		this.amountOfReading = amountOfReading;
		this.isdelete = isdelete;
		this.transpondBy = transpondBy;
	}



	public Moments(String id, String sys_uid, String sys_cid, String title, String image, String content,
			Timestamp time, String slogan, int amountOfReading, int isdelete) {
		super();
		this.id = id;
		this.sys_uid = sys_uid;
		this.sys_cid = sys_cid;
		this.title = title;
		this.image = image;
		this.content = content;
		this.time = time;
		this.slogan = slogan;
		this.amountOfReading = amountOfReading;
		this.isdelete = isdelete;
	}



	public Moments(String id, String sys_uid, String sys_cid, String title,String slogan, String content, Timestamp time) {
		super();
		this.id = id;
		this.sys_uid = sys_uid;
		this.sys_cid = sys_cid;
		this.title = title;
		this.slogan = slogan;
		this.content = content;
		this.time = time;
	}

	
	public String getTranspondByName() {
		return transpondByName;
	}



	public void setTranspondByName(String transpondByName) {
		this.transpondByName = transpondByName;
	}



	public String getAuthorName() {
		return authorName;
	}



	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getTranspondBy() {
		return transpondBy;
	}



	public void setTranspondBy(String transpondBy) {
		this.transpondBy = transpondBy;
	}



	public String getSys_cid() {
		return sys_cid;
	}

	public void setSys_cid(String sys_cid) {
		this.sys_cid = sys_cid;
	}
	
	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	/*public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getAmountOfReading() {
		return amountOfReading;
	}
	public void setAmountOfReading(int amountOfReading) {
		this.amountOfReading = amountOfReading;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	
	
}
