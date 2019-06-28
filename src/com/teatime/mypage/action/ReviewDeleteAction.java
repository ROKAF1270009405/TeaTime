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

public class ReviewDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
		ActionForward forward = new ActionForward();
		System.out.println("여기 Action인데 들어올 수 있나요?" + dto);
		
		if (dto == null) {
			System.out.println("혹시 여기로 들어오나요?");
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			System.out.println("여기는 Action : " + request.getParameter("num"));
			int no = Integer.parseInt(request.getParameter("num")); // 여기서 문제..
			MypageService service = MypageService.getInstance();
			int result = service.deleteService(no);
			request.setAttribute("result", result);

			forward.setRedirect(false);
			forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/mypage/deletemyreview.jsp");
		}

		return forward;
	} // end execute method

} // end ReviewDeleteAction class
