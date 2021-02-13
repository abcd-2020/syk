package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		
		HttpSession session = null;
		MemberService service = new MemberService();
		//failed login url
		String url = "Home/signUp.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		
		Member member = service.getMember(id);
		
		if(member!=null && pwd.equals(member.getPassword())) {
			session = request.getSession();
			session.setAttribute("type", member.getType());
			session.setAttribute("id", member.getId());
			session.setAttribute("password", member.getPassword());
			session.setAttribute("name", member.getName());
			session.setAttribute("passportNum", member.getpassportNum());
			session.setAttribute("member", member);
			
			//request를 유지하는 이유?? 
			
			request.setAttribute("member", member);
			//type : c, e, a
			//login success url
			if(member.getType().equals("c")) {
				//Customer
				url = "Home/cust/cust_searchTicket.jsp";
			}else if(member.getType().equals("e")) {
				//Employee
				url = "Home/emp/emp_addSchedule.jsp";
			}else if(member.getType().equals("a")) {
				//admin
				url = "Home/admin/admin_account.jsp";
			}
		}
		
		/*RequestDispatcher d = request.getRequestDispatcher(url);
		d.forward(request, response);*/
		//이건 url 이 바뀌지 않는다 
		
		response.sendRedirect(url);
		
		
	}

}
