<!-- HEADER -->
<%@include file='../header.jsp'%>


<div class="container-fluid mt-5">

	<div class='col'>

		<div class="row mt-4 justify-content-center">
			<h1>Perfil de ${user.nomeProprio}</h1>
		</div>
		<div class="row mt-4 justify-content-center">
			<a href="./ConfigurarPerfilServlet" class="btn btn-success">Editar Perfil</a>
		</div>

		<div class="row mt-4 justify-content-center">
			<a href="./ListarReservasServlet" class="btn btn-success">Ver Reservas</a>
		</div>
	</div>

</div>
</div>


<!-- FOOTER -->
<%@include file='../footer.jsp'%>