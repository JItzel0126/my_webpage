<%--
  Created by IntelliJ IDEA.
  User: JS
  Date: 25. 8. 20.
  Time: 오후 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1>홈 JSP 테스트</h1>
<ul>
    <c:forEach var="a" items="${all}">
        <li>${a.title}, ${a.author}, ${a.description}</li>
    </c:forEach>
    <br />
    <c:forEach var="f" items="${fantasy}">
        <li>${f.title}, ${f.author}, ${f.description}</li>
    </c:forEach>
    <br />
    <c:forEach var="r" items="${romance}">
        <li>${r.title}, ${r.author}, ${r.description}</li>
    </c:forEach>
</ul>

</body>
</html>
