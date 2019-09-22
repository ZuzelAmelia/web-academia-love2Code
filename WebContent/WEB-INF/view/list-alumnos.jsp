<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Listado Alumnos</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Academia de Programación Love2Code - Listado de Alumnos</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- Botón Añadir Alumno -->
		
			<input type="button" value="Añadir alumno"
				   onclick="window.location.href='mostrarFormAgregarAlumno'; return false;"
				   class="add-button"
			/>
			
			<!--  añadimos una caja de búsqueda -->
			
           <form:form action="buscarAlumnos" method="GET">
               Buscar alumnos por nombre o apellidos: <input type="text" name="theSearchName" />
                
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
				
				<!-- bucle para imprimir alumnos -->
				<c:forEach var="tempAlumno" items="${alumnos}">
				
				<!-- creamos un "update" link con el id del alumno -->
				
					<c:url var="updateLink" value="/alumno/mostrarFormForUpdate">
						<c:param name="alumnoId" value="${tempAlumno.id}" />
					</c:url>	
					
					<!-- creamos un "delete" link con el id del alumno -->
				
					<c:url var="deleteLink" value="/alumno/eliminarAlumno">
						<c:param name="alumnoId" value="${tempAlumno.id}" />
					</c:url>	
									
					<tr>
						<td> ${tempAlumno.nombre} </td>
						<td> ${tempAlumno.primerApellido} </td>
						<td> ${tempAlumno.segundoApellido} </td>
						<td> ${tempAlumno.email} </td>
						
						<td>
							<!-- display the update and delete links -->
							<a href="${updateLink}">Editar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Desea borrar este estudiante de la base de datos?'))) return false">Borrar</a>
							|
							<a href="${updateLink}">Ver cursos</a>
							
							
						</td>
						
												
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	
	<div style="clear; both;">
		
		<p>
			<a href="${pageContext.request.contextPath}">Volver al Inicio</a>
		</p>
	
	</div>
</body>

</html>