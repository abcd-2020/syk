package board.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

	private static DbConnect db = new DbConnect();
	
	private String driver = "oracle.jdbc.driver.OracleDriver";//오라클 용 드라이버 명
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";//로그인에 필요한 서버 주소 및 sid
    //ctrl+alt+del 작업관리자 서비스탭, 오라클 서비스 탭 뒤에 뭐가 붙어있음...
	private DbConnect() {
	}

	public static DbConnect getInstance() {
		return db;
	}

	public Connection conn() {
		Connection conn = null;
		try {
			Class.forName(driver);//드라이버 로드
			conn = DriverManager.getConnection(url, "hr", "hr");//db서버에 접속
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
