package domain;

public class Comment {
	/*create table comment(id varchar(40) primary key,content varchar(1024),username varchar(40),articleid varchar(40),constraint
	 articleid_FK foreign key(articleid) references article(articleid));
	 */
	private String id;
	private String content;
	private String articleid;
	private String username;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getArticleid() {
		return articleid;
	}

	public void setArticleid(String articleid) {
		this.articleid = articleid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
