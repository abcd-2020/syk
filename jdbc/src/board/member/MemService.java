package board.member;

import java.util.Scanner;

public interface MemService {
	void addMember(Scanner sc);
	void login(Scanner sc);
	void logout(Scanner sc);
	boolean myInfo();
	void editInfo(Scanner sc);
	void out();
	boolean loginCheck();
}
