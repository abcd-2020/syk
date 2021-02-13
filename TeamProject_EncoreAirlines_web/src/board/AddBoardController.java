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
 * Servlet implementation class AddBoardController
 */
@WebServlet("/AddBoard")
public class AddBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("Home/cust/cust_boardAdd.jsp");
		dispatcher.forward(request, response);
		
		//response.sendRedirect("Home/cust/cust_boardAdd.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardService service = new BoardService();
		//System.out.println("HOLA!!!!");
		service.addBoard(new Board(0, writer, null, title, content));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/BoardList");
		dispatcher.forward(request, response);
		//System.out.println("HOLA!!!!2");
		//response.sendRedirect("/BoardList");
		//System.out.println("HOLA!!!!3");
	}

}
