package cn.lijiahao.demo.po;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8992608302266751414L;
	private String id;
	private String username;
	private String password;
	private String name;
	private Timestamp dataOfBirth;//出生日期
	private int age;
	private String gender;
	private String salt;//盐
	private String locked;
	private String avatar;//头像
	private String individualResume;//个人简介
	
	/*private List<Moments> moments;//用户的文章
	private List<Moments> likeMoments;//用户喜欢的文章
	private List<History> history;//用户浏览历史
*/	
	
	public User(String id, String username, String password, String name, Timestamp dataOfBirth, int age, String gender,
			String salt, String locked) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.dataOfBirth = dataOfBirth;
		this.age = age;
		this.gender = gender;
		this.salt = salt;
		this.locked = locked;
	}
	public User(String id, String username, String password, String name, Timestamp dataOfBirth, int age, String gender,
			String salt, String locked, String avatar, String individualResume) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.dataOfBirth = dataOfBirth;
		this.age = age;
		this.gender = gender;
		this.salt = salt;
		this.locked = locked;
		this.avatar = avatar;
		this.individualResume = individualResume;
	}
	public User() {
		super();
	}
	
	/*public List<Moments> getMoments() {
		return moments;
	}
	public void setMoments(List<Moments> moments) {
		this.moments = moments;
	}
	public List<Moments> getLikeMoments() {
		return likeMoments;
	}
	public void setLikeMoments(List<Moments> likeMoments) {
		this.likeMoments = likeMoments;
	}
	public List<History> getHistory() {
		return history;
	}
	public void setHistory(List<History> history) {
		this.history = history;
	}*/
	
	public String getSalt() {
		return salt;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getIndividualResume() {
		return individualResume;
	}
	public void setIndividualResume(String individualResume) {
		this.individualResume = individualResume;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDataOfBirth() {
		return dataOfBirth;
	}
	public void setDataOfBirth(Timestamp dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
