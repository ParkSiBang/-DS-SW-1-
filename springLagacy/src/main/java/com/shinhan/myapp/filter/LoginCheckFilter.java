package com.shinhan.myapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.shinhan.myapp.vo.MemberDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * @WebFilter : Servlet3��������  �����Ѵ�. 
 */

@Slf4j
@WebFilter("*.doitdoitdo~ dodododo do~")
public class LoginCheckFilter implements Filter {

    
    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//��û�����ϱ��� 
		HttpServletRequest req = (HttpServletRequest)request;
		//��û�� �ּҸ� ����
		String contextPath = req.getServletContext().getContextPath();
		String uri = req.getRequestURI();
		uri = uri.substring(contextPath.length());//    /firstzone/dept/list.do
		log.info("contextPath:" + contextPath);

		if(!uri.equals("/auth/login.do") && !uri.contains("/rest")) {
			HttpSession session =  req.getSession();
			MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
			if(member == null) {
				log.info("로그인 해주세요~~");
				HttpServletResponse res = (HttpServletResponse)response;
				res.sendRedirect(contextPath + "/auth/login.do");
				return;
			}
		}
		chain.doFilter(request, response);

	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
