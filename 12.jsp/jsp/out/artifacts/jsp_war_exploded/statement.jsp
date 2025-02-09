<%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2025/2/8
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp声明脚本</title>
</head>
<body>
<%!
    private String name = "liu";
    private int age;
    private static String company;

    static {
        company="合肥";

    }
    public void getName() {

    }

%>
</body>
</html>
