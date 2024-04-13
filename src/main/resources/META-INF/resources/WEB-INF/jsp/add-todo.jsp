<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
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
<%@ include file="common/footer.jspf"%>
<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>