package com.teatime.cs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.cs.model.CustomerServiceDTO;
import com.teatime.controller.Action;
import com.teatime.controller.ActionForward;
import com.teatime.service.CustomerServiceService;

public class CSListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		CustomerServiceService service = CustomerServiceService.getInstance();

		String curr = request.getParameter("currpage");
		int currpage = 1;
		if (curr != null) {
			currpage = Integer.parseInt(curr);
		}
		int pagepercount = 10; // 1 페이지에 보여질 자료 수
		int totalcount = service.getCount();
		int totalpage = (totalcount / pagepercount) + ((totalcount % pagepercount == 0) ? 0 : 1);
		int startrow = (currpage - 1) * pagepercount + 1;
		int endrow = startrow + pagepercount - 1;
		if (endrow > totalcount)
			endrow = totalcount;
		int blocksize = 10; // 1블록 10개 페이지

		int startblock = ((currpage - 1) / blocksize) * blocksize + 1;
		int endblock = startblock + blocksize - 1;
		if (totalpage < endblock)
			endblock = totalpage;

		List<CustomerServiceDTO> list = service.getList(startrow, endrow);

		request.setAttribute("list", list);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("currpage", currpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("/WEB-INF/board/CustomerServiceList.jsp");

		return forward;
	}

}