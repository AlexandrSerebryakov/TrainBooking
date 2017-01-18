<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 08.01.2017
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<fmt:setBundle basename="lang"/>
<fmt:message key="payment.title" var="title"/>

<t:basicpage title="${title}">
    <jsp:body>
        <fmt:message key="payment.stage"/>


        <label><b><fmt:message key="index.direction.from"/></b></label>
        <input type="text" name="directionFrom" placeholder="${loginPlaceholder}" required autofocus value="" readonly>
        <label><b><fmt:message key="index.direction.to"/></b></label>
        <input type="text" name="directionTo" placeholder="${loginPlaceholder}" required autofocus value="" readonly>
        <label><b><fmt:message key="index.direction.date"/></b></label>
        <input type="date" name="directionDate" placeholder="${loginPlaceholder}" required autofocus value="" readonly>

        <form action="/do/?action=goto-ticket-form" method="post">
            <button type="submit"><fmt:message key="payment.button.receive.ticket"></fmt:message></button>
        </form>
        <p align="right"><img src="../../advertising_meh_2!.jpg" alt="advertising_meh_2!"></p>


    </jsp:body>

</t:basicpage>
