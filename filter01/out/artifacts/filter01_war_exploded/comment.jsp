<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2025/2/14
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论页面</title>
</head>
<body>
<h1>发表评论</h1>
违禁词：香蕉，苹果 ${errorInfo}
<form method="post" action="<%=request.getContextPath()%>/showcomment.jsp">
    U:<input type="text" name="username"><br/>
    评论:<textarea rows="3" cols="10" name="comment"></textarea><br/>
    <input type="submit" value="提交评论">
</form>
</body>
</html>
