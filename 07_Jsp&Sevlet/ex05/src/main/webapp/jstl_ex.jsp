<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오후 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL 테스트</h1>

<%--다른 문서를 삽입해야할 떄 include 사용법 --%>
<%--<%@include file="navbar.jsp"%>--%>
<jsp:include page="navbar.jsp"/>

<table >
<%--    members 리스트를 하나씩 가져와서 꺼내와서 member라는 이름으로 사용하겠다--%>
<%--    state 라는 이름으로 루프 내부의 정보를 사용 가능--%>
    <c:forEach var="member" items="${members}" varStatus="state">
        <tr>
            <td>${state.index}</td>
            <td>${member.name}</td>
            <td>${member.userid}</td>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>
