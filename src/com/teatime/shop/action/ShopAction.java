package com.teatime.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.shop.model.ShopDTO;
import com.teatime.shop.service.ShopService;

public class ShopAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ShopService service = ShopService.getInstance();
		List<ShopDTO> list = service.ListService();
		request.setAttribute("list", list);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("WEB-INF/template/main.jsp?page=/WEB-INF/shop/shoplist.jsp");
		
		
		return forward;
	}

}
