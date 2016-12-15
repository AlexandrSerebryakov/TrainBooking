<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 15.12.2016
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Train booking - Главная страница</title>
</head>
<body>
<p align="center" style="color:#6352ff; font-size:30px">
    Расписание поездов и покупка билетов прямо здесь и сейчас!</p>
<form>
    <p align="center" style="color:#302cff; font-size:20px">
        Логин:
        <input name="userAuthorizationLogin" type="text" size="30">
        &nbsp;
        Пароль:
        <input name="userAuthorizationPassword" type="password" size="30">
        &nbsp;

        <button>Войти в систему</button>
        &nbsp;
        <a href="${pageContext.request.contextPath}/registration.jsp" class="linkEnter">Регистрация</a>
        &nbsp;
        Выберите язык:
        &nbsp;
        <select name="languageSelection" size="1">
            <option value="first">English</option>
            <option selected="selected" value="second">Русский</option>
        </select>

    </p>
</form>


</body>
</html>
