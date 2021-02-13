  package board.board;

import java.util.ArrayList;
import java.util.Scanner;

import board.member.MemServiceImpl;

public class BoardServiceImpl implements BoardService {
	private Dao dao;

	public BoardServiceImpl() {
		dao = new DaoImpl();
	}

	@Override
	public void addBoard(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====글작성====");

		Board b = new Board();
		b.setWriter(MemServiceImpl.getLogin_id());

		System.out.print("title:");
		sc.nextLine(); // 버퍼에엔터로 남아있는값이 휙 넘어가니까 방지하기 위해
		String title = sc.nextLine();

		System.out.print("content(멈추려면 /stop):");
		StringBuilder st = new StringBuilder();
		while (true) {
			String str = sc.nextLine();
			if (str.startsWith("/stop")) {
				break;
			}
			st.append(str + "\n");
		}

		String content = st.toString();
		b.setTitle(title);
		b.setContent(content);
		dao.insert(b);
	}

	@Override
	public void printAll(ArrayList<Board> list) {
		// TODO Auto-generated method stub
		for (Board b : list) {
			System.out.println(b);
		}

	}

	@Override
	public void getByNum(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====글 번호로 검색====");
		System.out.print("검색할 글번호:");
		int num = sc.nextInt();
		Board b = dao.selectByNum(num);
		if (b == null) {
			System.out.println("없는 글번호");
		} else {
			System.out.println(b);
		}
	}

	@Override
	public ArrayList<Board> getByWriter(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====글 작성자로 검색====");
		System.out.print("검색할 작성자 아이디:");
		String writer = sc.next();
		ArrayList<Board> list = dao.selectByWriter(writer);
		return list;
	}

	@Override
	public ArrayList<Board> getByTitle(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====글 제목으로 검색====");
		System.out.print("검색할 단어:");
		String title = sc.next();
		ArrayList<Board> list = dao.selectByTitle(title);
		return list;
	}

	public boolean checkMyArticle(int num) {//로그인 한 사람의 글인지 체크
		Board b = dao.selectByNum(num);
		if (b != null && b.getWriter().equals(MemServiceImpl.getLogin_id())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void editBoard(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====글 수정====");
		System.out.print("수정할 글번호:");
		int num = sc.nextInt();
		boolean flag = checkMyArticle(num);
		if (flag) {
			System.out.print("새 제목:");
			String title = sc.next();
			System.out.print("새 내용:");
			String content = sc.next();
			dao.update(new Board(num, "", null, title, content));
		} else {
			System.out.println("없는 글이거나 본인 글이 아님");
		}
	}

	@Override
	public void delBoard(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("====글 삭제====");
		System.out.print("삭제할 글번호:");
		int num = sc.nextInt();
		boolean flag = checkMyArticle(num);
		if (flag) {
			dao.delete(num);
		} else {
			System.out.println("없는 글이거나 본인 글이 아님");
		}
	}

	@Override
	public ArrayList<Board> getAll() {
		// TODO Auto-generated method stub
		System.out.println("====글 전체목록====");
		ArrayList<Board> list = dao.selectAll();
		return list;
	}

}
