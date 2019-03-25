package cn.lijiahao.demo.po;

public class Role {
	private String id;
	private String name;
	private String available;
	
	
	public Role() {
		super();
	}
	public Role(String id, String name, String available) {
		super();
		this.id = id;
		this.name = name;
		this.available = available;
	}
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
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	
}
