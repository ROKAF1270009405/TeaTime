package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDAO;
import com.teatime.cs.model.CustomerServiceDTO;
import com.teatime.cs.service.CustomerServiceService;

public class CSReplyResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int num =Integer.parseInt(request.getParameter("num"));
		
		String replycontent = request.getParameter("replycontent");
		CustomerServiceService service = CustomerServiceService.getInstance();
		CustomerServiceDTO data; 
		
		data=service.detailService(num);
		data.setReply(replycontent);
//		data=service.replyUpdateService(data);
		
		request.setAttribute("data", data);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/customerservice/csreplydetail.jsp?num="+num);
		
		return forward;
	}

}
