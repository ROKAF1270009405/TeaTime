package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDTO;
import com.teatime.cs.service.CustomerServiceService;

public class CSModifyResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		String hp = request.getParameter("hp");
		String title =request.getParameter("title");
		String content =request.getParameter("content");
		
		CustomerServiceDTO dto= new CustomerServiceDTO();
		
		dto.setHp(hp);
		dto.setContent(content);
		dto.setTitle(title);
		
		CustomerServiceService service = CustomerServiceService.getInstance();
		service.modifyService(dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("csdetail.do?num="+num);
		
		return forward;
	}

}
