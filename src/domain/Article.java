package domain;

import java.util.Set;

public class Article {
	/*
	 * create table article(articleid varchar(60) primary key,title
	 * varchar(255),content varchar(2048),emittime varchar(40),lasttime
	 * varchar(40),articletype varchar(255),userid varchar(60), constraint
	 * userid_FK foreign key(userid) references user(id));
	 */
	private String articleid;
	private String title;
	private String content;
	private String emittime;
	private String lasttime;
	private String articletype;
	private User user;
	
	private Set<Comment> comments;//一对多。多的一方建立约束。
	
	private int count;
	
	
	public Set<Comment> getComments() {
		return comments;
	}
	
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public String getArticleid() {
		return articleid;
	}
	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmittime() {
		return emittime;
	}
	public void setEmittime(String emittime) {
		this.emittime = emittime;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public String getArticletype() {
		return articletype;
	}
	public void setArticletype(String articletype) {
		this.articletype = articletype;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
