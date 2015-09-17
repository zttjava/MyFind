<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${page.pagenum<=page.totalpage}">
	${page.endnum}<br/>
</c:if>
  	<c:forEach var="article" items="${page.list }" >
  	
  		{"title":"${article.title }",
  		"articletype":"${article.articletype}",
  		"content":"${article.content }",
  		"username":"${article.user.username}",
  		"articleid":"${article.articleid}"}
  		<br/>
  		
  	</c:forEach>

