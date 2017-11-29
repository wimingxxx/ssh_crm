<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/6 0006
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <link href="${pageContext.request.contextPath}">
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            loadSelect("004", "div", "cust_level.dict_id", "1");
            loadSelect("006", "span", "cust_level.dict_id", "1");
        });
    </script>
</head>
<body>

<h1>测试</h1>

<span id="span"/>

<div id="div"></div>

</body>
</html>
