package tickets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookedtickets.BookedTickets;
import bookedtickets.BookedTicketsService;

/**
 * Servlet implementation class TicketCheckInController
 */
@WebServlet("/TicketCheckIn")
public class TicketCheckInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketCheckInController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//booked table state 칼럼 update 
		HttpSession session = request.getSession(); 
		//String id = (String)session.getAttribute("id");
		
		//String id = (String)session.getAttribute("customer_id");
		//아이디로 booked table 검색
		BookedTicketsService service = new BookedTicketsService();
		ArrayList<BookedTickets> bookedlist = new ArrayList<BookedTickets>();
		bookedlist = service.getBookedTickets();
		session.removeAttribute("bookedlist");
		session.setAttribute("bookedlist", bookedlist);
		
		response.sendRedirect("Home/emp/emp_checkIn.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(); 
		//String id = (String)session.getAttribute("id");
		
		//String id = (String)session.getAttribute("customer_id");
		//아이디로 booked table 검색
		BookedTicketsService service = new BookedTicketsService();
		ArrayList<BookedTickets> bookedlist = new ArrayList<BookedTickets>();
		bookedlist = service.getBookedTickets();
		session.removeAttribute("bookedlist");
		session.setAttribute("bookedlist", bookedlist);
		
		response.sendRedirect("Home/emp/emp_checkIn.jsp");
		
		//Enumeration<String> temp = session.getAttributeNames();
		
	/*	HttpSession session = request.getSession();
		String flightNum = (String)session.getAttribute("flightNum");
		String id = (String)session.getAttribute("customer_id");
		
		BookedTicketsService service = new BookedTicketsService();
		BookedTickets b = service.checkIn(id, flightNum);
		*/
		
	}

}
