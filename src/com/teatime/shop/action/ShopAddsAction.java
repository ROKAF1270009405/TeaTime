package com.teatime.shop.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.member.MemberDTO;
import com.teatime.menu.model.MenuDTO;
import com.teatime.shop.model.ShopDTO;
import com.teatime.shop.service.ShopService;

public class ShopAddsAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("dto");
		
		//매장 테이블
		ShopDTO sdto = new ShopDTO();
		String shopname = request.getParameter("name"); // 매장이름
		String content = request.getParameter("content"); // 매장 소개
		String photo = request.getParameter("fileName1"); // 매장 사진
		String addr = request.getParameter("addr"); // 매장 주소
		String workingtime = request.getParameter("starttime"); //영업 시작 시간
		workingtime += " ~ "+request.getParameter("endtime"); //영업 종료 시간
		
		if(photo==null||photo.equals("")) {
			photo="http://localhost:8080/MiniPro2/img/bg.jpg";
		}
		System.out.println("매장 정보 : "+shopname);
		System.out.println("사진 정보 : " + photo);
		
		String foodkind = ""; // 음식 종류
		String korean = request.getParameter("korean"); // 한식
		String japanese = request.getParameter("japanese"); // 일식
		String chinese = request.getParameter("chinese"); // 중식
		String yangsig = request.getParameter("yangsig"); // 양식
		if(korean != null && !("".equals(korean))) {
			foodkind += korean+" ";
		}
		if(japanese != null && !("".equals(japanese))) {
			foodkind += japanese+" ";
		}
		if(chinese != null && !("".equals(chinese))) {
			foodkind += chinese+" ";
		}
		if(yangsig != null && !("".equals(yangsig))) {
			foodkind += yangsig+" ";
		}
		sdto.setId(mdto.getId());
		sdto.setName(shopname);
		sdto.setPhoto(photo);
		sdto.setContent(content);
		sdto.setAddr(addr);
		sdto.setWorkingtime(workingtime);
		sdto.setFoodkind(foodkind);
		ShopService service = ShopService.getInstance();
		int result = service.shopAddService(sdto);
		System.out.println("등록 여부 : "  + result);
		
		//메뉴 테이블
		String[] menuname = request.getParameterValues("menuname"); //메뉴 이름
		String[] price = request.getParameterValues("price"); //가격
		List<MenuDTO> menu = new ArrayList<MenuDTO>();
		if(result != 0) {
			if(menuname != null) {
				for(int i=1; i<menuname.length; i++) {
					MenuDTO dto = new MenuDTO();
					System.out.println(menuname[i]+", "+price[i]);
					dto.setName(menuname[i]);
					dto.setPrice(price[i]);
					menu.add(dto);
				}
				int ck = service.menuAddService(menu);
				System.out.println("메뉴 등록 여부 : " + ck);
			}
		}
		ActionForward act=new ActionForward();
		act.setRedirect(false);
		act.setPath("teatime.do");
		System.out.println("이동 : "+act);
		return act;
	}

}
