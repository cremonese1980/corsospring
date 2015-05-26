<%@ page contentType="text/html" session="false"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>

<div id="logo"><img src="images/logo.png" alt="Logo">
</div>
<div id="content">
<div id="insert"><img src="images/webflow-logo.jpg" width="55" height="32"/></div>
<h2>Lo adivinastes</h2>
<table>
	<tr>
		<td>Respuesta:</td>
		<td>${juego.respuesta}</td>
	</tr>
	<tr>
		<td>Total intentos:</td>
		<td>${juego.intentos}</td>
	</tr>
	<tr>
		<td>Tiempo empleado:</td>
		<td>${juego.duracion}</td>
	</tr>
	<tr>
		<td colspan="2" class="buttonBar">
			<form action="inicioswf.htm">
				<input type="hidden" name="_flowId"value="adivinanza"><br/>
			    <input type="submit" value="¡Juega de nuevo!">
			</form>
		</td>
	</tr>
</table>
</div>
  Session id: <%=  session.getId() %>
</body>
</html>