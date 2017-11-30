<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/30 0030
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>

<form action="${pageContext.request.contextPath }/UploadFileAction"
      method="post" enctype="multipart/form-data">

    <input type="file" name="upFile"/>

    <br>

    <input type="submit" value="上传文件"><br>


    <s:property value="#uprb.message"/><br>
    <s:property value="#uprb.filePath"/><br>
    <s:property value="#uprb.mime"/><br>

</form>

</body>
</html>
