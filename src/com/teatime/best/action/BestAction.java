package com.teatime.best.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.best.model.BestDTO;
import com.teatime.best.service.BestService;
import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;

public class BestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String kind = request.getParameter("kind");				// 좋아요, 평점 기준
		String startday = request.getParameter("startday");		//
		String endday = request.getParameter("endday");
		
		if(kind==null || "".equals(kind)) {
			kind = "good";
		}
		
		if(startday!=null && !("".equals(startday))) {
			if(endday==null || "".equals(endday)) {
				endday="none";
			}
		}
		
		BestService service = BestService.getInstance();
		List<BestDTO> bestlist = service.bestList(kind, startday, endday);
		request.setAttribute("bestlist", bestlist);
		
		ActionForward act = new ActionForward();
		act.setRedirect(false);
		act.setPath("/WEB-INF/best/bestlist.jsp");
		
		return act;
	}
}
