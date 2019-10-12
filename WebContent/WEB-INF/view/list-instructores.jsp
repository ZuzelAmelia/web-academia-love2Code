<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Listado Instructores</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Academia de Programación Love2Code - Listado de Instructores</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- Botón Añadir Instructor -->

			<input type="button" value="Añadir instructor"
				onclick="window.location.href='mostrarFormAgregarInstructor'; return false;"
				class="add-button" />

			<!--  añadimos una caja de búsqueda -->

			<form:form action="buscarInstructores" method="GET">
               Buscar Instructor por nombre o apellidos: <input
					type="text" name="theSearchName" />

				<input type="submit" value="Buscar" class="add-button" />
			</form:form>

			<!--  add our html table here -->

			<table>
				<tr>
					<th>Nombre</th>
					<th>Primer Apellido</th>
					<th>Segundo Apellido</th>
					<th>Email</th>
					<th>Acción</th>
				</tr>

				<!-- bucle para imprimir instructores -->
				<c:forEach var="tempInstructor" items="${instructores}">

					<!-- creamos un "update" link con el id del instructor -->

					<c:url var="updateLink" value="/instructor/mostrarFormForUpdate">
						<c:param name="instructorId" value="${tempInstructor.id}" />
					</c:url>

					<!-- creamos un "delete" link con el id del instructor -->

					<c:url var="deleteLink" value="/instructor/eliminarInstructor">
						<c:param name="instructorId" value="${tempInstructor.id}" />
					</c:url>
					
					<!-- creamos un "viewCursosLink" link con el id del instructor para ver luego los cursos de ese instructor-->

					<c:url var="viewCursosLink" value="/instructor/listadoCursosInstructor">
						<c:param name="instructorId" value="${tempInstructor.id}" />
					</c:url>

					<tr>
						<td>${tempInstructor.nombre}</td>
						<td>${tempInstructor.primerApellido}</td>
						<td>${tempInstructor.segundoApellido}</td>
						<td>${tempInstructor.email}</td>

						<td>
							<!-- display the update and delete links --> 
							<a href="${updateLink}">Editar</a> | <a href="${deleteLink}"
							onclick="if (!(confirm('¿Desea borrar este instructor de la base de datos?'))) return false">Borrar</a>
							| <a href="${viewCursosLink}">Ver cursos</a>


						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
	<div style="">

		<p>
			<a href="${pageContext.request.contextPath}">Volver al Inicio</a>
		</p>

	</div>

</body>

</html>