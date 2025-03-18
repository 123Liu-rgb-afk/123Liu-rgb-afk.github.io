<%--
  Created by IntelliJ IDEA.
  User: zl111
  Date: 2025/3/17
  Time: 下午8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" >
        $(function () {
            $("#getJson").click(function () {
                var href = this.href;
                var args = {"time": new Date()}
                $.post(
                    href,
                    args,
                    function (data) {
                        alert(" name= " + data.name + " address= " + data.address);
//1. data 是 json 对象
//2. JSON.stringify(data) 是将 json 对象转成字符串
                        alert("返回数据 json=" + data)
                        alert("返回数据 json=" + JSON.stringify(data))
                    },
                    "json"
                )
                return false;
            })

            $("button[name=butt1]").click(function () {
                var userName = $("#userName").val();
                var age = $("#age").val();
                $.ajax({
                    url: "/json/save2",
                    data: JSON.stringify({"userName": userName, "age": age}),
                    type: "POST",
                    success: function (data) {
                        alert("返回的信息=" + JSON.stringify(data));
                    },
                    contentType: "application/json;charset=utf-8"
                })


            })
        })
    </script>
</head>
<body>
<a href="<%=request.getContextPath()%>/json/dog" id="getJson">点击获取 json 数据</a>
<h1>发出一个 json 数据</h1>
u:<input id="userName" type="text"><br/>
a:<input id="age" type="text"><br/>
<button name="butt1">添加用户</button>

<h1>下载文件的测试 </h1>
<a href="<%=request.getContextPath()%>/json/downFile">点击下载文件</a>
</body>
</html>
