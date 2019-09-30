<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Academia Love2Code- Inicio</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Academia de Programación Love2Code - Bienvenidos</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<a href="instructor/listado">Gestión de Instructores</a> <br>
			<br> <a href="curso/listado">Gestión de Cursos</a> <br>
			<br> <a href="alumno/listado">Gestión de Alumnos</a>

		</div>
	</div>

</body>
</html>