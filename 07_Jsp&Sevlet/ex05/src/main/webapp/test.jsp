<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
<%--    1.실습 숫자넣기--%>
//    int age= 10;
//    request.setAttribute("age",40);

<%--    2.실습 null넣기--%>
    Integer age= null;
    request.setAttribute("age",null);
%>




<html>
<head>
    <title>실습</title>
</head>
<body>
변수 age: <%= age%> <br>
EL age: ${age}
</body>
</html>
