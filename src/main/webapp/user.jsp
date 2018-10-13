<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp"%>
<form action="/inner/user" method="post" title="Создать пользователя">
    <input type="login" name="login" title="Логин"/>
    <input type="password" name="password" title="Пароль"/>
    <input type="role" name="role" title="Пароль"/>
    <input type="submit" name="create" value="Создать пользователя">
</form>
<table border="1">
    <caption>Подьзователи</caption>
    <tr>
        <td>ID</td>
        <td>Логин</td>
        <td>Пароль</td>
        <td>Роль</td>
        <td>Изменить</td>
        <td>Удалить</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td><c:out value="${user.role}"/></td>
            <td><form><input action="/inner/user?updateId=${user.id}" type="submit" name="upadte" value="Изменить"></form></td>
            <td><form><input action="/inner/user?deleteId=${user.id}" type="submit" name="upadte" value="Удалить"></form></td>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp"%>