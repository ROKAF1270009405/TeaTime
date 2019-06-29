package com.teatime.review.action;

import java.io.IOException;
import java.util.Date;
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
import com.teatime.review.model.ReviewDTO;
import com.teatime.review.service.ReviewService;
import com.teatime.shop.model.ShopDTO;

public class ModifyReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("dto");
		ActionForward forward = new ActionForward();
		if (mdto != null) {
			int shopno = Integer.parseInt(request.getParameter("shopno"));
			request.setAttribute("shopno", shopno);
			int reviewno = Integer.parseInt(request.getParameter("reviewno"));
//			System.out.println(reviewno);
			
			// reviewno 에 맞는 ReviewDTO 객체 가져오기
			// dto 객체 setattribute 로 넘겨주기
			MypageService service = MypageService.getInstance();
			// MypageDTO dto = service.modifyService(reviewno);
			// request.setAttribute("dto", dto);
			
			List<ReviewDTO> list = (List<ReviewDTO>) request.getAttribute("list");
			request.setAttribute("list", list);
			forward.setRedirect(false);
//			System.out.println("addreview");
			// /templete.jsp?page=board/insertform.jsp
			// act.setPath("/WEB-INF/board/add.jsp");
			forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/review/modifyreviewform.jsp");
		} else {
			forward.setRedirect(true);
			forward.setPath("login.do");
		}

		return forward;

	}
}
