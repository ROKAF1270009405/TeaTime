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

public class ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("dto");
		// dto.getId();
/*		dto = new MemberDTO();
		dto.setId("aaa");
		dto.setNickname("길동");
		dto.setMail("cy@teatime.com");
		session.setAttribute("dto", dto);*/

		ActionForward forward = new ActionForward();
		if (dto == null) {
			forward.setRedirect(true);
			forward.setPath("login.do");
		} else {
/*			MypageService service = MypageService.getInstance();
			List<MemberDTO> list = service.memberListService(dto);
			request.setAttribute("list", list);*/

			forward.setRedirect(false);
			forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/mypage/mypage.jsp");
			// forward.setPath("/WEB-INF/mypage/mypage.jsp");
		}

		return forward;

	} // end execute method

} // end ListAction class
