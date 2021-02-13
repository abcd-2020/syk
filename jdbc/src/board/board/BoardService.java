package board.board;

import java.util.ArrayList;
import java.util.Scanner;

public interface BoardService {
	void addBoard(Scanner sc);//글작성
	void printAll(ArrayList<Board> list);//글목록(번호, 제목, 작성자)
	ArrayList<Board> getAll();
	void getByNum(Scanner sc);//글 번호 입력받아 검색
	ArrayList<Board> getByWriter(Scanner sc);//작성자 입력받아 작성자로 검색
	ArrayList<Board> getByTitle(Scanner sc);//제목 일부 입력받아 제목으로 검색
	void editBoard(Scanner sc);//번호, 새제목, 새내용 입력받아 수정
	void delBoard(Scanner sc);//글 번호 입력받아 삭제
}
