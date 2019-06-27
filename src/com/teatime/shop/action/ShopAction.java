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
		
		
		request.setCharacterEncoding("utf-8");
		System.out.println(2);
		String search = request.getParameter("text");
		
		if (search==null) {
			search = "";
		}
		
		
		int select=0;
		String txt=request.getParameter("select_text");
		  if(txt!=null)
		  {
			  select=Integer.parseInt(txt);
		  }

		
		System.out.println(select);
		ShopService service = ShopService.getInstance();
		List<ShopDTO> list = service.ListService(select, search);
		request.setAttribute("list", list);
		System.out.println(list.size());//null
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("WEB-INF/template/main.jsp?page=/WEB-INF/shop/shoplist.jsp");
		
		
		return forward;
	}

}
