package front.co.yedam.app.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import front.co.yedam.app.common.Controller;
import front.co.yedam.app.member.model.MemberService;
import front.co.yedam.app.member.model.MemberVO;

public class MemberList implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 파라미터 생략
		//2.3 서비스 로직 처리하고 결과 저장
		ArrayList<MemberVO> list = MemberService.getInstance().getMemberList();
		request.setAttribute("list", list);
		//4. view페이지로 이동
		return "/member/memberList.jsp";
	}

}
