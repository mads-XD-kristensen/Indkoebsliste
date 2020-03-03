<%--
  Created by IntelliJ IDEA.
  User: madsa
  Date: 02-03-2020
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Indkøbsliste</title>
</head>
<body>
<h1>Velkommen til din online indkøbsliste</h1>
<br>
<br>
<br>
${requestScope.besked}
<br>
<form action="LoginServlet" method="post">
    <label for="fname">Brugernavn</label><br>
    <input type="text" id="fname" name="navn"><br>
    <label for="lname">Kode</label><br>
    <input type="text" id="lname" name="kodeord"><br><br>
    <input type="submit" value="login">
</form>

</body>
</html>
