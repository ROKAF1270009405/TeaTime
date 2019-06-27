package com.teatime.review.action;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.teatime.comm.Action;
import com.teatime.comm.ActionForward;
import com.teatime.member.MemberDTO;
import com.teatime.review.model.ReviewDTO;
import com.teatime.review.service.ReviewService;

public class AddReviewResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("dto");
		ActionForward forward = new ActionForward();
		if (mdto != null) {
			// 업로드 파일 사이즈
			int fileSize = 5 * 1024 * 1024;
			// 업로드될 폴더 경로
			String uploadPath = request.getServletContext().getRealPath("/reviewuploadimg");
			
			// try {

			// 파일업로드
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "euc-kr",
					new DefaultFileRenamePolicy());

			// 파일이름 가져오기
			String fileName = "";
			Enumeration<String> names = multi.getFileNames();
			if (names.hasMoreElements()) {
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
				System.out.println("system : " + fileName);
			}

			ReviewDTO dto = new ReviewDTO();
			String content = multi.getParameter("content");
			// String date = multi.getParameter("shopname");
			// System.out.println(date + " sss");
			String photo = fileName;
			// gpa 어떻게 가져올까?
			String gpaString = multi.getParameter("gpa");
			Float gpa = 0f;
			if ("surprised".equals(gpaString)) {
				gpa = 2.5f;
			} else if ("happy".equals(gpaString)) {
				gpa = 5f;
			}
			int shopno = Integer.parseInt(multi.getParameter("shopno"));
//			String id = multi.getParameter("id");
			String id = mdto.getId();
			dto.setContent(content);
			// dto.setDate(date);
			dto.setPhoto(photo);
			dto.setGpa(gpa);
			dto.setShopno(shopno);
			dto.setId(id);
			System.out.println("gpa : " + multi.getParameter("gpa"));
			System.out.println("=============================");
			/*
			 * System.out.println("content " + dto.getContent());
			 * dto.setShopno(Integer.parseInt(multi.getParameter("shopno")));
			 * dto.setPhoto(multi.getParameter("filedata")); System.out.println("file " +
			 * multi.getParameter("filedata"));
			 * System.out.println("============================="); //
			 * System.out.println("photo" + multi.getParameter("photo"));
			 */
			ReviewService service = ReviewService.getInstance();

			int result = service.addReview(dto);
			System.out.println(result);
			// if(result == 1){
			forward.setRedirect(true);
			forward.setPath("teatime.do");
			// } else {

			// }

			// } catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("글 작성 오류 : " + e.getMessage());
			// }
		} else {
			forward.setRedirect(true);
			forward.setPath("login.do");
		}
		return forward;
	}

	//
	// ReviewService service = ReviewService.getInstance();
	// // int totalcount = service.getCount();
	//
	// // String title = request.getParameter("title");
	// String content = request.getParameter("content");
	// String date = request.getParameter("date1");
	// String photo = request.getParameter("photo");
	//// Float gpa = Float.parseFloat(request.getParameter("gpa"));
	//// int shopno = Integer.parseInt(request.getParameter("shopno"));
	// String id = request.getParameter("id");
	// System.out.println("=====================");
	// System.out.println(content );
	// System.out.println(request.getParameter("name"));
	// System.out.println(date);
	// System.out.println(photo);
	//// System.out.println(gpa);
	//// System.out.println(shopno);
	// System.out.println(id);
	// ReviewDTO dto = new ReviewDTO();
	// // dto.setTitle(title);
	// dto.setContent(content);
	//// dto.setDate(date);
	// dto.setPhoto(photo);
	//// dto.setGpa(gpa);
	//// dto.setShopno(shopno);
	// dto.setId(id);
	//
	//// int result = service.addReview(dto);
	//// request.setAttribute("result", result);
	// ActionForward forward = new ActionForward();
	// forward.setRedirect(true);
	// forward.setPath("detail.do?shopno="+1);
	// return forward;
	// }

}
