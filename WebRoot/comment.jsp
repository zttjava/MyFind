<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Find论坛</title>
<link rel="shortcut icon" href="res/favicon.ico" type="image/x-icon" />  
  </head>
  
  <body>
  	<ul>
  		<li>文章标题：<c:out value="${article.title }" escapeXml="true"></c:out></li>
  		<li>文章类型：<c:out value="${article.articletype}" escapeXml="true"></c:out></li>
  		<li>文章内容：<c:out value="${article.content }" escapeXml="true"></c:out></li>
  		<li>文章作者：<c:out value="${article.user.username}" escapeXml="true"></c:out></li><br/>
  	</ul>
  	<c:forEach var="comment"  items="${article.comments }">
  	<div style="margin-left: 20px;margin-top: 10px;color: red;">
  	评论作者：<c:out value="${comment.username }" escapeXml="true"></c:out><br/>
  	评论内容：<c:out value="${comment.content }" escapeXml="true"></c:out>
  	
  	</div>
  	</c:forEach>
  
  
  
  	<form action="/FindServer/servlet/ArticleCommentServlet" method="get" target="_blank">
  		<textarea rows="10" cols="40" name="content"></textarea><br/>
  		<input type="hidden" name="articleid" value="${article.articleid }"/>
  		<input type="submit" value="发表评论"/>
  	</form>
  </body>
</html>
