package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.Board;
import board.BoardService;

/**
 * Servlet implementation class BoardReadController
 */
@WebServlet("/BoardRead")
public class BoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReadController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		BoardService service = new BoardService();
		Board b = service.getByNum(board_id);
		request.setAttribute("b", b);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home/cust/cust_boardRUD.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		BoardService service = new BoardService();
		service.editBoard(new Board(board_id, "", null, title, content));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BoardList");
		dispatcher.forward(request, response);
	}


}
