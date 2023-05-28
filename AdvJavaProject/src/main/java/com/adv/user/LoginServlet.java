package com.adv.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean result =false;
		result = UserDao.checkLogin(email, password);
		if(result==true) {
			RequestDispatcher dispatcher=request.getRequestDispatcher("loginsuccess.jsp");
			dispatcher.include(request, response);
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("loginfail.jsp");
			dispatcher.include(request, response);
		}
				
			
	}

}
