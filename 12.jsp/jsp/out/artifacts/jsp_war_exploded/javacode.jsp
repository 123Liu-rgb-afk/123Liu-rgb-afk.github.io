<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lrx.domain.Monster" %><%--
  Created by IntelliJ IDEA.
  User: 刘
  Date: 2025/2/8
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的代码脚本</title>
</head>
<body>
<%
    ArrayList<Monster> monsters = new ArrayList<>();
    monsters.add(new Monster(1,"孙悟空","法天象地"));
    monsters.add(new Monster(2,"猪八戒","三十六天罡"));
%>
<table width="300px" border="1px">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>skill</th>
    </tr>
    <%
      for (int i = 0 ; i < monsters.size();i ++ ) {
          Monster monster = monsters.get(i);
    %>
    <tr>
        <th><%=monster.getId()%></th>
        <th><%=monster.getName()%></th>
        <th><%=monster.getSkill()%></th>
    </tr>
    <%
      }
    %>

</table>
</body>
</html>
