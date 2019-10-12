<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>

<head>
<title>Los cursos del instructor seleccionado</title>

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
		<h3>Listado de cursos que imparte el instructor</h3>
		<i></i>

<c:url var="updateLink" value="/curso/mostrarFormForUpdate">
						<c:param name="cursoId" value="${tempCurso.id}" />
					</c:url>
			<!-- asociamos los datos con el id del Curso -->
			<table>

				<tbody>
					<tr>
						<td><label>Cursos:</label></td>
						<td><select name="instructor" onchange="window.location.href = 'mostrarFormAgregarCurso?instructorId=' + this.options[this.selectedIndex].value;">
								<option value="0">Los cursos</option>
								<c:forEach var="tempCurso" items="${cursos}">
									<option value="${tempCurso.id}">${tempCurso.titulo} ${tempCurso.instructor.nombre} </option>
								</c:forEach>
							</select></td>
					</tr>

				</tbody>
			</table>
			</div>

</body>

</html>

