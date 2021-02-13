package board.member;

import javax.swing.plaf.basic.BasicBorders.MenuBarBorder;

//vo = value object== 관련된 정보를 하나로 묶어준다....
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	
	public Member() {}
	public Member(String id, String pwd, String name, String email) {
		
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
} 
