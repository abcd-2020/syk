package board.board;

import java.util.ArrayList;

public interface Dao {
	void insert(Board b); //�۾���
	ArrayList<Board> selectAll(); //�۰˻�
	Board selectByNum(int num); //����Ȯ�ο� �ʿ�.
	ArrayList<Board> selectByWriter(String writer); 
	ArrayList<Board> selectByTitle(String title);
	void update(Board b);//��ȣ�� ã�Ƽ� ��¥, ����, ���� ����
	void delete(int num);
}
