package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDTO;
import com.teatime.member.MemberDTO;

public class CSAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("dto");

		ActionForward forward = new ActionForward();

		if (member == null) { // 로그인 안되어있을시
			forward.setRedirect(true);
			forward.setPath("login.do");

		} else {
			String id = member.getId();
			String email = member.getMail();
			session.setAttribute("id", id);
			session.setAttribute("email", email);
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/customerservice/csinsertform.jsp");
		}
		return forward;

	}

}
