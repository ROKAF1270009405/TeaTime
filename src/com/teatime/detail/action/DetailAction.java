package com.teatime.detail.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.detail.service.DetailService;
import com.teatime.shop.model.ShopDTO;

public class DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// datail
		// shop에 대한 설명
		//
		//
		// 제목 - name
		// 주소 - addr
		// 내용 - content
		// 영업시간 - workingtime
		// 사진 - photo
		// 게시일 - date

//		int shopno = Integer.parseInt(request.getParameter("shopno"));
		
		String no = request.getParameter("shopno");
		System.out.println(no);
		int shopno = 1;
		if(no!=null && !no.equals(""))
			shopno=Integer.parseInt(no);
		System.out.println("if 이후 : "+no);
		
		System.out.println("shopno : "+shopno);
		DetailService service = DetailService.getService();
		ShopDTO dto = service.detailService(shopno);
		request.setAttribute("dto", dto);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/template/main.jsp?page=/WEB-INF/detail/detail.jsp");

		return forward;
	}

}
