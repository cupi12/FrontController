package front.co.yedam.app.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import front.co.yedam.app.member.controller.MemberDelete;
import front.co.yedam.app.member.controller.MemberInsert;
import front.co.yedam.app.member.controller.MemberInsertForm;
import front.co.yedam.app.member.controller.MemberList;
import front.co.yedam.app.member.controller.MemberUpdate;
import front.co.yedam.app.member.controller.MemberUpdateForm;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HashMap<String, Controller> list = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		list = new HashMap<String, Controller>();
		// url 요청과 서브컨트롤러 매핑
		list.put("/MemberInsertForm.do", new MemberInsertForm());
		list.put("/MemberInsert.do", new MemberInsert());
		list.put("/MemberUpdateForm.do", new MemberUpdateForm());
		list.put("/MemberUpdate.do", new MemberUpdate());
		list.put("/MemberList.do", new MemberList());
		list.put("/MemberDelete.do", new MemberDelete());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// url분석 -> 컨트롤러 검색-> 실행
		String url = request.getRequestURI(); // edu/MemberInsert.do?
		String contextPath = request.getContextPath(); // 주소에서 edu를 가져옴
		String path = url.substring(contextPath.length()); // url에서 edu를 제외하고 나머지값만 (MemberInsert.do?)를 가져옴

		
		// 서브 컨트롤러 검색
		Controller subController = list.get(path);
		if(subController ==null) {
			response.getWriter().print("no command.");
			return;
		}

		// 로그인 체크, 권한 체크(옵션)

		// 서브 컨트롤러 실행
		String view = subController.execute(request, response);
		if (view != null) {
			if (view.startsWith("redirect:")) {
				response.sendRedirect(view.substring(9)); // 9글짜 이후를 잘라서 send함
			} else {
				request.getRequestDispatcher(view).forward(request, response);
			}
		}

	}

}
