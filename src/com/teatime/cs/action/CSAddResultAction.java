package com.teatime.cs.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.cs.model.CustomerServiceDTO;
import com.teatime.cs.service.CustomerServiceService;
import com.teatime.member.MemberDTO;

public class CSAddResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MemberDTO member = (MemberDTO) session.getAttribute("dto");

		ActionForward forward = new ActionForward();
		
		if (member == null) { // 로그인 안되어있을시
			forward.setRedirect(true);
			forward.setPath("login.do");

		} else {
			String hp = request.getParameter("hp");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String id = member.getId();

			System.out.println(title + ":::" + content);

			CustomerServiceDTO dto = new CustomerServiceDTO();

			dto.setId(id);
			dto.setTitle(title);
			dto.setContent(content);
			dto.setHp(hp);

			CustomerServiceService service = CustomerServiceService.getInstance();
			service.addService(dto);

			forward.setRedirect(true);
			forward.setPath("customerservicelist.do");
		}
		return forward;
	}

}
