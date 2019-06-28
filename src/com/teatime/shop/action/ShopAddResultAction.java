package com.teatime.shop.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.shop.model.ShopDTO;
import com.teatime.shop.service.ShopService;

public class ShopAddResultAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String photo = request.getParameter("photo");
		String addr = request.getParameter("addr");
		String workingtime = request.getParameter("workingtime");
		ShopDTO dto = new ShopDTO();

		dto.setName(name);
		dto.setContent(content);
		dto.setPhoto(photo);
		dto.setAddr(addr);
		dto.setWorkingtime(workingtime);
		ShopService service = ShopService.getInstance();
		int result = service.insert(dto);
		
		System.out.println("result :"+result);
		
		request.setAttribute("result", result);
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("WEB-INF/template/main.jsp?page=/WEB-INF/shop/shopinsertend.jsp");
		
		return forward;
	}

	
}
