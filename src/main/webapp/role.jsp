<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp"%>
<form action="/inner/role" method="post" title="Создать роль">
    <input type="name" name="name" title="Название роли"/>
    <input type="submit" name="create" value="Создать роль">
</form>
<p>-----------------------------------------------------------------------</p>
<table border="1">
    <caption>Роли</caption>
    <tr>
        <td>ID</td>
        <td>Название</td>
        <td>Изменить</td>
        <td>Удалить</td>
    </tr>
    <c:forEach var="role" items="${roles}">
        <tr>
            <td><c:out value="${role.id}"/></td>
            <td><c:out value="${role.name}"/></td>
            <form action="/inner/role" method="post">
                <td><input style="display: none" type="text" name="id" value="${role.id}"><input type="submit" name="update" value="Изменить"></td>
                <td><input type="submit" name="delete" value="Удалить"></td>
            </form>
        </tr>
    </c:forEach>
</table>
<%@include file="footer.jsp"%>