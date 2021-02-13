 package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/Signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
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
		
		MemberService service = new MemberService();
		
		String _id = request.getParameter("id");
		String _password = request.getParameter("password");
		String _name = request.getParameter("name");
		String _passport = request.getParameter("passportNumber");
		String _type = request.getParameter("type");
		
		service.editMember(new Member(_id, _name, _password, _passport, _type, null));
		
		//System.out.println("success");
		
		RequestDispatcher d = request.getRequestDispatcher("Home/logIn.jsp");
		d.forward(request, response);
		
		
		
	}

}
