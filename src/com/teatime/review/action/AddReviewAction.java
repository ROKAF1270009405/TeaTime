package com.teatime.review.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.review.model.ReviewDTO;
import com.teatime.review.service.ReviewService;
import com.teatime.shop.model.ShopDTO;

public class AddReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int shopno = Integer.parseInt(request.getParameter("shopno"));
		request.setAttribute("shopno", shopno);
		List<ReviewDTO> list = (List<ReviewDTO>) request.getAttribute("list");
		request.setAttribute("list", list);
		System.out.println(list);
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		System.out.println("addreview");
//		/templete.jsp?page=board/insertform.jsp
//		act.setPath("/WEB-INF/board/add.jsp");
		forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/review/addreivewform.jsp");
		return forward;
	}
}
