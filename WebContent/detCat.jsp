<%@page import="model.categoria.CategoriaBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="script/perifericheLibere.js"></script>

<%
	CategoriaBean categoria = (CategoriaBean) session.getAttribute("categoria");
%>

</head>
<body>

	<input type="hidden" value="<%=session.getId()%>" id="session">

	<%=categoria.getNome()%>,
	<%=categoria.getDescrizione()%>
	<img src=<%=categoria.getImmagine()%>>

	<div id="periferiche"></div>
	<div id="prezzoTotale">
		<h1 id="prezzo"></h1>
	</div>
	<form action="Prenota" method="post" id="form">
		<input type="submit" value="submit">
	</form>
</body>
</html>