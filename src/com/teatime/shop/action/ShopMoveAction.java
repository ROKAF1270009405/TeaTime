package com.teatime.shop.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;

public class ShopMoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward act = new ActionForward();
		act.setRedirect(false);
		act.setPath("WEB-INF/template/main.jsp?page=/WEB-INF/shop/shopadds.jsp");
		return act;
	}
}
