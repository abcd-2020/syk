package board.member;


//DAO = db �۾��� ��..
public interface Dao {
	
	void insert(Member m); //ȸ������ ��ɿ� �ʿ�. sevice����  id,pwd,name,email.�� Member ��ü�� ��Ƽ� insert() ȣ��=> db�� �����϶��....
	
	Member select(String id); //service�� login, ������ Ȯ��..��ɿ� �ʿ�..
	
	void update(String id, String new_pwd); // ������ ���� ��ɿ� �ʿ�..
	
	void delete(String id);//sevice�� Ż���ɿ� �ʿ�..
	
	
}
