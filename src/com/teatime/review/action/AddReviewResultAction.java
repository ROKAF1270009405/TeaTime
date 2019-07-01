package com.teatime.review.action;

import java.io.IOException;
import java.util.ArrayList;
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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("dto");
		ActionForward forward = new ActionForward();
		System.out.println("============================");
		if (mdto != null) {
			// 업로드 파일 사이즈
			int fileSize = 5 * 1024 * 1024;
			// 업로드될 폴더 경로
			
			String uploadPath = request.getServletContext().getRealPath("/reviewuploadimg");
			System.out.println("uploadPath : " + uploadPath);
			// 파일업로드
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "utf-8",
					new DefaultFileRenamePolicy());

			// 파일이름 가져오기
			String fileName = "";
			Enumeration<String> names = multi.getFileNames();
			ArrayList<String> img = new ArrayList<>();
			while (names.hasMoreElements()) {
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
				img.add(fileName);
//				System.out.println(fileName);
			}

			ReviewDTO dto = new ReviewDTO();
			String date = multi.getParameter("date");
			System.out.println(date);
			String content = multi.getParameter("content");
			String gpaString = multi.getParameter("gpa");
			Float gpa = 0f;
			if ("surprised".equals(gpaString)) {
				gpa = 2.5f;
			} else if ("happy".equals(gpaString)) {
				gpa = 5f;
			}
			int shopno = Integer.parseInt(multi.getParameter("shopno"));	
			String id = mdto.getId();
			dto.setContent(content);
			dto.setDate(date);
			dto.setPhoto(img);
			dto.setGpa(gpa);
			dto.setShopno(shopno);
			dto.setId(id);
			
			System.out.println("=============================");
			int result = 0;
			ReviewService service = ReviewService.getInstance();
				result = service.addReview(dto, img);
				
			System.out.println("addreviewresultaction");
//			System.out.println(result);
//			 if(result >= 1){
			forward.setRedirect(true);
			forward.setPath("detail.do?shopno="+shopno);
//			 } else {

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

}
