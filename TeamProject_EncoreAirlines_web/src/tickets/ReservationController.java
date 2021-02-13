package tickets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookedtickets.BookedTickets;
import bookedtickets.BookedTicketsService;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet("/Reservation")
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
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
		String flight_num = request.getParameter("flightNum");
		int seat_num =  Integer.parseInt(request.getParameter("seatNum"));
		
		HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		
		//booked table insert 
		BookedTicketsService b_service = new BookedTicketsService();
		//b_service.addBookedTicket(new BookedTickets( "",flight_num, id, "N", seat_num));
		
		/*private String booked_num;//sequence
		private String state;//booked ticket state 
		private String flight_num;
		private String id;
		private int seat_count;*/
		
		//ticket table update 
		
		TicketsService service = new TicketsService();
		
		Tickets b = service.getTicket(flight_num);
		if(b != null) {
			b_service.addBookedTicket(new BookedTickets("", "N", flight_num, id, seat_num));
			int seat_cnt = b.getSeat_count() - seat_num;
			b.setSeat_count(seat_cnt);
			service.editTicket(b);
		}
		response.sendRedirect("Home/cust/cust_booking.jsp");
		
		
		
	}

}
