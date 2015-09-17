<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  	{"title":"${article.title }",
  		"articletype":"${article.articletype}",
  		"content":"${article.content }",
  		"username":"${article.user.username}",
  		"articleid":"${article.articleid}"}
  		
  		<br/>
  	<c:forEach var="comment"  items="${article.comments }">
  	{"username":"${comment.username}",
  	"content":"${comment.content }"}<br/>
  	 
  	</c:forEach>
 
  

