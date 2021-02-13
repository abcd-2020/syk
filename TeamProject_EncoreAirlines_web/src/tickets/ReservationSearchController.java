package tickets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookedtickets.BookedTickets;
import bookedtickets.BookedTicketsService;

/**
 * Servlet implementation class ReservationSearchController
 */
@WebServlet("/ReservationSearch")
public class ReservationSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationSearchController() {
        super();
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
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		BookedTicketsService service = new BookedTicketsService();
		//String tempString = (String)request.getAttribute("d_city");
		String bookedNum = request.getParameter("bookedNum");
		
		ArrayList<BookedTickets> bookedlist = null;
		bookedlist = new ArrayList<BookedTickets>(); 
		
		bookedlist = service.getBookedTickets();
		
		session.removeAttribute("bookedlist");
		session.setAttribute("bookedlist", bookedlist);
		
		response.sendRedirect("Home/cust/cust_bookingCancel.jsp");
		
	}

}
