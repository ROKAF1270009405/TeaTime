package com.teatime.mypage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.member.MemberDTO;
import com.teatime.mypage.service.MypageService;

public class ReviewModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
		ActionForward forward = new ActionForward();
		System.out.println("여긴 action이야!!");
		if (dto == null) {
			System.out.println("여긴 action의 if문 안이고");
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			System.out.println("여긴 action의 else문 안이야.");
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/mypage/modifymyreview.jsp");
		}
		return forward;
	} // end execute method

} // end ReviewModifyAction class
