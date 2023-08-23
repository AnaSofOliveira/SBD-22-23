<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>The Spoon</title>
<link rel="stylesheet" href="/WebContent/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.4.js" integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E=" crossorigin="anonymous"></script>
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
			The Spoon
		</a>


		<form class="form-inline">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>


		<!-- Logged Info -->
		<div class='form-inline my-2 my-lg-0'>
			<c:if test="${user == null}">
				<a class="nav-link btn btn-success text-white" href="./login.jsp">Iniciar Sessão</a>
				<a class="nav-link" href="./registar.jsp">Registar</a>
				
				
				<!-- <button type="button" class="btn btn-outline-success" value='signIn'>
					<a href="./login.jsp">Iniciar Sessão</a>
				</button>
				<button type="button" class="btn btn-success" value="register">
					<a href="./registar.jsp">Registar</a>
				</button>-->
			</c:if>

			<c:if test="${user != null}">
				<a class="nav-link btn btn-success text-white" href="./AbrirPerfilServlet">Bem-Vindo, ${user.nomeProprio}</a>
				<a class="nav-link" href="${pageContext.request.contextPath}/logoutServlet">Terminar Sessao</a>
				
				<!-- <a href="./AbrirPerfilServlet">Welcome, ${user.nomeProprio}</a>
				<button type="button" class="btn btn-outline-success" value='logout'>
					<a href="${pageContext.request.contextPath}/logoutServlet">Logout</a>
				</button> -->
			</c:if>
		</div>

	</nav>