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
					cstmt.setString(1, "Kochhar"); //in parameter ��Ī
					cstmt.registerOutParameter(2, OracleTypes.NVARCHAR); //out parameter ��Ī
					cstmt.execute(); //sql����
					String name = (String) cstmt.getObject(2); //getobject�� ��ĳ�����Ѱ� cstmt�� �ٿ�ĳ����
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
