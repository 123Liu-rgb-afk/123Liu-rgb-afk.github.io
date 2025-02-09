<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2025/2/8
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的四大域对象02</title>
</head>
<body>

<%=pageContext.getAttribute("k1")%><br/>
<%=request.getAttribute("k1")%><br/>
<%=session.getAttribute("k1")%><br/>
<%=application.getAttribute("k1")%>
</body>
</body>
</html>
