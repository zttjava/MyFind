<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>Find论坛</title>
    <link rel="shortcut icon" href="res/favicon.ico" type="image/x-icon" />
  </head>
  
  <body>
    <form action="/FindServer/servlet/UserRegisterServlet">
    
    用户：<input type="text" name="username"><br/>
     密码：<input type="password" name="password"><br/>
      电话：<input type="text" name="phonenumber"><br/>
       邮箱：<input type="text" name="email"><br/>
        学校：<input type="text" name="school"><br/>
        <input type="submit" value="注册">
    </form>
  </body>
</html>
