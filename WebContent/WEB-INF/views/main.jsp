<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>To Do Services Beta v.01</title>
</head>
<body>
	<form action="add" method="post">
		<input name="task" type="text" maxlength="100" size="100">
		<button type="submit">Submit</button>
	</form>
	<div class="content">
		<ul>
			<c:forEach var="task" items="${taskList }">
				<li>${task.taskName }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>