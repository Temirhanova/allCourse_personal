<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="role" value='${sessionScope.role}'/>
<c:if test="${role != null}">
    <c:choose>
        <c:when test="${role == 1}">
            <c:import url="leftSidebarAdmin.jsp"/>
        </c:when>
        <c:when test="${role == 2}">
            <c:import url="leftSidebarManager.jsp"/>
        </c:when>
        <c:when test="${role == 3}">
            <c:import url="leftSidebarClient.jsp"/>
        </c:when>
        <c:when test="${role == 4}">
            <c:import url="leftSidebarTeacher.jsp"/>
        </c:when>
        <c:otherwise>
            <c:import url="leftSidebarAll.jsp"/>
        </c:otherwise>
    </c:choose>
</c:if>
<p style="color: #43bb79"><c:out value="${role}"/></p>
<c:if test="${role == null}">
    <c:import url="leftSidebarAll.jsp"/>
</c:if>

<footer class="footer">
    <strong>Footer:</strong>
</footer><!-- .footer -->

</body>
</html>
