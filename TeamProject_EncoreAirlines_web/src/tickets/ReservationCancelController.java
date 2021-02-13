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
import tickets.Tickets;
import tickets.TicketsService;

//delete of my booked flight ticket

/**
 * Servlet implementation class BookedTicketDel
 */
@WebServlet("/ReservationCancel")
public class ReservationCancelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCancelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookedTicketsService b_service = new BookedTicketsService();
		TicketsService service = new TicketsService();
		
		HttpSession session = request.getSession();
		
		//session 에서 가져와야 함 
		//seat num 어디서 들고옴? 
		
		/*int seat_num =  (Integer)session.getAttribute("seatCount");
		String booked_num = (String) session.getAttribute("bookedNum");*/
		
		Object test = request.getParameter("seatCount");
		Object test2 = request.getParameter("bookedNum");
		
		int seat_num = Integer.parseInt(request.getParameter("seatCount"));
		String booked_num = (String)request.getParameter("bookedNum");
		//HttpSession session = request.getSession(false);
		String id = (String) session.getAttribute("id");
		
		BookedTickets b = b_service.getBookedTicket(booked_num);
		Tickets t = service.getTicket(b.getflight_num());
		if(b != null) {
			int seat_cnt = t.getSeat_count() + seat_num;
			t.setSeat_count(seat_cnt);
			service.editTicket(t);
			b_service.delBookedTicket(booked_num);
		}
		
		response.sendRedirect("Home/cust/cust_bookingCancel.jsp");
	}

}
