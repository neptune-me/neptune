package com.login.javaweb;

import javax.servlet.http.HttpServlet;

public class loginServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		System.out.println("�û�����"+username);
		System.out.println("���룺"+password);
		super.service(req, resp);
	}
}
