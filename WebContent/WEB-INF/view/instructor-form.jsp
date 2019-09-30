<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Añadir nuevo Instructor</title>

<style>
.error {
	color: red
}
</style>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Academia de Programación - Love2Code</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Instructor</h3>
		<i>Rellena el formulario. Los campos con asterisco (*) son
			obligatorios.</i>

		<form:form action="guardarInstructor" modelAttribute="instructor"
			method="POST">

			<!-- asociamos los datos con el id del alumno -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Nombre (*):</label></td>
						<td><form:input path="nombre" /></td>
						<td><form:errors path="nombre" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label>Primer Apellido (*):</label></td>
						<td><form:input path="primerApellido" /></td>
						<td><form:errors path="primerApellido" cssClass="error" /></td>

					</tr>
					<tr>
						<td><label>Segundo Apellido:</label></td>
						<td><form:input path="segundoApellido" /></td>
					</tr>

					<tr>
						<td><label>Email (*):</label></td>
						<td><form:input path="email" /></td>
						<td><form:errors path="email" cssClass="error" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/instructor/listado">Volver
				al listado</a>
		</p>

	</div>

</body>

</html>