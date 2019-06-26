package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDTO;
import com.teatime.cs.service.CustomerServiceService;

public class CSAddResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int hp=Integer.parseInt(request.getParameter("hp"));
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		System.out.println(title+":::"+content);
		CustomerServiceDTO dto = new CustomerServiceDTO();
		
		dto.setTitle(title);
		dto.setContent(content);
		
		CustomerServiceService service = CustomerServiceService.getInstance();
		service.addService(dto);
		//System.out.println(dto.getContent().toString());
		request.setAttribute("hp", hp);
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(true);
		forward.setPath("customerservicelist.do");
		
		return forward;
	}

}
