package com.teatime.comm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teatime.login.service.LoginService;

@WebServlet("/DuplicateCheck.co")
public class DuplicateCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DuplicateCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idCheck(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idCheck(request, response);
	}
	
	private void idCheck (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setCharacterEncoding("utf-8"); 
		PrintWriter out=response.getWriter();
   		 
		LoginService service = LoginService.getInstance();
		String id = request.getParameter("idcheck");
		System.out.println(id);
		int result = 0;	
		result = service.idCheckService(id);
		
		if(result == 0) {
			out.println("아이디 사용 가능");
		} else {
			out.println("중복된 아이디가 있습니다.");
		}
	}

}

