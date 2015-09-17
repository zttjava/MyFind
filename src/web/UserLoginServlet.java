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

public class UserLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		BusinessService service = new BusinessService();

		User user = service.findUser(username, password);
		if(user == null){
			user = new User();
			user.setLoginInfo("ÕÊºÅ»òÃÜÂë´íÎó£¡<a href='/FindServer/login.jsp'>µÇÂ¼</a> <a href='/FindServer/register.jsp' target='_blank'>×¢²á</a>");
			request.setAttribute("user", user);
			request.getSession().getServletContext().setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			user.setLoginInfo("»¶Ó­Äú£º"+user.getUsername());
			request.setAttribute("user", user);
			request.getSession().getServletContext().setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
