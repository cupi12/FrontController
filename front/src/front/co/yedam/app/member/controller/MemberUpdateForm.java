package front.co.yedam.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import front.co.yedam.app.common.Controller;
import front.co.yedam.app.member.model.MemberService;
import front.co.yedam.app.member.model.MemberVO;

public class MemberUpdateForm implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 파라미터 받기
		String id = request.getParameter("id");
		// 2. 서비스 로직 처리
		MemberVO member = MemberService.getInstance().getMember(id);
		request.setAttribute("member", member);
		return "/member/memberUpdate.jsp";
	}

}
