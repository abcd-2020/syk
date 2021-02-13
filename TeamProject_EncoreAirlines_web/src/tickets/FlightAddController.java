//package com.encore.controller.flight;
package tickets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import com.encore.flight.Flight;
import com.encore.flight.FlightService;*/

/**
 * Servlet implementation class FlightAddController
 */
@WebServlet("/FlightAdd")
public class FlightAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "Home/emp/emp_addSchedule.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TicketsService service = new TicketsService();
		
		String new_num = request.getParameter("flightNum");
		String new_d_city = request.getParameter("departCity");
		String new_d_time = request.getParameter("departTime");
		String new_a_city = request.getParameter("arriveCity");
		String new_a_time = request.getParameter("arriveTime");
		String new_w_date = request.getParameter("workingDate");
		int new_seat_cnt = Integer.parseInt(request.getParameter("seatCount"));
		int new_price = Integer.parseInt(request.getParameter("price"));
		String new_state = request.getParameter("state");
		Tickets new_f = new Tickets(new_num, new_d_city, new_d_time, new_a_city, new_a_time, new_w_date, new_seat_cnt, new_price, new_state);
		
		service.addTickets(new_f);
		
		//HttpSession session = request.getSession(false);
		
		//ArrayList<Flight> new_list = service.selectAll();
		//request.setAttribute("cur_list",new_list);
		//request.setAttribute("added", "New flight schedule has been successfully added to DB");
		
		String url = "Home/emp/emp_account.jsp";
		response.sendRedirect(url);
		
		//Flight(String flight_num, String depart_city, String depart_time, String arrive_city, 
		//String arrive_time, String working_date, int seat_count, int price, String state)
	}

}
