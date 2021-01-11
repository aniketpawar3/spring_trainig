package com.zensar;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class StudentController extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String requestAction = request.getParameter("requestAction");
		if(requestAction.equals("loginFormjsp")) {
			String susername = request.getParameter("username");
			String spassword = request.getParameter("password");

			StudentRepository sr = new StudentRepository();
			boolean loginResult = sr.loginCheck(susername, spassword);
			if(loginResult) {
				try {
					//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		            //rd.include(request, response);
					response.sendRedirect("index.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				}  
			}else {
				System.out.println("login Failed");
				 request.setAttribute("errorMessage", "Invalid user or password");
                 RequestDispatcher rd = request.getRequestDispatcher("LoginFile.jsp");
                 
				try {
					rd.forward(request, response);
					//response.sendRedirect("loginForm.jsp");
				} catch (Exception e) {
					 
					System.out.println("loginfailed catch"+e);
				}
			}
		}
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		doGet(request, response);
	}
}