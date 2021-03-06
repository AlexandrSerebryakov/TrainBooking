<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.12.2016
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="lang"/>

<fmt:message key="login.title" var="title"/>
<fmt:message key="register.login.placeholder" var="loginPlaceholder"/>
<fmt:message key="register.password.placeholder" var="passwordPlaceholder"/>
<c:set var="orderErrorMessage" value="${loginErrorMessages}"/>

<t:basicpage title="${title}">

    <jsp:body>
        <p><fmt:message key="login.message"/></p>

        <form action="/do/?action=login" method="post">
            <label><b><fmt:message key="register.login"/></b></label><br>
            <input type="text" name="login" placeholder="${loginPlaceholder}" value="manager" required autofocus>
            <br><br>
            <label><b><fmt:message key="register.password"/></b></label><br>
            <input type="password" name="password" value="1" placeholder="${passwordPlaceholder}" required><br><br>
            <button type="submit"><fmt:message key="login.button.submit"/></button>
            <br>
            <c:if test="${not empty orderErrorMessage}">
                <div id="errorcolortext"><fmt:message key="${loginErrorMessages}"/></div>
            </c:if>
        </form>
    </jsp:body>

</t:basicpage>








