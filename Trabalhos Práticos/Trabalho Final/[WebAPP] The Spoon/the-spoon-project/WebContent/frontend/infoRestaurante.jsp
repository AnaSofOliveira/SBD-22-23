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
			<p>E-mail: ${restaurante.email}</p>
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

<!-- Se Tipo User Cliente -->
<c:if test="${tipo == 'cliente'}">
	<div class="container-fluid">
		<!-- Opções de reserva -->
		<div class="row justify-content-md-center">
		<a href="./IniciarReservaServlet?codigo=${restaurante.codigo}">
					<button type="submit" class="btn btn-outline-success" id='iniciarReserva'
						value='iniciarReserva'>Reservar</button>
			</a>
		
			<div class="col-4">
				
			</div>
		</div>
	</div>
</c:if>


<!-- Opções de gestão -->
<!-- Se Tipo User Funcionario -->
<c:if test="${user == 'funcionario'}">
	<div class="container-fluid">
		<!-- Lista reservas Pendentes -->


		<!-- Lista reservas Aceites -->

	</div>
</c:if>

<!-- FOOTER -->
<%@include file='../footer.jsp'%>