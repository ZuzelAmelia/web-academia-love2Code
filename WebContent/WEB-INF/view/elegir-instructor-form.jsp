<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>

<head>
<title>Paso 1: Seleccionar instructor</title>

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
		<h3>Paso 1: Selecciona el  instructor</h3>
		<i></i>


	

			<!-- asociamos los datos con el id del Curso -->

			<table>

				<tbody>
					<tr>
						<td><label>Instructor (*):</label></td>
						<td><select name="instructor" onchange="window.location.href = 'mostrarFormAgregarCurso?instructorId=' + this.options[this.selectedIndex].value;">
								<option value="0">Selecciona el instructor</option>
								<c:forEach var="tempInstructor" items="${instructores}">
									<option value="${tempInstructor.id}">${tempInstructor.nombre}
										${tempInstructor.primerApellido} ${tempInstructor.segundoApellido}</option>
								</c:forEach>
						</select></td>
					</tr>


				</tbody>
			</table>

			</div>

</body>

</html>

