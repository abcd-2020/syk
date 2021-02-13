package board.member;

import java.util.Scanner;

//ȸ�� ��Ʈ ��� ����
public class MemServiceImpl implements MemService {
	private Dao dao;
	private static String login_id = null;// null:�α��ξȵȻ���, ����������:�α��λ���

	public MemServiceImpl() {
		dao = new DaoImpl();
	}

	public static String getLogin_id() {
		return login_id;
	}

	@Override
	public void addMember(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====ȸ������====");
		// ȸ�����Կ� �ʿ��� ���� �Է�
		String id = "";
		Member m = null;
		do {
			System.out.print("id:");
			id = sc.next();
			m = dao.select(id);
		} while (m != null);

		System.out.print("pwd:");
		String pwd = sc.next();
		System.out.print("name:");
		String name = sc.next();
		System.out.print("email:");
		String email = sc.next();

		// dao�� insert�� �Է��� ���� ��������
		dao.insert(new Member(id, pwd, name, email));
	}

	@Override
	public void login(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====�α���====");
		if(loginCheck()) {
			System.out.println("�α�����");
			return;
		}
		System.out.print("id:");
		String id = sc.next();
		System.out.print("pwd:");
		String pwd = sc.next();

		Member m = dao.select(id);
		if (m == null) {
			System.out.println("���� ���̵�");
		} else {
			if (pwd.equals(m.getPwd())) {
				System.out.println("�α��� ����");
				login_id = id;
			} else {
				System.out.println("�н����� ����ġ");
			}
		}
	}

	@Override
	public void logout(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====�α׾ƿ�====");
		if (loginCheck()) {
			login_id = null;// �α׾ƿ� ó��
		} else {
			System.out.println("�α��� ����");
		}
	}

	@Override
	public boolean myInfo() {
		// TODO Auto-generated method stub
		System.out.println("====������ Ȯ��====");
		if (loginCheck()) {
			Member m = dao.select(login_id);
			System.out.println(m);
			return true;
		} else {
			System.out.println("�α��� ����");
			return false;
		}
	}

	@Override
	public void editInfo(Scanner sc) {
		// TODO Auto-generated method stub
		boolean flag = myInfo();
		if (flag) {
			System.out.println("====������ ����====");
			System.out.print("new pwd:");
			String pwd = sc.next();
			dao.update(login_id, pwd);
		}
	}

	@Override
	public void out() {
		// TODO Auto-generated method stub
		System.out.println("====Ż��====");
		if (loginCheck()) {
			dao.delete(login_id);
			login_id = null;// �α׾ƿ� ó��
		} else {
			System.out.println("�α��� ����");
		}
	}

	@Override
	public boolean loginCheck() {
		// TODO Auto-generated method stub
		if (login_id == null) {
			return false;
		} else {
			return true;
		}
	}

}