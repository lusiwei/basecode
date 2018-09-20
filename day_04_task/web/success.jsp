<%@ page import="utils.CookieUtil" %><%--
  Created by IntelliJ IDEA.
  User: lusiwei
  Date: 2018/9/19
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
    <link href="https://cdn.bootcss.com/animate.css/3.5.2/animate.css" rel="stylesheet">
    <style>
        body {
            /*display: flex;*/
            /*justify-content: flex-start;*/
            /*align-items: center;*/
        }

        #div {
            width: 60%;
            margin: 0 auto;
            text-align: center;
            vertical-align: middle;
        }
        #div{
            text-align: left;
        }
    </style>
</head>
<body>
<div id="div">
    <div>
        <h1 class="swing">欢迎你,<%out.write(request.getParameter("username") + "<br>");%>
        </h1>
        <p>
            <%
                out.write(request.getAttribute("message").toString());
            %>
        </p>
        <a href="/query">点击查看商品</a>
    </div>
</div>
</body>
</html>
