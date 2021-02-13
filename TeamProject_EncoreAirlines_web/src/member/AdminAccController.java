package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.Member;
import member.MemberService;

/**
 * Servlet implementation class AdminAccController
 */
@WebServlet("/AdminAccController")
public class AdminAccController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAccController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService service = new MemberService();
		ArrayList <String> unused_list = service.unusedId();
		if(unused_list.isEmpty()) {
			request.setAttribute("noIds", "There's no unused Id's.");
		}
		ArrayList <Member> mem_list = new ArrayList<Member>();
		for (String id:unused_list) {
			mem_list.add(service.selectById(id));
		}
				
		//move to admin_deleteAccount.jsp to show unused accounts and add other accounts to delete
		request.setAttribute("mem_list", mem_list);
		String url = "Home/admin/admin_deleteAccount.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService service = new MemberService();
		String d_list = request.getParameter("ids_delete");
		String[] delete_list = d_list.split(",");
		
		String s_list = request.getParameter("ids_save");
		String[] save_list = s_list.split(",");
		
		ArrayList <String> unused_list = service.unusedId();
		for(String s: save_list) {
			unused_list.remove(s);
		}
		
		//a new arraylist to contain all of unused+delete id's
		ArrayList<String> all_list = new ArrayList <>();
		
		for(int i=0; i<unused_list.size();i++) {
			all_list.add(unused_list.get(i));
		}
		for (int i=0;i<delete_list.length;i++) {
			all_list.add(delete_list[i]);
		}
		for(String d : all_list) {
			service.delete(d);
		}
		request.setAttribute("deletedIds", all_list.size()+" accounts are deleted from DB.");
		String url = "Home/admin/admin_account.jsp";

		response.sendRedirect(url);
		//RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		//dispatcher.forward(request, response);
	
	}

}
