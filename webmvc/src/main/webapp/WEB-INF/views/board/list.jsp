<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%--for (Board b : bList) 와 같음 --%>
  <c:forEach var="b" items="${bList}">
      <li> ${b.writer} </li>
  </c:forEach>
</body>
</html>