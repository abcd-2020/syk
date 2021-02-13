package tickets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchTicketListController
 */
@WebServlet("/SearchTicketList")
public class SearchTicketListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTicketListController() {
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
		
		TicketsService service = new TicketsService();
		//String tempString = (String)request.getAttribute("d_city");
		String name = request.getParameter("type");
		String searchName = request.getParameter("searchName");
		String endTime = request.getParameter("endTime");
		String startTime = request.getParameter("startTime");
		
		ArrayList<Tickets> orderedlist = new ArrayList<Tickets>(); 
		
		if(name.equals("DepartCity")) {
			
			orderedlist = service.selectByDepartCityTickets(searchName);
			
		}else if(name.equals("DepartTime")) {
			
			orderedlist = service.selectByDepartDateTickets(startTime, endTime);
			
		}else if(name.equals("ArriveCity")) {
			
			orderedlist = service.selectByArriveCityTickets(searchName);
			
		}else if(name.equals("ArriveTime")) {
			
			orderedlist = service.selectByDepartDateTickets(startTime, endTime);
		}
		session.removeAttribute("orderlist");
		session.setAttribute("orderedlist", orderedlist);
		
		
		
		
		response.sendRedirect("Home/cust/cust_searchTicket.jsp");
		
		
		
		
	}

}
