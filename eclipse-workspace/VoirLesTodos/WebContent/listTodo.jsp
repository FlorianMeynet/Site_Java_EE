<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.web.propre.*"%>
<html>
<head>
<title>affichageListeTodos</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%  %>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>ESILV Engineer School</h2>
		</div>
	</div>
	
		
		
		<p>Welcome to your teacher account ${sessionScope.name}</p>
		
		
		<div id="container">
		<c:url var="AddLink" value="AddTodo"></c:url>	
		<a href="${AddLink}"> Add</a>
			<div id="content">
				<table>
					<tr>
						<th>Name of Todo</th>
						<th>Description of Todo</th>
						<th>Available Actions</th>
					</tr>

					<c:forEach var="x" items="${sessionScope.listTodo}">
					
						<c:url var="EditLink" value="EditTodo">
							<c:param name="todoId" value="${x.id }">
							</c:param>
						</c:url>
						<c:url var="DelLink" value="DelTodo">
							<c:param name="todoId" value="${x.id }">
							</c:param>
						</c:url>						
						<tr>
							<td>${x.title}</td>
							<td>${x.description }</td>
							<td><a href="${EditLink}"> Edit</a>
							<a href="${DelLink}"> Delete</a></td>							
						</tr>
						
					</c:forEach>

				</table>


			</div>
		</div>

	



</body>



</html>