package board.member;


//DAO = db 작업만 함..
public interface Dao {
	
	void insert(Member m); //회원가입 기능에 필요. sevice에서  id,pwd,name,email.을 Member 객체에 담아서 insert() 호출=> db에 저장하라고....
	
	Member select(String id); //service의 login, 내정보 확인..기능에 필요..
	
	void update(String id, String new_pwd); // 내정보 수정 기능에 필요..
	
	void delete(String id);//sevice의 탈퇴기능에 필요..
	
	
}
