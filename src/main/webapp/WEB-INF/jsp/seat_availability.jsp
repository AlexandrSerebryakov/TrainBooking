<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 09.01.2017
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="lang"/>
<fmt:message key="seat.availability.title" var="title"/>

<t:basicpage title="${title}">
    <jsp:body>
        <fmt:message key="seat.availability.stage"/>


        <label><b><fmt:message key="index.direction.from"/></b></label>
        <input type="text" name="directionFrom" placeholder="${loginPlaceholder}" required autofocus value="" readonly>
        <label><b><fmt:message key="index.direction.to"/></b></label>
        <input type="text" name="directionTo" placeholder="${loginPlaceholder}" required autofocus value="" readonly>
        <label><b><fmt:message key="index.direction.date"/></b></label>
        <input type="date" name="directionDate" placeholder="${loginPlaceholder}" required autofocus value="" readonly>

        <form action="/do/?action=goto-passenger-information-form" method="post">
            <button type="submit"><fmt:message key="seat.availability.button.find"></fmt:message></button>
        </form>
        <p align="right"><img src="../../advertising_tele2.jpg" alt="advertising_tele2.jpg"></p>

    </jsp:body>

</t:basicpage>
