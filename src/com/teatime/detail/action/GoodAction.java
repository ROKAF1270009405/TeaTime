package com.teatime.detail.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.detail.service.DetailService;

public class GoodAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		DetailService service = DetailService.getService();
		service.goodService(no);
		
		ActionForward act = new ActionForward();
		act.setRedirect(false);
		act.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/detail/detail.jsp");

		return null;
	}

}
