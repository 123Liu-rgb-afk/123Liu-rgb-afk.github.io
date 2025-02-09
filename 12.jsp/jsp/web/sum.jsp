<%@ page import="org.apache.jasper.runtime.HttpJspBase" %><%--
  Created by IntelliJ IDEA.
  User: zl111
  Date: 2025/2/8
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp求和</title>
</head>
<body>

<%
    int i = 10;
    int j = 20;
    int sum = i + j;

    out.println(i + "+" + j + "=" + sum);


%>
</body>
</html>
