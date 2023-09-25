<!-- HEADER -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="theSpoon.model.dao.RecursoDAO"%>
<%@page import="theSpoon.model.entities.Recurso"%>
<%@page import="theSpoon.model.entities.Horario"%>
<%@page import="theSpoon.model.dao.RestauranteDAO"%>
<%@page import="theSpoon.model.entities.Restaurante"%>
<%@include file='../header.jsp'%>



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
						<td><fmt:formatDate pattern="HH:mm" type="time"
								value="${horario.horaInicio}" /></td>
						<td><fmt:formatDate pattern="HH:mm" type="time"
								value="${horario.horaFim }" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="col-md-7 ">
			<img src="data:image/jpg;base64,${recurso.imagemBase64}"
				alt="Restaurante Card image" width="100%">
		</div>
	</div>


	<!-- OPÇÇÕES DO CLIENTE -->
	<!-- Se Tipo User Cliente -->
	<c:if test="${tipo == 'cliente'}">
		<div class="container-fluid  mt-5">
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



	<!-- OPÇÇÕES DO FUNCIONARIO -->
	<c:if test="${tipo == 'funcionario' }">
		<!-- Reservas de Hoje -->
		<div class="container-fluid  mt-5">
			<h1>Reservas para Hoje:</h1>
			<div class="listaReservasHoje row justify-content-md-center">
				<table class="table table-hover">
					<tr>
						<th scope="col">#</th>
						<th scope="col">Nome</th>
						<th scope="col">Hora</th>
						<th scope="col">Itens</th>
						<th scope="col">Ações</th>
					</tr>

					<tr>
						<td>350</td>
						<td>Maria Isabel</td>
						<td>20:00</td>
						<td>
							<ul>
								<li>2 doses de limão</li>
								<li>5 doses de maçã</li>
							</ul>
						</td>
						<td>
							<button>
								<img src='./imgs/delete.png'>
							</button>
							<button>
								<img src='./imgs/edit.png'>
							</button>
						</td>
					</tr>
				</table>
				<!-- <a href="./IniciarReservaServlet?codigo=${restaurante.codigo}">
							<button class="btn btn-primary" data-toggle="modal"
								data-target="#reservaModal" id='iniciarReserva'
								value='iniciarReserva'>Fazer Reserva</button>
						</a> -->
			</div>
		</div>


		<!-- Próximas Reservas -->
		<div class="container-fluid mt-5">
			<h1>Próximas Reservas:</h1>
			<div class="listaReservasSeguintes row justify-content-md-center">

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


		<!-- Gerir Restaurante -->
		<div class="container-fluid mt-5">
			<h1>Gerir Restaurante</h1>
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








	<!-- OPÇÇÕES DO GERENTE -->

</div>

<!-- Modal de Reserva -->
<div class="modal fade" id="reservaModal" tabindex="-1" role="dialog"
	aria-labelledby="reservaModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="reservaModalLabel">Fazer Reserva</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Fechar">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<!-- Formulário de reserva -->
				<form id="formularioReserva">
					<div class="form-group">
						<label for="data">Data:</label> <input type="date"
							class="form-control" id="data" name="data" required>
					</div>
					<div class="form-group">
						<label for="hora">Hora:</label> <input type="time"
							class="form-control" id="hora" name="hora" required>
					</div>
					<div class="form-group">
						<label for="numeroPessoas">Número de Pessoas:</label> <input
							type="number" class="form-control" id="numeroPessoas"
							name="numeroPessoas" min="1" value="1" required>
					</div>
					<div class="form-group modal-error">
						<p>O restaurante não permite reservas no horário indicado.</p>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
				<button type="button" form="formularioReserva"
					class="btn btn-primary botaoReservar">Reservar</button>
			</div>
		</div>
	</div>
</div>


<script>

