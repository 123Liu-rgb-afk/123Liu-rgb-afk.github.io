<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2025/2/8
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    --%>
    <title>jsp的表达式脚本</title>
</head>
<body>
<%
    //

<%--    --%>
    /*

     */
    String name = "liu";
    String email = request.getParameter("email");
%>
用户名:<%=name%><br/>
邮件:<%=email%><br/>
年龄:<%=request.getParameter("age")%>
</body>
</html>
