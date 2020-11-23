<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.web.propre.*"%>
<html>
<head>
<title>affichageListeTodos</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>ESILV Engineer School</h2>
		</div>
	</div>
	<p>Welcome to your student account ${sessionScope.name}</p>
	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>Name of Todo</th>
					<th>Description of Todo</th>
				</tr>

				<c:forEach var="x" items="${sessionScope.listTodo}">
					<tr>
						<td>${x.title}</td>
						<td>${x.description }</td>
					</tr>

				</c:forEach>

			</table>


		</div>
	</div>





</body>



</html>