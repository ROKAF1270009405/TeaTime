package com.teatime.mypage.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.member.MemberDTO;
import com.teatime.mypage.model.MypageDTO;
import com.teatime.mypage.service.MypageService;

public class ReviewModifyResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String content = request.getParameter("content");
		// String gpa = request.getParameter("gpa");
		MypageDTO dto = new MypageDTO();
		dto.setContent(content);
		// dto.setGpa(gpa);
		
		System.out.println("여긴 M.R.Action인데 난 content 값을 보고싶어 : " + content);
		
		MypageService service = MypageService.getInstance();
		// int result = service.modifyService(dto);
		//request.setAttribute("result", result);
		//System.out.println("여긴 M.R.Action인데 난 result 값을 보고싶어 : " + result);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/mypage/myreviewpage.jsp");

		return forward;
	} // end execute method

} // end ReviewModifyResultAction class
