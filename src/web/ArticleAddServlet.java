package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BusinessService;
import utils.WebUtils;

import domain.Article;
import domain.User;
import exception.UserExistException;

public class ArticleAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*private String articleid;
		private String title;
		private String content;
		private String emittime;
		private String lasttime;
		private String articletype;
		private User user;
		*/
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String articletype = request.getParameter("articletype");
		User user = (User) request.getSession().getServletContext().getAttribute("user");
		Article article = new Article();
		article.setTitle(title);
		article.setArticletype(articletype);
		article.setContent(content);
		article.setUser(user);
		article.setEmittime(format.format(new Date()));
		article.setLasttime(format.format(new Date()));
		article.setArticleid(WebUtils.makeId());
		/*if(user == null){
			request.setAttribute("message", "对不起，请先登录！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}*/
		BusinessService service = new BusinessService();
		try {
			service.addArticle(article);
			request.setAttribute("message", "发表成功！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "对不起，请先登录！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
