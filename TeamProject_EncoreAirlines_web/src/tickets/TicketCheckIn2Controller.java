package tickets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookedtickets.BookedTicketsService;

/**
 * Servlet implementation class TicketCheckIn2Controller
 */
@WebServlet("/TicketCheckIn2")
public class TicketCheckIn2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketCheckIn2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 2개 가지고 와서 booked table state update
		HttpSession session = request.getSession();
		
	/*	String _id = (String)session.getAttribute("customer_id");
		String _flightNum = (String)session.getAttribute("flightNum");
		*/
		
		String _id = request.getParameter("customer_id");
		String _flightNum = request.getParameter("flightNum");
		BookedTicketsService service = new BookedTicketsService();
		
		service.checkIn(_id, _flightNum);
		
		
	}

}
