package cn.lijiahao.demo.po;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8959265236624915821L;
	private String id;
	private String name;
	
	
	//private List<Moments> moments;
	public Category(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Category() {
		super();
	}
	
	/*public List<Moments> getMoments() {
		return moments;
	}
	public void setMoments(List<Moments> moments) {
		this.moments = moments;
	}*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
