package board;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardService;

/**
 * Servlet implementation class AdminBoardController
 */
@WebServlet("/AdminBoardController")
public class AdminBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardService b_service = new BoardService();
		ArrayList<Board> bad_board = new ArrayList<>();
		
		ArrayList <Integer> bad_postings = b_service.badBoardNum();
		if(bad_postings.isEmpty()) {
			request.setAttribute("noBoards", "There's no bad posting on the board");
		}
		else {
			for (int p:bad_postings) {
				bad_board.add(b_service.getByNum(p));
			}
		}
		/*if(bad_replies.isEmpty()) {
			request.setAttribute("noReplies", "There's no bad reply on the board");
		}
		else {
			for (int r:bad_replies) {
				bad_reply.add(r_service.selectByNum(r));
			}
		}*/
		request.setAttribute("bad_board_list", bad_board);
		
		String url = "Home/admin/admin_deleteBoard.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardService b_service = new BoardService();
		//search bad postings & replies
		ArrayList <Integer> bad_postings = b_service.badBoardNum();
		//ArrayList <Integer> bad_replies = r_service.badReplyNum();
		//delete bad postings & replies
		for(int p: bad_postings) {
			b_service.delBoard(p);
		}
	/*	for(int r: bad_replies) {
			r_service.delete(r);
		}
		*/
		request.setAttribute("cleanBoard", (bad_postings.size()+" postings are deleted"));
		String url = "Home/admin/admin_account.jsp";

		response.sendRedirect(url);

		//RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		//dispatcher.forward(request, response);
		
		//Board(int board_id, String writer, Date w_date, String title, String content)
		//Reply(int reply_id, int board_id, String comments) 
		//int ok_board_id = Integer.parseInt(request.getParameter("board_id"));
		//int ok_reply_id = Integer.parseInt(request.getParameter("reply_id"));	
		//String ok_title = request.getParameter("title");
		//String ok_content = request.getParameter("content");
		//String ok_comments = request.getParameter("comments");
		
		/*Board bd = new Board(ok_board_id, null, null, ok_title, ok_content);
		b_service.update(bd);
		
		Reply rp = new Reply(ok_reply_id, 0, ok_comments);
		r_service.update(rp);*/
		
	}

}
