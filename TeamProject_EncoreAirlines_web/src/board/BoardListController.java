package board;

import java.io.IOException;
import javax.servlet.http.HttpSession;
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
 * Servlet implementation class BoardListController
 */
@WebServlet("/BoardList")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = null;
		BoardService service = new BoardService();
		session = request.getSession();
		ArrayList<Board> list = service.getAll();
		session.setAttribute("list2", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home/cust/cust_boardList.jsp");
		dispatcher.forward(request, response);
		//response.sendRedirect("Home/cust/cust_boardList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
