<%--
  Created by IntelliJ IDEA.
  User: Hongchuan
  Date: 2020/3/23
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String name=(String)request.getAttribute("Servlet");%>
我的爱好是<%=name%>

</body>
</html>