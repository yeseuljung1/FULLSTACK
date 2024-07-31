<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<hr>
<%--세션 쪽에 user정보 넣어줘야 user 값 받아오기 가능하다--%>
<%--user 값이 null 이라면 로그인, 회원가입 화면 보여주기--%>
<c:if test="${empty user}">
    <a href="/login_form.jsp">로그인</a> | <a href="#">회원가입</a>
</c:if>
<%--user 값이 null이 아니라면 유저이름,로그아웃 화면 보여주기--%>
<c:if test="${!empty user}">
    <a href="/login.jsp">${user.name}</a>님의 정보 | <a href="#">로그아웃</a>
</c:if>

<hr>


<%--test에 있는 조건이 true이리 경우 해당 요소가 보여진다--%>
<%--권한이 관리자인 경우--%>
<c:if test="${role == 'ADMIN'}">관리자</c:if>
<%--권한이 관리자가 아닌경우--%>
<c:if test="${role != 'ADMIN'}">일반회원</c:if>
