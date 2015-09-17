package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusinessService;

import domain.Article;
import domain.User;

public class ArticleContentServletForA extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*String	title =  request.getParameter("title");
		String	content =  request.getParameter("content");
		String	type =  request.getParameter("type");
		String	username =  request.getParameter("username");
		Article article = new Article();
		article.setTitle(title);
		article.setArticletype(type);
		article.setContent(content);
		User user = new User();
		user.setUsername(username);
		article.setUser(user);
		request.setAttribute("article", article);
		request.getRequestDispatcher("/comment.jsp").forward(request, response);*/
		String	articleid =  request.getParameter("articleid");
		BusinessService service = new BusinessService();
		Article article = service.findArticle(articleid);
		request.setAttribute("article", article);
		request.getRequestDispatcher("/commentForA.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
