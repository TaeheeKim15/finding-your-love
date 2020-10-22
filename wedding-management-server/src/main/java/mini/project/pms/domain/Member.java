package mini.project.pms.domain;

import java.sql.Date;

public class Member {
	private String id;
	private String password;
	private String name;
	private int gender;
	private int age;
	private String tel;
	private String hobby;
	private int personal;
	private String mbti;

	public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  private Date registeredDate;

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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getPersonal() {
		return personal;
	}
	public void setPersonal(int personal) {
		this.personal = personal;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public Date getRegisteredDate() {
	  return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
	  this.registeredDate = registeredDate;
	}

}
