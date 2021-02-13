package member;

import java.sql.Date;

//vo. 
public class Member {
	private String id;
	private String name;
	private String password;
	private String passportNum;
	private String type;
	private Date login_time;
	
	public Member() {
	}

	public Member(String id,String name, String password, String passportNum, String type, Date login_time) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.passportNum = passportNum;
		this.type = type;
		this.login_time = login_time;
	}



	
	
	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getpassportNum() {
		return passportNum;
	}

	public void setpassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", passportNum=" + passportNum + ", type=" + type
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj != null && obj instanceof Member) {
			if(((Member)obj).getId() == getId()) {
				return true;
			}
		}
		return false;
	}

}
