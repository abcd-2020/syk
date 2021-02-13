package procTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import board.conn.DbConnect;
import oracle.jdbc.OracleTypes;

public class Test1Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DbConnect.getInstance().conn();
			if (conn != null) {
				try {
					String sql = "{call test1(?,?)}";
					CallableStatement cstmt = conn.prepareCall(sql);
					cstmt.setString(1, "Kochhar"); //in parameter 매칭
					cstmt.registerOutParameter(2, OracleTypes.NVARCHAR); //out parameter 매칭
					cstmt.execute(); //sql싫행
					String name = (String) cstmt.getObject(2); //getobject로 업캐스팅한걸 cstmt로 다운캐스팅
					System.out.println(name);
					cstmt.close();
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
