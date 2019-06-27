package com.teatime.cs.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDTO;
import com.teatime.cs.service.CustomerServiceService;

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
		int startrow = (currpage - 1) * pagepercount;
		int blocksize = 10; // 1블록 10개 페이지

		int startblock = ((currpage - 1) / blocksize) * blocksize + 1;
		int endblock = startblock + blocksize - 1;
		if (totalpage < endblock)
			endblock = totalpage;

		List<CustomerServiceDTO> list = service.getList(startrow, pagepercount);

		request.setAttribute("list", list);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("currpage", currpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/customerservice/customerservicelist.jsp");
		
		return forward;
	}

}
