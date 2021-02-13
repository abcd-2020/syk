package tickets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tickets.TicketsService;

/**
 * Servlet implementation class FlightUpdateController
 */
@WebServlet("/FlightUpdate")
public class FlightUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fnum = request.getParameter("flight_num");
		TicketsService service = new TicketsService();
		Tickets f = service.getTicket(fnum);
		request.setAttribute("f", f);
		
		String url = "Home/emp/emp_updateSchedule.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		String flight_num = request.getParameter("flight_num");
		String depart_city = request.getParameter("departCity");
		String depart_time = request.getParameter("departTime");
		String arrive_city = request.getParameter("arriveCity");
		String arrive_time = request.getParameter("arriveTime");
		String working_date = request.getParameter("workingDate");
		int seat_count = Integer.parseInt(request.getParameter("seatCount"));
		int price = Integer.parseInt(request.getParameter("price"));
		String state = request.getParameter("state");
		//just to check
		System.out.println(flight_num);
		
		Tickets updated_f = new Tickets(flight_num,depart_city,depart_time,arrive_city,arrive_time,working_date,seat_count,price,state);
		
		TicketsService service = new TicketsService();
		service.editTicket(updated_f);
		
		String url = "Home/emp/emp_account.jsp";
		response.sendRedirect(url);
		
		
	}

}
