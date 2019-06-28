package com.teatime.shop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;

public class ShopAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("WEB-INF/template/main.jsp?page=/WEB-INF/shop/shopadd.jsp");
		
		
		return forward;
	}

}
