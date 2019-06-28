package com.teatime.mypage.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.member.MemberDTO;
import com.teatime.mypage.model.MypageDTO;
import com.teatime.mypage.service.MypageService;

public class ReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
		
		ActionForward forward = new ActionForward();
		if (dto == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
			MypageService service = MypageService.getInstance();
			List<MypageDTO> list = service.reviewService(dto);
			request.setAttribute("list", list);
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/mypage/myreviewpage.jsp");
		}
		System.out.println("이동");
		return forward;
	} // end execute method

} // end ReviewListAction class
