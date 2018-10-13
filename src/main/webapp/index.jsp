<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
    <p>This admin index</p>
<c:set var="error" value="${param.errorCode}"/>
<c:if test="${!(''.equals(error))}">
    <c:choose>
        <c:when test="${'wrongLogin'.equals(error)}">
            <p style="color: #FF2222"> Error: wrongLogin.</p>
        </c:when>
        <c:when test="${'accessDenied'.equals(error)}">
            <p style="color: #FF2222"> Error: accessDenied.</p>
        </c:when>
    </c:choose>
</c:if>

<c:set var="access" value="${param.access}"/>
<c:if test="${'accesIsOpen'.equals(''+access)}">
    <p style="color: #06ff0b"> Yes: access is open!!!</p>
</c:if>



<%@include file="footer.jsp"%>
