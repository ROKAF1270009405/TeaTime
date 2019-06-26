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

public class AddReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ReviewService service = ReviewService.getInstance();
////		int totalcount = service.getCount();
//
////		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		Date date = new Date();
//		String photo = request.getParameter("photo");
//		Float gpa = Float.parseFloat(request.getParameter("gpa"));
//		int shopno = Integer.parseInt(request.getParameter("shopno"));
//		String id = request.getParameter("id");
//		
//		ReviewDTO dto = new ReviewDTO();
////		dto.setTitle(title);
//		dto.setContent(content);
//		dto.setDate(date);
//		dto.setPhoto(photo);
//		dto.setGpa(gpa);
//		dto.setShopno(shopno);
//		dto.setId(id);
//		
//		int result= service.addReview(dto);
//		request.setAttribute("result", result);
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(true);
//		forward.setPath("review.do");
//		return forward;
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		System.out.println("addreview");
//		/templete.jsp?page=board/insertform.jsp
//		act.setPath("/WEB-INF/board/add.jsp");
		forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/review/addreivewform.jsp");
		return forward;
	}
}
