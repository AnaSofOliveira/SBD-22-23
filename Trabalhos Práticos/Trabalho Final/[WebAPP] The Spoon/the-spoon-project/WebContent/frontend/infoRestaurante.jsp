<!-- HEADER -->
<%@page import="java.util.ArrayList"%>
<%@page import="theSpoon.model.dao.RecursoDAO"%>
<%@page import="theSpoon.model.entities.Recurso"%>
<%@page import="theSpoon.model.entities.Horario"%>
<%@page import="theSpoon.model.dao.RestauranteDAO"%>
<%@page import="theSpoon.model.entities.Restaurante"%>
<%@include file='../header.jsp'%>

<!-- Informações principais -->
<div class="container-fluid">
	<div class="row">
		<div class="col-7 ">
			<img class="card-img-top"
				src="data:image/jpg;base64,${recurso.imagemBase64}"
				alt="Restaurante Card image" width="800px" height="600px">
		</div>

		<div class="col-5">
				<h2>Contatos</h2>
				<p>E-mail: ${restautante.email}</p>
				<p>Telefone: ${restaurante.telefone}</p>
			
			<br>
				<h2>Horários</h2>

				<table class="table table-hover">
					<tr>
						<th scope="col">Dia Semana</th>
						<th scope="col">Abertura</th>
						<th scope="col">Fecho</th>
					</tr>

					<c:forEach var="horario" items="${horarios}">
						<tr>
							<td>${horario.diaSemana }</td>
							<td>${horario.horaInicio }</td>
							<td>${horario.horaFim }</td>
						</tr>
					</c:forEach>
				</table>
		</div>

	</div>
</div>

<div class="container-fluid">

<div class="row justify-content-md-center">
	<div class="col-4">
		<button type="button" class="btn btn-outline-success" value='reservar'>
		<a href="./ReservaServlet?codigoRestaurante=${restaurante.codigo}">Realizar reserva</a>
</button>
	</div>
</div>
</div>

<!-- Opções Reservas -->

<!-- Listar Reservas -->

<!-- FOOTER -->
<%@include file='../footer.jsp'%>