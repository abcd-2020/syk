package board;

import java.util.ArrayList;
import java.util.Scanner;

import board.board.Board;
import board.board.BoardService;
import board.board.BoardServiceImpl;
import board.member.MemService;
import board.member.MemServiceImpl;

public class Menu {
	private MemService memService;
	private BoardService bService;

	public Menu() {
		memService = new MemServiceImpl();
		bService = new BoardServiceImpl();
	}

	public void run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		while (flag) {
			System.out.println("1.회원관리 2.게시판 3.종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				mem_run(sc);
				break;
			case 2:
				if (MemServiceImpl.getLogin_id() == null) {
					System.out.println("로그인 먼저 하시오");
				}else {
					b_run(sc);
				}
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}

	public void mem_run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		while (flag) {
			System.out.println("1.회원가입 2.로그인 3.내정보확인 4.내정보수정 5.로그아웃 6.탈퇴 7.종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				memService.addMember(sc);
				break;
			case 2:
				memService.login(sc);
				break;
			case 3:
				memService.myInfo();
				break;
			case 4:
				memService.editInfo(sc);
				break;
			case 5:
				memService.logout(sc);
				break;
			case 6:
				memService.out();
				break;
			case 7:
				flag = false;
				break;
			}
		}
	}

	public void b_run(Scanner sc) {
		boolean flag = true;
		int menu = 0;
		ArrayList<Board> list = null;

		while (flag) {
			System.out.println("1.글작성 2.글목록 3.글번호로검색 4.글작성자로검색 5.글제목으로검색 6.수정 7.삭제 8.종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				bService.addBoard(sc);
				break;
			case 2:
				list = bService.getAll();
				bService.printAll(list);
				break;
			case 3:
				bService.getByNum(sc);
				break;
			case 4:
				list = bService.getByWriter(sc);
				bService.printAll(list);
				break;
			case 5:
				list = bService.getByTitle(sc);
				bService.printAll(list);
				break;
			case 6:
				bService.editBoard(sc);
				break;
			case 7:
				bService.delBoard(sc);
				break;
			case 8:
				flag = false;
				break;
			}
		}
	}
}
