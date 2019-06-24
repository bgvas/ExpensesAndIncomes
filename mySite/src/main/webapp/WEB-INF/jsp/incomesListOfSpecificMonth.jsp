<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Incomes List For a Specific Month</title>
</head>
<body>

<h1>${noExpenses}Month: ${month}</h1>
<c:forEach items="${incomesList}" var="item" >
   ${item.description} - ${item.amount} - ${item.type}<br />
</c:forEach>
<br />
Total Incomes Amount: ${totalAmount}
<br />
<a href = "/mainMenu">Return to MainMenu</a>
</body>
</html>