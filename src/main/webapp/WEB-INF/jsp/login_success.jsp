<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.01.2017
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="lang"/>
<html>
<head>
    <title><fmt:message key="login.success.title"/></title>
    <meta http-equiv="refresh" content="1; url=/do/?action=show-index">
</head>
<body>
<div align="center"><h1><b><fmt:message key="login.success.message"/></b></h1></div>

</body>
</html>
