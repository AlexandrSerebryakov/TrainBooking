<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.12.2016
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="lang"/>
<fmt:message key="index.title" var="title"/>

<t:basicpage title="${title}">
    <jsp:body>

        <fmt:message key="index.stage"/>

        <label><b><fmt:message key="index.direction.from"/></b></label>
        <input type="text" name="directionFrom" placeholder="${loginPlaceholder}" required autofocus value="">
        <label><b><fmt:message key="index.direction.to"/></b></label>
        <input type="text" name="directionTo" placeholder="${loginPlaceholder}" required autofocus value="">
        <label><b><fmt:message key="index.direction.date"/></b></label>
        <input type="date" name="directionDate" placeholder="${loginPlaceholder}" required autofocus value="">

        <form action="/do/?action=goto-schedule-form" method="post">
            <button type="submit"><fmt:message key="index.button.find"></fmt:message></button>
        </form>
        <p align="right"><img src="../../advertising_beeline.jpg" alt="advertising_beeline.jpg"></p>


    </jsp:body>

</t:basicpage>
