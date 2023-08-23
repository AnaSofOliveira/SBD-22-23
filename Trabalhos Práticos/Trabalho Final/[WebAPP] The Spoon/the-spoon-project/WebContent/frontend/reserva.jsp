<!-- HEADER -->
<%@include file='../header.jsp'%>
<!-- Informações da reserva -->
<div class="container-fluid">
	<form id='reserva'>
		<!-- action='./RealizarReservaServlet' method='POST' -->
		<input type='hidden' id="codigoRestaurante" name="codigoRestaurante"
			value='${restaurante }'>

		<div class="form-group row">
			<div class="col-2">
				<div class='mb-4'>
					<p>Data/Hora da Reserva:</p>
				</div>
				<div class='mb-4'>
					<p>Número de Pessoas:</p>
				</div>
			</div>

			<div class="col-2">
				<div class='mb-4'>
					<input type="datetime-local" id="dataHoraMarcacao"
						name="dataHoraMarcacao">
				</div>
				<div class='mb-4'>
					<input type="number" id="numeroPessoas" name="numeroPessoas"
						value="0">
				</div>

			</div>
		</div>
		<div class="form-group row">
			<div class="col-2">
				<div class="form-check">
					<input type="checkbox" class="form-check-input"
						id="escolherItensEmenta" name="escolherItensEmenta"> <label
						class="form-check-label" for="escolherItensEmenta">Ver
						Ementa</label>
				</div>
			</div>

			<div class="col-8">
				<div id='listaItens'></div>
			</div>
		</div>
		<fieldset class="form-group row">
			<div class='col-2'>
				<div class="form-check">
					<input type="checkbox" class="form-check-input"
						id="escolherCaracteristicas" name="escolherCaracteristicas">
					<label class="form-check-label" for="escolherCaracteristicas">Escolher
						Caracteristicas</label>
				</div>

			</div>
			<div class="col-3">
				<div id="listaCaracteristicas"></div>
			</div>
		</fieldset>
		<button type="button" class="btn btn-success botaoReservar">Reservar</button>
	</form>
</div>

<!-- FOOTER -->
<%@include file='../footer.jsp'%>

<script>

$(document).ready(function(){
	$("#listaItens").hide(); 
	$("#listaCaracteristicas").hide();
}); 


$(".botaoReservar").on("click", function(){

	
	console.log("Entrei aqui!");

	let codigoRestaurante = $('#codigoRestaurante').val();
	let numeroPessoas = $("#numeroPessoas").val(); 
	let dataHoraMarcacao = $("#dataHoraMarcacao").val(); 

	let escolherItensEmenta = $("#escolherItensEmenta").val(); 
	let itensReservados = []; 
	let quantidadesReservadas = []; 

	$('#itemEmenta input[type="hidden"]').each(function(){
		itensReservados.push($(this).attr("value"));
	});

	$('.quantItem').each(function(){
		console.log($(this).attr("value")); 
		quantidadesReservadas.push($(this).val());
	});

	 
	let escolherCaracteristicas = $("#escolherCaracteristicas").val(); 
	let caracteriticasReservadas = []; 

	$('#idCaracteristica').each(function(){
		console.log($(this));
		caracteriticasReservadas.push($(this).val()); 
	});
	

	$.ajax({
		type: "POST", 
		url: "RealizarReservaServlet", 
		data: {
			codigoRestaurante : codigoRestaurante,
			numeroPessoas: numeroPessoas, 
			dataHoraMarcacao: new Date(dataHoraMarcacao).toISOString(), 
			escolherItensEmenta: escolherItensEmenta, 
			listaItens: itensReservados, 
			quantItens: quantidadesReservadas, 
			escolherCaracteristicas: escolherCaracteristicas, 
			listaCaracteristicas: caracteriticasReservadas, 
			dataHoraReserva: new Date().toISOString()		
		}, 
		complete: function(){
			window.location.href = "./frontend/sucesso_reserva.jsp"	
			console.log("Vou redirecionar para a página de sucesso"); 
		}, 
		error: function(){
			window.location.href = "./frontend/erro_reserva.jsp"	
			console.log("Vou redirecionar para a página de erro"); 
		}
	});

});

$("#escolherItensEmenta").change(function() {
	let date = $("#dataHoraMarcacao").val(); 
	
	if (this.checked) {

		if(date!=""){
			$.ajax({
				type : "POST",
				url : "ListarItensEmenta",
				data : {
					codigoRestaurante : ${restaurante},
					dataReserva: new Date(date).toISOString()
				}, 
				success : function(data){
					console.log("Data: " + data); 
	
					response = jQuery.parseJSON(JSON.stringify(data)); 
	
					console.log("response: " + response.recursos); 
					if(response.itens[0] != null){
						tableHeader = "<table class='table table-hover'>";
		
						tableEnd = "</table>";
		
						tableBody = ""; 
		
						for (let i = 0; i < response.itens.length; i++){
							tableBody += "<tr id='itemEmenta'><input type='hidden' class='form-check-input' name='idItem' value="
								+ response.itens[i].id + "></input>" + 
											"<td class='col-2 text-center'><img src='data:image/jpg;base64," + response.recursos[i].imagemBase64 + "' alt='Item image' width='100px' height='100px'></td>" + 
											"<td class='col-6 text-center'>" + response.itens[i].designacao + "</td>" + "<td class='col-2 text-right' id='quantItem'><input type='number' class='form-check-input quantItem' style='width: 50px; position:relative' value='0'></input></td></tr>"; 
						}
		
						table = tableHeader + tableBody + tableEnd; 
					} else{
						table = "<div id='alert'> Não existe ementa disponível</div>"; 
					}
					
		            $('#listaItens').html(table);
					$("#listaItens").toggle(1000); 
					
				}
			});
		}else{
			table = "<div id='alert'> Não existe ementa disponível</div>"; 
	        $('#listaItens').html(table);
	    	
			$("#listaItens").toggle(1000); 
		}
	}else{
		$("#listaItens").hide(); 
	}
});



$("#escolherCaracteristicas").change(function() {

	if (this.checked) {

		$.ajax({
			type : "POST",
			url : "ListarCaracteristicas",
			data : {
				codigoRestaurante : ${restaurante}
			}, 
			success : function(data){
				console.log("Data: " + data); 

				response = jQuery.parseJSON(JSON.stringify(data)); 

				console.log("response: " + response.caracteristicas); 

				if(response.caracteristicas != null){
					tableHeader = "<table class='table table-hover' id='caracteristicasReservadas'><tr>" + 
									"<th scope='col-1 text-center'>#</th>" + 
									"<th scope='col-4 '>Caracteristica</th></tr>";
	
					tableEnd = "</table>";
	
					tableBody = ""; 
	
					for (let i = 0; i < response.caracteristicas.length; i++){
						tableBody += "<tr id='caracteristica'><td class='col-1 text-center'><input type='checkbox' class='form-check-input' id='idCaracteristica' style='position:relative' value=" + 
						response.caracteristicas[i].numero + "></input></td>" + 
						"<td class='col-4'>" + response.caracteristicas[i].caracteristica + "</td></tr>";
					}
	
					table = tableHeader + tableBody + tableEnd; 
				}else{

					table = "<div id='alert'> Não existem caracteristicas disponíveis</div>"; 
				}
	            $('#listaCaracteristicas').html(table);

				$("#listaCaracteristicas").toggle(1000); 
				} 
		});
	}else{
		$("#listaCaracteristicas").hide(); 
	}
});

	

	
</script>