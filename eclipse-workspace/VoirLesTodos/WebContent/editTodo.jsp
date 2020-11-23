<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link type="text/css" rel="stylesheet" href="css/style.css">
<title>Edit a todo</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>ESILV Engineer School</h2>
		</div>
	</div>
	<div id="container">
		<h3>Edit a TODO</h3>
		<form action="EditTodo" method="post">
			<table>
				<tbody>
					<tr>
						<td><label>title: </label></td>
						<td><input type="text" name="title"
							value="${Todo.title}" /></td>
					</tr>
					<tr>
						<td><label>description: </label></td>
						<td><input type="text" name="descr"
							value="${Todo.description}" /></td>
						<td><label></label></td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		<div style="clear: both;"></div>
		<a href="listTodo.jsp">Back to List</a>
	</div>
</body>
</html>