$(document).ready(function(){
	$(".modal-error").hide();

	$.ajax({
		type: "POST", 
		url: "ObterReservasHoje", 
		data: {
			codigoRestaurante: ${restaurante.codigo},
		}, 
		success: function(data){

			response = jQuery.parseJSON(JSON.stringify(data)); 

			console.log("response: " + response);
			console.log("restaurante: " + response.reservas);
			console.log("dataMarcacao: " + response.clientes);
			console.log("horaMarcacao: " + response.itens);


			var new_data = "<table class='table table-hover'><tr><th scope='col'>#</th><th scope='col'>Nome</th><th scope='col'>Hora</th>" +
							"<th scope='col'>Itens</th><th scope='col'>Ações</th></tr>";
			
			for (let i = 0; i < response.reservas.length; i++){

				new_data+="<tr><td>" + response.reservas[i].numero + "</td>"; //número da reserva
				new_data+="<td>" + response.clientes[i].nomeProprio + " " + response.clientes[i].apelido + "</td>"; // nome do cliente
				new_data+="<td>" + response.reservas[i].dataMarcacao + "</td>" // hora

				let itens = "<td><ul>";
				for(let j=0; j<response.itens[i].length; j++){
					itens+="<li>" + response.itens[0][j].designacao + "</li>";
				}

				new_data+=itens + "</ul></td>";

				new_data += "<td class='container row'><form class='col-6 p-0 text-center'><input type='hidden' id='codigoRestaurante" + 
							"value='${restaurante.codigo}'><input type='hidden' id='numeroReserva' value=" + response.reservas[i].numero + ">" + 
							"<button class='btn p-0 m-2'><img src='./imgs/delete.png' style='width: 100%;'></button></form></td>";
			}
			
			new_data+="</table>";

			
			$(".listaReservasHoje").html(new_data);
		}
	});
	
});

$(".botaoReservar").click(function(){

	console.log("Vou iniciar uma reserva através de um modal");
	console.log("Parametros"); 
	console.log("Codigo do Restaurante: " + ${restaurante.codigo}); 
	console.log("Data: " + $("#data").val()); 
	console.log("Hora: " + $("#hora").val());
	console.log("Numero de Pessoas: " + $("#numeroPessoas").val());

	$.ajax({
		type: "POST", 
		url: "ValidarHoraReservaServlet", 
		data: {
			codigoRestaurante: ${restaurante.codigo},
			dataHoraMarcacao: new Date($("#data").val() + " " + $("#hora").val()).getTime()
		}, 
		success: function(data){

			if(data){
				var params = {
						codigoRestaurante: ${restaurante.codigo}, 
						dataHoraMarcacao: new Date($("#data").val() + " " + $("#hora").val()).getTime(), 
						numeroPessoas: $("#numeroPessoas").val()};
				
				window.location='http://localhost:8080/the-spoon-project/IniciarReservaServlet?' + $.param(params);
			}else{
				console.log("O restaurante está fechado");
				$(".modal-error").css("color", "red");
				$(".modal-error").show();
			}
		}, 
		error: function(){
			// Adicionar mensagem de erro no modal em que não é possível reservar para o horário indicado
			console.log("erro");
			$(".modal-error").css("color", "red");
			$(".modal-error").show();			
		}
	});
	
	
});

</script>



<!-- Informações principais -->
<!-- <div class="container-fluid">
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
</div> -->

<!-- Se Tipo User Cliente -->
<!-- <c:if test="${tipo == 'cliente'}">
	<div class="container-fluid"> -->
<!-- Opções de reserva -->
<!-- <div class="row justify-content-md-center">
			<a href="./IniciarReservaServlet?codigo=${restaurante.codigo}">
				<button type="submit" class="btn btn-outline-success"
					id='iniciarReserva' value='iniciarReserva'>Reservar</button>
			</a>

			<div class="col-4"></div>
		</div>
	</div>
</c:if> -->


<!-- Opções de gestão -->
<!-- Se Tipo User Funcionario -->
<!-- <c:if test="${user == 'funcionario'}">
	<div class="container-fluid">
		<!-- Lista reservas Pendentes -->


<!-- Lista reservas Aceites -->

<!-- </div>
</c:if> -->

<!-- FOOTER -->
<%@include file='../footer.jsp'%>