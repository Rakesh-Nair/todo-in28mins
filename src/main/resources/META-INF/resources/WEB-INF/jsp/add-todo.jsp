<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
<title>Welcome Page</title>
</head>
<body>
	<div class="container mt-3 border">
		<h2>Enter Todo Details</h2>

		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description</form:label>
				<form:input type="text" path="description" required="required" />
				<form:errors cssClass="text-danger" path="description" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required" />
				<form:errors cssClass="text-danger" path="targetDate" />
			</fieldset>

			<fieldset class="mb-3">
				<form:input type="hidden" path="id" />
			</fieldset>

			<fieldset class="mb-3">
				<form:input type="hidden" path="done" />
			</fieldset>

			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>

	</div>

	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.3/jquery.min.js"></script>
</body>
</html>