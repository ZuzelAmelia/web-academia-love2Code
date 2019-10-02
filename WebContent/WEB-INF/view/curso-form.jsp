<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>

<head>
<title>Añadir nuevo Curso</title>

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
		<h3>Guardar Curso. Paso 2: Título del Curso</h3>
		<i>Rellena el formulario. Los campos con asterisco (*) son
			obligatorios.</i>

		<form:form action="guardarCurso" modelAttribute="curso" method="POST">

			<!-- asociamos los datos con el id del Curso -->
			<form:hidden path="id" />
			
			<table>
				<tbody>
				<tr>
				
					<td><label>Id Instructor del Curso:</label></td>
					<td><form:input path="instructor.id" readonly="true"></form:input></td>
					
					
				</tr>	
				
				<tr>
				
					<td><label>Nombre y apellidos del instructor:</label></td>
					<td><form:input path="instructor" readonly="true" disabled="true"></form:input></td>
									
				</tr>	
					
				<tr>
					<td><label>Título del Curso (*):</label></td>
					<td><form:input path="titulo" /></td>
					<td><form:errors path="titulo" cssClass="error" /></td>
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
			<a href="${pageContext.request.contextPath}/curso/listado">Volver
				al listado</a>
		</p>

	</div>

</body>

</html>