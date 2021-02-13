package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyInfoController
 */
@WebServlet("/MyInfo")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String login_id = (String)session.getAttribute("id");
		
		String tempString = "";
		
		MemberService service = new MemberService();
		Member m = service.getMember(login_id);
		
		//request.setAttribute("m", m);
		session.setAttribute("m", m);
		
		if(session.getAttribute("type").equals("c")) {
			tempString = "Home/cust/cust_myInfo.jsp";
		}else if(session.getAttribute("type").equals("e")) {
			tempString = "Home/emp/emp_myInfo.jsp";
		}
		
		response.sendRedirect(tempString);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberService service = new MemberService();
		String tempString = "";
		String _id = (String)session.getAttribute("id");
		String _password = (String)session.getAttribute("password");
		String _name = (String)session.getAttribute("name");
		String _passportNum = (String)session.getAttribute("passportNum");
		String _type = (String)session.getAttribute("type");
		
		/*String _id = request.getParameter("id");
		String _password = request.getParameter("password");
		String _name = request.getParameter("name");
		String _passportNum = request.getParameter("passportNum");
		String _type = request.getParameter("type");
		*/
		//service.editMember(new Member(_id, _password, _name, _passportNum, _type));
		service.editMember(new Member(_id, _name, _password, _passportNum, _type, null));
		if(_type.equals("c")) {
			tempString = "Home/cust/cust_searchTicket.jsp";
		}else if(_type.equals("e")) {
			tempString = "Home/emp/emp_addSchedule.jsp";
		}
		
		response.sendRedirect(tempString);
		
	}

}
