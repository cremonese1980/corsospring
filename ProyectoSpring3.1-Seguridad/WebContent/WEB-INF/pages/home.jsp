<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
	<h1>Pagina inicial</h1>
	<p>
		Pagina accesible a todos los usuarios<br /> <a
			href="${pageContext.request.contextPath}/sec/moderation.html">Pagina
			de Moderacion</a><br /> <a
			href="${pageContext.request.contextPath}/admin/first.html">Primera
			pagina de Admin</a><br /> <a
			href="${pageContext.request.contextPath}/admin/second.html">Segunda
			pagina de Admin</a><br /> <a
			href="${pageContext.request.contextPath}/ciccio/method-security.html">Metodo
			seguro para Admin</a><br />
	</p>
</body>
</html>