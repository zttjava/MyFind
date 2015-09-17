package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import domain.Page;

import service.BusinessService;

public class ArticleListServletForA extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String pagenum = request.getParameter("pagenum");
		BusinessService service = new BusinessService();
		
		Page page = service.findPartArticle(pagenum);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/listArticleForA.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
