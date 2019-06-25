package com.teatime.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teatime.controller.Action;
import com.teatime.controller.ActionForward;
import com.teatime.dto.CustomerServiceDTO;
import com.teatime.service.CustomerServiceService;

public class CSListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		CustomerServiceService service = CustomerServiceService.getInstance();
		List<CustomerServiceDTO> list = service.ListService();

		return null;
	}

}
