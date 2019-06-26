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
		
		String hp =request.getParameter("hp");
		String email = request.getParameter("email");
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		String id = request.getParameter("id");
		
		System.out.println(title+":::"+content);
		System.out.println("전화"+hp);
		
		CustomerServiceDTO dto = new CustomerServiceDTO();
		
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setHp(hp);
		
		CustomerServiceService service = CustomerServiceService.getInstance();
		service.addService(dto);
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(true);
		forward.setPath("customerservicelist.do");
		
		return forward;
	}

}
