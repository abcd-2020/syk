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
		Connection conn = db.conn(); //db ����
		String sql = "insert into member values(?,?,?,?)";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//������ sql������ preparedstatement ��ü ����
			//����ǥ ��Ī
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			
			//sql ����
			cnt = pstmt.executeUpdate();//executeUpdate(): �����۾�(insert, update, delete) ���� => ����� �ټ� ��ȯ(int)
										//executeQuery(): �б��۾�(select) ���� => �˻���� ��ȯ(ResultSet)
			System.out.println(cnt + "�� insert ��");
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
		Connection conn = db.conn(); //db ����
		String sql = "select * from member where id=?";
		ResultSet rs = null;//�˻� ��� ���� ����
		Member m = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//1�� �˻��ǰų� ���ų�. //rjatorgksms rlsmd
			
			if(rs.next()) {//�˻��� ������ �ֳ�? ������ true, ������ false /rs.next/�˻��� ��...
//				String id2 = rs.getString(1);//���� ���� 1�� �÷��� ����
//				String pwd = rs.getString(2);//���� ���� 2�� �÷��� ����
//				String name = rs.getString(3);//���� ���� 3�� �÷��� ����
//				String email = rs.getString(4);//���� ���� 4�� �÷��� ����
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
		Connection conn = db.conn(); //db ����
		String sql = "update member set pwd=? where id=?";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//������ sql������ preparedstatement ��ü ����
			//����ǥ ��Ī
			pstmt.setString(1, new_pwd);
			pstmt.setString(2, id);
			
			//sql ����
			cnt = pstmt.executeUpdate();//executeUpdate(): �����۾�(insert, update, delete) ���� => ����� �ټ� ��ȯ(int)
										//executeQuery(): �б��۾�(select) ���� => �˻���� ��ȯ(ResultSet)
			System.out.println(cnt + "�� update ��");
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
		Connection conn = db.conn(); //db ����
		String sql = "delete member where id=?";
		
		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);//������ sql������ preparedstatement ��ü ����
			//����ǥ ��Ī
			pstmt.setString(1, id);
			
			//sql ����
			cnt = pstmt.executeUpdate();//executeUpdate(): �����۾�(insert, update, delete) ���� => ����� �ټ� ��ȯ(int)
										//executeQuery(): �б��۾�(select) ���� => �˻���� ��ȯ(ResultSet)
			System.out.println(cnt + "�� delete ��");
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
