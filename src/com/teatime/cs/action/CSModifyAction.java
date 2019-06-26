package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDTO;
import com.teatime.cs.service.CustomerServiceService;

public class CSModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		CustomerServiceService service = CustomerServiceService.getInstance();
		CustomerServiceDTO data = service.detailService(num);
		
		request.setAttribute("data", data);
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/customerservice/csmodifyform.jsp");
		
		return forward;
	}

}