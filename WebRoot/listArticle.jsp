<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="shortcut icon" href="res/favicon.ico" type="image/x-icon" />
    <title>Find论坛</title>

  </head>
  
  <body>
  	<c:forEach var="article" items="${page.list }">
  	<ul>
  		<li>文章标题：<c:out value="${article.title }" escapeXml="true"></c:out></li>
  		<li>文章类型：<c:out value="${article.articletype}" escapeXml="true"></c:out></li>
  		<li>文章内容：<c:out value="${article.content }" escapeXml="true"></c:out></li>
  		<li>文章作者：<c:out value="${article.user.username}" escapeXml="true"></c:out></li><br/>
  		<!--  <a href="${pageContext.request.contextPath }/servlet/ArticleContentServlet?title=<c:out value='${article.title }' escapeXml='true'></c:out>&type=<c:out value='${article.articletype}' escapeXml='true'></c:out>&content=<c:out value='${article.content }' escapeXml='true'></c:out>&username=<c:out value='${article.user.username}' escapeXml='true'></c:out>">进入帖子</a>
  		-->
  		<a href="${pageContext.request.contextPath }/servlet/ArticleContentServlet?articleid=${article.articleid}" target="_blank">进入帖子</a>
  		</ul>
  	</c:forEach>
  	    当前第[${page.pagenum }]页 &nbsp; &nbsp;
    <c:if test="${page.pagenum>1 }">
    [<a href="${pageContext.request.contextPath }/servlet/ArticleListServlet?pagenum=${page.pagenum-1 }">上一页</a>]
    </c:if>
    <c:forEach var="pagenum" begin="${page.startnum}" end="${page.endnum}">
    	[<a href="${pageContext.request.contextPath }/servlet/ArticleListServlet?pagenum=${pagenum }">${pagenum }</a>]
    </c:forEach>
    <c:if test="${page.pagenum<page.totalpage }">
    [<a href="${pageContext.request.contextPath }/servlet/ArticleListServlet?pagenum=${page.pagenum+1 }">下一页</a>]
   	 </c:if>
    &nbsp; &nbsp;
    总共[${page.totalpage }]页，总[${page.totalrecord }]纪录
  </body>
</html>
