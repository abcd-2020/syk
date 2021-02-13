package board.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	private static DbConnect db = new DbConnect();
	
	private String driver = "oracle.jdbc.driver.OracleDriver";//����Ŭ �� ����̹� ��
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";//�α��ο� �ʿ��� ���� �ּ� �� sid
    //ctrl+alt+del �۾������� ������, ����Ŭ ���� �� �ڿ� ���� �پ�����...
	private DbConnect() {
	}

	public static DbConnect getInstance() {
		return db;
	}

	public Connection conn() {
		Connection conn = null;
		try {
			Class.forName(driver);//����̹� �ε�
			conn = DriverManager.getConnection(url, "hr", "hr");//db������ ����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
