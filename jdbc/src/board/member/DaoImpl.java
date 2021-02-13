package board.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.conn.DbConnect;

public class DaoImpl implements Dao {

	private DbConnect db;

	public DaoImpl() {
		db = DbConnect.getInstance();
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		Connection conn = db.conn(); //db 연결
		String sql = "insert into member values(?,?,?,?)";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//실행할 sql문으로 preparedstatement 객체 생성
			//물음표 매칭
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			
			//sql 실행
			cnt = pstmt.executeUpdate();//executeUpdate(): 쓰기작업(insert, update, delete) 실행 => 적용된 줄수 반환(int)
										//executeQuery(): 읽기작업(select) 실행 => 검색결과 반환(ResultSet)
			System.out.println(cnt + "줄 insert 됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Member select(String id) {
		// TODO Auto-generated method stub
		Connection conn = db.conn(); //db 연결
		String sql = "select * from member where id=?";
		ResultSet rs = null;//검색 결과 담을 변수
		Member m = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//1줄 검색되거나 없거나. //rjatorgksms rlsmd
			
			if(rs.next()) {//검색한 한줄이 있냐? 있으면 true, 없으면 false /rs.next/검색한 줄...
//				String id2 = rs.getString(1);//현재 행의 1번 컬럼값 읽음
//				String pwd = rs.getString(2);//현재 행의 2번 컬럼값 읽음
//				String name = rs.getString(3);//현재 행의 3번 컬럼값 읽음
//				String email = rs.getString(4);//현재 행의 4번 컬럼값 읽음
//				m = new Member(id2, pwd, name, email);
				m = new Member(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return m;
	}

	@Override
	public void update(String id, String new_pwd) {
		// TODO Auto-generated method stub
		Connection conn = db.conn(); //db 연결
		String sql = "update member set pwd=? where id=?";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//실행할 sql문으로 preparedstatement 객체 생성
			//물음표 매칭
			pstmt.setString(1, new_pwd);
			pstmt.setString(2, id);
			
			//sql 실행
			cnt = pstmt.executeUpdate();//executeUpdate(): 쓰기작업(insert, update, delete) 실행 => 적용된 줄수 반환(int)
										//executeQuery(): 읽기작업(select) 실행 => 검색결과 반환(ResultSet)
			System.out.println(cnt + "줄 update 됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Connection conn = db.conn(); //db 연결
		String sql = "delete member where id=?";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//실행할 sql문으로 preparedstatement 객체 생성
			//물음표 매칭
			pstmt.setString(1, id);
			
			//sql 실행
			cnt = pstmt.executeUpdate();//executeUpdate(): 쓰기작업(insert, update, delete) 실행 => 적용된 줄수 반환(int)
										//executeQuery(): 읽기작업(select) 실행 => 검색결과 반환(ResultSet)
			System.out.println(cnt + "줄 delete 됨");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
