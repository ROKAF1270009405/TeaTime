package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.service.CustomerServiceService;

public class CSDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		CustomerServiceService service = CustomerServiceService.getInstance();
		service.DeleteService(num);
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(true);
		forward.setPath("customerservicelist.do");
		
		return forward;
	}

}
