package service;



import java.util.List;

import dao.ArticleDao;
import dao.CommentDao;
import dao.UserDao;
import domain.Article;
import domain.Comment;
import domain.Page;
import domain.User;
import exception.UserExistException;

public class BusinessService {
	UserDao dao = new UserDao();
	ArticleDao adao = new ArticleDao();
	CommentDao cdao = new CommentDao();
	public void addUser(User user) throws UserExistException {
		if(dao.find(user.getUsername())!=null){
			throw new UserExistException("注册的用户名已存在！！！");
		}
		dao.add(user);

	}

	public User findUser(String username, String password) {
		User user = dao.find(username, password);
		return user;

	}
	public void addArticle(Article article) throws UserExistException {
		
		adao.add(article);

	}

	public List<Article> findAllArticle() {
		return adao.findAll();

	}
	public Page findPartArticle(String pagenum) {
		int totalrecord = adao.getTotalRecord();
		Page page = null;
		if(pagenum == null){
			page = new Page(1,totalrecord);
		}else{
			int intpagenum = Integer.parseInt(pagenum);
			page = new Page(intpagenum,totalrecord);
		}
		List list = adao.getPageData(page.getStartindex(), page.getPagesize());
		page.setList(list);
		return page;

	}
	public void addComment(Comment comment){
		cdao.add(comment);
	}
	public Article findArticle(String articleid){
		return adao.findArticle(articleid);
	}
	
}
