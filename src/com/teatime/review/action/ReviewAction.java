package com.teatime.review.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.review.model.ReviewDTO;
import com.teatime.review.service.ReviewService;

public class ReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReviewService service = ReviewService.getInstance();
//		System.out.println("hi");
//		int totalcount = service.getCount();
		int shopno = Integer.parseInt(request.getParameter("shopno"));
		List<ReviewDTO> list = service.getList(shopno);
		request.setAttribute("list", list);
		request.setAttribute("shopno", shopno);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
//		forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/review/review.jsp");
//		forward.setPath("/WEB-INF/detail/detail.jsp?page=/WEB-INF/review/review.jsp");
		forward.setPath("/WEB-INF/review/review.jsp");
		return forward;
	}  
}




