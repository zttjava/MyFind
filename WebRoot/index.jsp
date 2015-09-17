<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon" href="res/favicon.ico" type="image/x-icon" />
<title>Find论坛</title>


</head>
<body>


	<c:if test="${user == null }">
		<div
			style="margin-left: 950px">
			<a href="/FindServer/login.jsp">您还未登录！</a> <a
				href="/FindServer/login.jsp">登录</a> <a
				href="/FindServer/register.jsp" target="_blank">注册</a>
		</div>
	</c:if>
	<c:if test="${user != null }">
		<div
			style="margin-left: 950px"><c:out value="${user.loginInfo
			}" escapeXml="true"></c:out>
			<a href="/FindServer/servlet/UserOutServlet">注销</a>	
		</div>

	</c:if>
	<a href="/FindServer/servlet/ArticleListServlet" style="margin-top: 100px;margin-left: 250px" target="_blank">查看文章</a>
	
  <form action="/FindServer/servlet/ArticleAddServlet" style="margin-top: 50px;margin-left: 250px">
    
    文章标题：<input type="text" name="title"/>					文章类型：<select name="articletype">
    
    <option value="java">java</option>
    <option value="android">android</option>
    <option value="javaweb">javaweb</option>
    </select><br/>
<textarea rows="20" cols="100" name="content"></textarea><br/>

        <input type="submit" value="发表文章"/>
    </form>
</body>
</html>
