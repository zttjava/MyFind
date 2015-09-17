package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Comment;
import domain.User;

import service.BusinessService;
import utils.WebUtils;

public class ArticleCommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessService service = new BusinessService();
		String content = request.getParameter("content");
		User user = (User) request.getSession().getServletContext().getAttribute("user");
		String articleid = request.getParameter("articleid");
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setId(WebUtils.makeId());
		comment.setArticleid(articleid);
		comment.setUsername(user.getUsername());
		service.addComment(comment);
		if(user == null){
			request.setAttribute("message", "对不起，请先登录！");
		}else{
			request.setAttribute("message", "评论成功！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
