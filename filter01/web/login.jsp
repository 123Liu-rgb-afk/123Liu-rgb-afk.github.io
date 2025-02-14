<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2025/2/14
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h1>用户登录</h1>
<form action="<%=request.getContextPath()%>/check" method="post">
    u:<input type="text" name="username"><br/>
    p:<input type="text" name="pwd"><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>
