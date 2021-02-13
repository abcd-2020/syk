package board.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board.conn.DbConnect;

public class DaoImpl implements Dao {
	private DbConnect db;

	public DaoImpl() {
		db = DbConnect.getInstance();
	}

	@Override
	public void insert(Board b) {
		// TODO Auto-generated method stub
		Connection conn = db.conn(); // db ø¨∞·
		String sql = "insert into board values(seq_board.nextval,?,sysdate,?,?)";

		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());

			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "¡Ÿ insert µ ");
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
	public ArrayList<Board> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		String sql = "select * from board order by num";
		Connection conn = db.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board b = new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
				list.add(b);
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
		return list;
	}

	@Override
	public Board selectByNum(int num) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		String sql = "select * from board where num=?";
		Connection conn = db.conn();
		Board b = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				b = new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
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
		return b;
	}

	@Override
	public ArrayList<Board> selectByWriter(String writer) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		String sql = "select * from board where writer=?";
		Connection conn = db.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
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
		return list;
	}

	@Override
	public ArrayList<Board> selectByTitle(String title) {
		// TODO Auto-generated method stub
		ArrayList<Board> list = new ArrayList<Board>();
		ResultSet rs = null;
		String sql = "select * from board where title like ?";
		Connection conn = db.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
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
		return list;
	}

	@Override
	public void update(Board b) {
		// TODO Auto-generated method stub
		Connection conn = db.conn(); // db ø¨∞·
		String sql = "update board set w_date=sysdate, title=?, content=? where num=?";

		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "¡Ÿ update µ ");
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
	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.conn(); // db ø¨∞·
		String sql = "delete board where num=?";

		int cnt = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "¡Ÿ delete µ ");
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
