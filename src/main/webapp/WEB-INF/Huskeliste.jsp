<%--
  Created by IntelliJ IDEA.
  User: madsa
  Date: 03-03-2020
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Din Kurv</title>
</head>
<body>
<h1>Velkommen til din Kurv</h1><br>
${sessionScope.besked}
<br>
<br>

<form action="AddItemServlet" method="post">
    <label for="fname">Skriv vare</label><br>
    <input type="text" id="fname" name="vareNavn"><br>

    <input type="submit" value="Tilføj">
</form>
<br>
<br>
${requestScope.besked}
<br>
<br>
<c:forEach var="element" items="${sessionScope.basket}">
    ${element}<br>


</c:forEach>


<br>
<br>
<br>
<br>

<form action="LogoutServlet" method="post">
    <%--<label for="fname">Skriv vare</label><br>
    <input type="text" id="fname" name="vareNavn"><br>--%>

    <input type="submit" value="Logout">
</form>


</body>
</html>
