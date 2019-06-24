package com.teatime.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.dto.ShopDTO;
import com.teatime.service.TeaService;

public class BestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String kind = request.getParameter("kind");				//좋아요기준
		String startday = request.getParameter("startday");		//
		String endday = request.getParameter("endday");
		
		if(kind==null) {
			kind = "good";
		}
		
		if(startday!=null) {
			if(endday==null) {
				endday="none";
			}
		}
		
		TeaService service = TeaService.getInstance();
		List<ShopDTO> bestlist = service.bestList(kind, startday, endday);
		request.setAttribute("bestlist", bestlist);
		
		ActionForward act = new ActionForward();
		act.setRedirect(false);
		act.setPath("");
		
		return act;
	}
}
