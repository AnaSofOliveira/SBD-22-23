
<!-- HEADER -->
<%@include file='../header.jsp'%>

<div class="container mt-5">
	<h1>Reservas:</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nro. Reserva</th>
				<th>Data Reserva</th>
				<th>Restaurante</th>
				<th>Status</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="reserva" items="${reservas}" varStatus="loop">
				<tr>
					<td>${reserva.numero }</td>
					<td>${reserva.dataMarcacao }</td>
					<td>${restaurantes[loop.index].nome}</td>
					<td>${estados[loop.index]}</td>
					<td class="container row"><c:if
							test="${estados[loop.index] == 'Pendente'}">
							<form class="edit col-2 p-0 text-center">
								<input type='hidden' id="codigoRestaurante"
									value="${restaurantes[loop.index].codigo}"> <input
									type='hidden' id="numeroReserva" value="${reserva.numero }">

								<button class='btn p-0 m-2' style="background-color: transparent;">
									<img alt="edit" src="./imgs/edit.png" style="width: 100%;">
								</button>
							</form>


							<form class="delete col-2 p-0 text-center">
								<input type='hidden' id="codigoRestaurante"
									value="${restaurantes[loop.index].codigo}"> <input
									type='hidden' id="numeroReserva" value="${reserva.numero }">

								<button class='btn p-0 m-2' style="background-color: transparent;">
									<img alt="delete" src="./imgs/delete.png" style="width: 100%;">
								</button>
							</form>

						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>


<script>
	$(".delete").on(
			"click",
			function() {
				$.ajax({
					type : "POST",
					url : "removerReservaServlet",
					data : {
						codigoRestaurante : $(this).find(
								"#codigoRestaurante:first").val(),
						numeroReserva : $(this).find("#numeroReserva:first")
								.val()
					},
					complete : function() {
						window.location.reload(true);
					}
				});

			});

	$(".btn.delete").on("click", function() {
		$.ajax({
			type : "POST",
			url : "removerReservaServlet",
			data : {
				codigoReserva : $(this).val()
			},
			success : function() {
				location.reload();
			}
		});
		// Abrir modal para confirmar operação

	});

	$(".btn.edit").on("click", function() {
		$(this).hide();

	});
</script>




<!-- FOOTER -->
<%@include file='../footer.jsp'%>