package front.co.yedam.app.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import front.co.yedam.app.common.Controller;
import front.co.yedam.app.member.model.MemberService;
import front.co.yedam.app.member.model.MemberVO;

public class MemberDelete implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberVO member = new MemberVO();
		
		try {
			BeanUtils.copyProperties(member, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		MemberService.getInstance().memberDelete(member);
		
		String path = request.getContextPath()+"/MemberList.do";
		return "redirect:"+path;
	}

}
