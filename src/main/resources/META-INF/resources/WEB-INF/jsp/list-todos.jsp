<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<head>
<title>Welcome Page</title>
</head>
<body>
	<div> Welcome to Todos Application ${name}!! </div>
	<h2>Your Todos are :-</h2>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done ??</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</body>
</html>