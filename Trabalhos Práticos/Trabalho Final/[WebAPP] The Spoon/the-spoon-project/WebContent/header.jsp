<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Spoon</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<!-- Logo -->
		<a class="navbar-brand" href="${pageContext.request.contextPath}"> <img
			src="${pageContext.request.contextPath}/WebContent/imgs/spoon.png"
			width="30" height="30" class="d-inline-block align-top" alt="">
			Bootstrap
		</a>


		<form class="form-inline">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>


		<!-- Logged Info -->
		<div>
			<c:if test="${user == null}">
				<button type="button" class="btn btn-outline-success" value='signIn'>
					<a href="./login.jsp">Iniciar Sessão</a>
				</button>
				<button type="button" class="btn btn-success" value="register">
					<a href="./registar.jsp">Registar</a>
				</button>
			</c:if>

			<c:if test="${user != null}">
				<a href="./AbrirPerfilServlet">Welcome, ${user.nomeProprio}</a>
				<button type="button" class="btn btn-outline-success" value='logout'>
					<a href="${pageContext.request.contextPath}/logoutServlet">Logout</a>
				</button>
			</c:if>
		</div>

	</nav>