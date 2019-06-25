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
		/*
		String kind = request.getParameter("kind");				// 좋아요, 평점 기준
		String startday = request.getParameter("startday");		//
		String endday = request.getParameter("endday");
		*/
		System.out.println("베스트 액션 진입..");
		String kind = "";
		String startday = "2019-06-01";
		String endday = "";
		
		if(kind==null || "".equals(kind)) {
			kind = "good";
		}
		
		if(startday!=null && !("".equals(startday))) {
			if(endday==null || "".equals(endday)) {
				endday="none";
			}
		}
		System.out.println("kind : "+kind);
		System.out.println("startday : "+startday);
		BestService service = BestService.getInstance();
		System.out.println("베스트 서비스로 이동.");
		List<BestDTO> bestlist = service.bestList(kind, startday, endday);
		System.out.println("베스트 액션 복귀");
		request.setAttribute("bestlist", bestlist);
		System.out.println("리턴값을 받아서 묶었다!");
		ActionForward act = new ActionForward();
		act.setRedirect(false);
		System.out.println("화면으로 뿌려주러간다!!");
		act.setPath("/WEB-INF/best/bestlist.jsp");
		
		return act;
	}
}
