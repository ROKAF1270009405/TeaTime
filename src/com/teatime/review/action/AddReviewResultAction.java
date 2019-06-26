package com.teatime.review.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.review.model.ReviewDTO;
import com.teatime.review.service.ReviewService;

public class AddReviewResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReviewService service = ReviewService.getInstance();
		// int totalcount = service.getCount();

		// String title = request.getParameter("title");
		String content = request.getParameter("content");
		String date =  request.getParameter("date");
		String photo = request.getParameter("photo");
//		Float gpa = Float.parseFloat(request.getParameter("gpa"));
//		int shopno = Integer.parseInt(request.getParameter("shopno"));
		String id = request.getParameter("id");
		System.out.println("=====================");
		System.out.println(content );
		System.out.println(date);
		System.out.println(photo);
//		System.out.println(gpa);
//		System.out.println(shopno);
		System.out.println(id);
		ReviewDTO dto = new ReviewDTO();
		// dto.setTitle(title);
		dto.setContent(content);
//		dto.setDate(date);
		dto.setPhoto(photo);
//		dto.setGpa(gpa);
//		dto.setShopno(shopno);
		dto.setId(id);

//		int result = service.addReview(dto);
//		request.setAttribute("result", result);
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("detail.do?shopno="+1);
		return forward;
	}

}
