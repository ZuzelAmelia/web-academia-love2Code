<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Listado Cursos</title>
	
	<!-- Cargamos hoja de estilos -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Academia de Programaci�n Love2Code - Listado de Cursos</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- Bot�n A�adir Curso -->
		
			<input type="button" value="A�adir curso"
				   onclick="window.location.href='mostrarFormAgregarCurso'; return false;"
				   class="add-button"
			/>
			
			<!--  a�adimos una caja de b�squeda -->
			
           <form:form action="buscarCursos" method="GET">
               Buscar cursos por t�tulo: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Buscar" class="add-button" />
            </form:form>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
				
					<th>T�tulo del Curso</th>
					<th>Acci�n</th>
				</tr>
				
				<!-- bucle para imprimir cursos -->
				<c:forEach var="tempCurso" items="${cursos}">
				
				<!-- creamos un "update" link con el id del curso -->
				
					<c:url var="updateLink" value="/curso/mostrarFormForUpdate">
						<c:param name="cursoId" value="${tempCurso.id}" />
					</c:url>	
					
					<!-- creamos un "delete" link con el id del alumno -->
				
					<c:url var="deleteLink" value="/curso/eliminarCurso">
						<c:param name="cursoId" value="${tempCurso.id}" />
					</c:url>	
									
					<tr>
						<td> ${tempCurso.titulo} </td>
						
						
						<td>
							<!-- display the update and delete links -->
							<a href="${updateLink}">Editar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('�Desea borrar este curso de la base de datos?'))) return false">Borrar</a>
														
							
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