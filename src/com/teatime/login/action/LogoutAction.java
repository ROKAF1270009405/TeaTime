package com.teatime.login.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();

		ActionForward act = new ActionForward();
		act.setRedirect(true);
		act.setPath("teatime.do");
		return act;
	}

}
