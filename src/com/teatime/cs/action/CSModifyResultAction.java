package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDTO;

public class CSModifyResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("num"));
		String hp = request.getParameter("hp");
		String title =request.getParameter("title");
		String content =request.getParameter("content");
		System.out.println();
		
		CustomerServiceDTO dto= new CustomerServiceDTO();
		
		dto.setHp(hp);
		dto.setContent(content);
		dto.setTitle(title);
		
		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/customerservice/csdetail.jsp");
		
		return forward;
	}

}
