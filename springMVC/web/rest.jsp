<%--
  Created by IntelliJ IDEA.
  User: zl111
  Date: 2025/3/11
  Time: 下午8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">

        $(function (){
            $("#deleteBook").click(function () {
                $("#hiddenForm").attr("action",this.href)
                $(":hidden").val("DELETE")
                $("#hiddenForm").submit()
                return false;
            })
        })


    </script>

</head>
<body>
<h3>Rest 风格的 crud 操作案例</h3>
<br>
<hr>
<h3>rest 风格的 url 查询书籍[get]</h3>
<a href="user/book/100">点击查询书籍</a>
<br>
<hr>
<h3>rest 风格的 url 添加书籍[post]</h3>
<form action="user/addbook" method="post">
    name:<input name="bookName" type="text"><br>
    <input type="submit" value="添加书籍">
</form>
<br>
<hr>
<h3>rest 风格的 url, 删除一本书</h3>
<!-- 1. 这里我们需要将删除方式（get）转成 delete 的方式，需要使用过滤器和 jquery 来完成
2. name="_method" 名字需要写成 _method 因为后台的 HiddenHttpMethodFilter
就是按这个名字来获取 hidden 域的值，从而进行请求转换的. -->
<a href="user/deleteBook/100" id="deleteBook">删除指定 id 的书</a>
<form action="" method="post" id="hiddenForm">
    <input type="hidden" name="_method">
</form>

<br>
<hr>
<h3>rest 风格的 url 修改书籍[put]~</h3>
<form action="user/book/100" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="修改书籍~">
</form>
</body>
</html>
