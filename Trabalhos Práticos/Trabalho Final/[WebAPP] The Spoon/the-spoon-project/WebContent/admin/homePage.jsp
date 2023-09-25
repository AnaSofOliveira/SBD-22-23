<!-- HEADER -->
<%@include file='../header.jsp'%>

<!-- Info restaurante -->


	<div class="container mt-5">
	<div class="row">
		<h1>Restaurante ${restaurante.nome}</h1>
	</div>
	<div class="row">

		<div class="col-md-5">
			<p>
				<b>Morada: </b>${morada.designacao}, ${morada.codigoPostal } -
				${morada.zonaPostal }
			</p>
			<p>
				<b>Contacto: </b>${restaurante.telefone }</p>
			<p>
				<b>E-mail: </b>${restaurante.email}</p>
			<p>
				<b>Horário de Funcionamento:</b>
			</p>
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

			<!-- Se Tipo User Cliente -->
			<c:if test="${tipo == 'cliente'}">
				<div class="container-fluid">
					<!-- Opções de reserva -->
					<div class="row justify-content-md-center">

						<button class="btn btn-primary" data-toggle="modal"
							data-target="#reservaModal" id='iniciarReserva'
							value='${restaurante.codigo}'>Fazer Reserva</button>

						<!-- <a href="./IniciarReservaServlet?codigo=${restaurante.codigo}">
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#reservaModal" id='iniciarReserva'
								value='iniciarReserva'>Fazer Reserva</button>
						</a> -->
					</div>
				</div>
			</c:if>

		</div>
		<div class="col-md-7 ">
			<img src="data:image/jpg;base64,${recurso.imagemBase64}"
				alt="Restaurante Card image" width="100%">
		</div>
	</div>
</div>


<!-- FOOTER -->
<%@include file='../footer.jsp'%>