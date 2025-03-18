<%--
  Created by IntelliJ IDEA.
  User: zl111
  Date: 2025/3/11
  Time: 下午8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试 request parameter</title>
</head>
<body>
<h2>获取到超链接参数值</h2>
<hr/>
<a href="vote/vote1?name=hspedu">获取超链接的参数</a>

<h1>获取到消息头</h1>
<hr>
<a href="vote/vote02">获取 http 消息头信息</a>

<form action="vote/vote03" method="post">
    主人号:<input type="text" name="id"><br>
    主人名:<input type="text" name="name"><br>
    宠物号:<input type="text" name="pet.id"><br>
    宠物名:<input type="text" name="pet.name"><br>
    <input type="submit" value="添加主人和宠物">
</form>
</body>
</html>
