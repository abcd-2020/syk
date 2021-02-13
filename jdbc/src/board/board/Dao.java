package board.board;

import java.util.ArrayList;

public interface Dao {
	void insert(Board b); //글쓰기
	ArrayList<Board> selectAll(); //글검색
	Board selectByNum(int num); //정보확인에 필요.
	ArrayList<Board> selectByWriter(String writer); 
	ArrayList<Board> selectByTitle(String title);
	void update(Board b);//번호로 찾아서 날짜, 제목, 내용 수정
	void delete(int num);
}
