package com.teatime.login.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.login.service.LoginService;
import com.teatime.member.MemberDTO;

public class SignUpResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int naverid = Integer.parseInt(request.getParameter("naverid"));
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String checkpwd = request.getParameter("confirmPassword");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		
		LoginService service = LoginService.getInstance();
		ActionForward act = new ActionForward();
		
		if(naverid==1) {
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPwd(pwd);
			
			int check = service.loginCheckService(dto);
			if(check == 1) {
				act.setRedirect(false);
				act.setPath("logincheck.do");
			}
			
		} else {
			MemberDTO dto = new MemberDTO();
			dto.setId(id);
			dto.setPwd(pwd);
			dto.setNickname(nickname);
			dto.setMail(email);
			
			if(pwd.equals(checkpwd)) {
				int check = service.signUpService(dto);
				if(check == 1) {
					act.setRedirect(false);
					act.setPath("teatime.do");
				} else {
					act.setRedirect(true);
					act.setPath("signup.do");
				}
				//패스워드가 서로 다를 경우.
			} else {
				act.setRedirect(true);
				act.setPath("signup.do");
			}
		}
		
		return act;
	}

}
