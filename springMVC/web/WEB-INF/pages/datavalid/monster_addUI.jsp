<%--
  Created by IntelliJ IDEA.
  User: zl111
  Date: 2025/3/17
  Time: 下午6:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>添加妖怪~~</h3>
<!-- 这里的表单，我们使用 springMVC 的标签来完成
特别说明几点:
1. SpringMVC 表单标签在显示之前必须在 request 中有一个 bean, 该 bean 的属性
和表单标签的字段要对应!
request 中的 key 为: form 标签的 modelAttrite 属性值， 比如这里的 monsters
2. SpringMVC 的 form:form 标签的 action 属性值中的 / 不代表 WEB 应用的根目
录. -->
<%--@elvariable id="monster" type=""--%>
<form:form action="/save" method="POST" modelAttribute="monster">
    妖怪名字: <form:input path="name"/> <form:errors path="name"/> <br><br>
    妖怪年龄~: <form:input path="age"/> <form:errors path="age"/><br><br>
    电子邮件: <form:input path="email"/> <form:errors path= "email"/><br><br>
    妖怪生日~: <form:input path="birthday"/> <form:errors path="birthday"/><br><br>
    妖怪薪水: <form:input path="salary"/> <form:errors path="salary"/><br><br>
    <input type="submit" value="添加妖怪"/>
</form:form>
</body>
</html>