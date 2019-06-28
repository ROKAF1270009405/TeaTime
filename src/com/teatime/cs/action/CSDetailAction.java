package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDTO;
import com.teatime.cs.service.CustomerServiceService;
import com.teatime.member.MemberDTO;

public class CSDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("dto");
		
		ActionForward forward = new ActionForward();

		if(member==null)
		{
            forward.setRedirect(true);	
            forward.setPath("/login.do");
			
		}
		else
		{
			int boardnum=Integer.parseInt(request.getParameter("num"));
			
			CustomerServiceService service = CustomerServiceService.getInstance();
			CustomerServiceDTO data = service.detailService(boardnum);
			
			request.setAttribute("data", data);
			
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/customerservice/csdetail.jsp");
			
		}
		
		
		
		return forward;
	}

}
