<%--
  Created by IntelliJ IDEA.
  User: lusiwei
  Date: 2018/9/21
  Time: 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=pageContext.getAttribute("pageContext")%>
<%=request.getAttribute("request")%>
<%=session.getAttribute("session")%>
<%=application.getAttribute("application")%>
</body>
</html>
