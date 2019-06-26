package com.teatime.login.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("로그인 액션 진입.");
		ActionForward act = new ActionForward();
		act.setRedirect(false);
		act.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/login/loginform.jsp");
		
		return act;
	}

}
