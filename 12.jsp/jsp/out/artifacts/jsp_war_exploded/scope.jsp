<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2025/2/8
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的四大域对象01</title>
</head>
<body>
<%
    pageContext.setAttribute("k1","pageContext");
    request.setAttribute("k1","request");
    session.setAttribute("k1","session");
    application.setAttribute("k1","application");

    //request.getRequestDispatcher("/scope02.jsp").forward(request,response);

    response.sendRedirect(request.getContextPath() + "/scope02.jsp");
    
%>
<%--jsp的请求转发--%>
<%--<jsp:forward page="/scope02.jsp"></jsp:forward>--%>

<%=pageContext.getAttribute("k1")%><br/>
<%=request.getAttribute("k1")%><br/>
<%=session.getAttribute("k1")%><br/>
<%=application.getAttribute("k1")%>
</body>
</html>
