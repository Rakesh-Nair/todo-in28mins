<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
<title>Welcome Page</title>
</head>
<body>
	<div class="container border">
		<h2>Add Todo</h2>

		<form:form method="post" modelAttribute="todo">
			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label">Enter
					Description</label>
				<div class="col-sm-4 col-form-label">
					<form:input cssClass="form-control" type="text" path="description"
						required="required" />
				</div>
				<div class="col-sm-4 col-form-label">
					<form:errors type="text" cssClass="text-danger" path="description" />
				</div>
			</div>

			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label"></label>
				<div class="col-sm-4 col-form-label">
					<form:input class="form-control" type="hidden" path="id" />
				</div>

			</div>

			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label"></label>
				<div class="col-sm-4 col-form-label">
					<form:input class="form-control" type="hidden" path="done" />
				</div>

			</div>
			<div class="form-group row col-sm-2">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>

		</form:form>

	</div>

	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.3/jquery.min.js"></script>
</body>
</html>