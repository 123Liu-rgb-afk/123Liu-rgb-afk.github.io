<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2025/2/9
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>运算结果</title>
</head>
<body>
<h1>运算结果</h1>
<%=request.getAttribute("res")%>
<a href="<%=request.getContextPath()%>/cal/calUI.jsp">返回计算器</a>

</body>
</html>
