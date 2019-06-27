package com.teatime.login.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.login.service.LoginService;
import com.teatime.member.MemberDTO;

public class LoginCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		
		/*String url = request.getHeader("referer");
		System.out.println("url : "+url);*/
		
		LoginService service = LoginService.getInstance();
		int check = service.loginCheckService(dto);
		ActionForward act = new ActionForward();

		if(check == 1) {
			HttpSession session = request.getSession();
			dto = service.loginInfoService(id);
			session.setAttribute("dto", dto);
			act.setRedirect(true);
			act.setPath("teatime.do");
		} else {
			act.setRedirect(true);
			act.setPath("login.do");
		}
		return act;
	}
}
