<!-- HEADER -->
<%@include file='../header.jsp'%>

<!-- Mensagem de sucesso com informações da reserva -->
<!-- TODO: Mensagem de sucesso com informações da reserva -->
<!-- Adicionar informações dinamicas consoante a reserva -->

<div class="container mt-5">
	<div class="jumbotron success text-center">
		<h1 class="display-4">Reserva Confirmada!</h1>
		<p class="lead">Sua reserva no restaurante ${restaurante.nome}
			foi confirmada com sucesso.</p>
	</div>
	<div class="row">
		<div class="col-md-6">
			<h2>Detalhes da Reserva</h2>
			<p>
				<strong>Restaurante:</strong> ${restaurante.nome}
			</p>
			<p>
				<strong>Número de Pessoas:</strong> ${reserva.nroPessoas} pessoas
			</p>
			<p>
				<strong>Data e Hora:</strong> ${dataHora} 
			</p>

		</div>
		
		<!--  foreach caracteristica (caso exista) -->
		<div class="col-md-6">
			<c:if test="${not empty caracteristicas }">
				<h3>Caracteristicas da Reserva</h3>
				<ul>
					<c:forEach var="caracteristica" items="${caracteristicas}" varStatus="loop">
						<li>${caracteristica.caracteristica} </li>
					</c:forEach>
				</ul>
			</c:if>
		<!--  foreach itens (caso existam) -->
			
			<c:if test="${not empty itens }">
				<h3 class="mt-5">Itens Reservados</h3>
				<ul>			
					<c:forEach var="item" items="${itens}" varStatus="loop">
						<li>${item.descricao} : ${item.quantidade } doses</li>
					</c:forEach>
				</ul>
			</c:if>

		</div>
	</div>
</div>

<!-- FOOTER -->
<%@include file='../footer.jsp'%>