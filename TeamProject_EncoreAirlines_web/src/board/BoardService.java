package board;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import resources.Factory;
import java.util.Scanner;


import board.BoardMapper;


public class BoardService {
	private SqlSessionFactory sqlSessionFactory;

	public BoardService() {
		sqlSessionFactory = Factory.getSqlSessionFactory();
	}

	public void addBoard(Board b) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		BoardMapper mapper = (BoardMapper) session.getMapper(BoardMapper.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.insert(b);
		session.commit();
		session.close();
	}

	public ArrayList<Board> getAll() {
		SqlSession session = sqlSessionFactory.openSession();// session open
		BoardMapper mapper = (BoardMapper) session.getMapper(BoardMapper.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		ArrayList<Board> list = mapper.selectAll();
		session.close();
		return list;
	}
	public Board getByNum(int num) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		BoardMapper mapper = (BoardMapper) session.getMapper(BoardMapper.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		Board b = mapper.selectByNum(num);
		session.close();
		return b;
	}
	public ArrayList<Board> getByWriter(String writer) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		BoardMapper mapper = (BoardMapper) session.getMapper(BoardMapper.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		ArrayList<Board> list = mapper.selectByWriter(writer);
		session.close();
		return list;
	}
	public ArrayList<Board> getByTitle(String title) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		BoardMapper mapper = (BoardMapper) session.getMapper(BoardMapper.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		ArrayList<Board> list = mapper.selectByTitle("%" + title + "%");
		session.close();
		return list;
	}

	public void editBoard(Board b) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		BoardMapper mapper = (BoardMapper) session.getMapper(BoardMapper.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.update(b);
		session.commit();
		session.close();
	}

	public void delBoard(int num) {
		SqlSession session = sqlSessionFactory.openSession();// session open
		BoardMapper mapper = (BoardMapper) session.getMapper(BoardMapper.class);// session¿ª ≈Î«ÿ ∏ ∆€ ∞¥√º »πµÊ
		mapper.delete(num);
		session.commit();
		session.close();
	}
	
	public ArrayList<Integer> badBoardNum(){
		SqlSession session = sqlSessionFactory.openSession();
		BoardMapper mapper = (BoardMapper)session.getMapper(BoardMapper.class);
		ArrayList<Integer> list = mapper.badBoardNum();
		session.close();
		return list;
	}
}
