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
    <title>jsp计算器</title>
    <script type="text/javascript">
        function check() {
            var num1 = document.getElementById("num1").value;
            var num2 = document.getElementById("num2").value;

            var reg = /^[-]?([1-9]\d*|0)$/;

            if(!num1.test(reg)) {
                alert("num1不是一个整数");
                return false;
            }
            if(!num2.test(reg)) {
                alert("num2不是一个整数");
                return false;

            }
            return true;
        }
    </script>

</head>
<body>
<h1>jsp计算器</h1>
<form action="<%=request.getContextPath()%>/calServlet" method="post" onsubmit="return check()">
    num1:<input type="text" id="num1" name="num1"><br/>
    num2:<input type="text" id="num2" name="num2"><br/>
    运算符:
    <select name="oper">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select><br/>
    <input type="submit" value="计算">
</form>

</body>
</html>
