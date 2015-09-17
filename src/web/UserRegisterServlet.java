package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusinessService;
import utils.WebUtils;

import domain.User;
import exception.UserExistException;

public class UserRegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String school = request.getParameter("school");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhonenumber(phonenumber);
		user.setSchool(school);
		user.setEmail(email);
		user.setId(WebUtils.makeId());
		BusinessService service = new BusinessService();
		try {
			service.addUser(user);
			request.setAttribute("message", "注册成功！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (UserExistException e) {
			e.printStackTrace();
			request.setAttribute("message", "用户名已存在！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
