<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
<title>Login Page</title>
</head>
<body>
	<div class="container border">
		<h2>Welcome to Login Page !!</h2>
		<pre>${error}</pre>
		<form method="post">
			<div class="form-group row">
				<label for="name" class="col-sm-2 col-form-label">Username</label>
				<div class="col-sm-4 col-form-label">
					<input class="form-control" type="text" name="name" />
				</div>

			</div>

			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-4 col-form-label">
					<input class="form-control" type="password" name="password" />
				</div>

			</div>


			<div class="form-group row col-sm-2">
				<!-- <input class="form-control" type="submit"> -->
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
			

		</form>
	</div>
	<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.3/jquery.min.js"></script>
</body>
</html>