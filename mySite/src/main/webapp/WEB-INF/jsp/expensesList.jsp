<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expenses List</title>
</head>
<body>

<c:forEach items="${expenses}" var="item" >
   <li>${item.description}  - ${item.amount} - ${item.date} - ${item.type}</li> 
</c:forEach>
<br />
Total Expenses Amount: ${totalAmount}
<br />
<a href = "/mainMenu">Return to MainMenu</a>
</body>
</html>