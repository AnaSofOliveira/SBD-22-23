<!-- HEADER -->
<%@include file='../header.jsp'%>

<!-- Informações da reserva -->
<div class="container mt-5">
	<h1 class="text-center mb-4">Personalize a sua reserva</h1>
	<form class='formReserva' action="./InformarReservaConcluida" method="GET">
		<div class="row">
			<div class="jumbotron col-12">
				<h2 class="text-center">Ementa</h2>
				<div class="row itensEmenta"></div>
			</div>

			<div class="col-12">
				<h2 class="text-center">Caracteristicas</h2>
				<div class="row m-4 caracteristicasEmenta"></div>
			</div>
		</div>
		<div class="hiddenResponse" style="display:None;">
			<input class ="codigoRestaurante" type="number" id='codigoRestaurante' name='codigoRestaurante' value='0'>
			<input class ="codigoReserva" type="number" id='codigoReserva' name='codigoReserva' value='0'>
			
			<!-- <input class ="data" type="text" id="data" name="data">
			<input class ="hora" type="text" id="hora" name="hora">
			<input class ="numeroPessoas" type="number" id='numeroPessoas' name='numeroPessoas'> -->
			
		</div>
		
		<div class="row text-center">
			<div class="col text-center">
				<button type="button" class="btn btn-success m-5 botaoReservar">Reservar</button>
			</div>
		</div>
	</form>
</div>
					

<!-- FOOTER -->
<%@include file='../footer.jsp'%>

<script>

$(document).ready(function(){

	$.ajax({
		type : "POST",
		url : "ListarItensEmenta",
		data : {
			codigoRestaurante : ${restaurante},
			dataHoraMarcacao: ${dataHoraMarcacao}
		}, 
		success : function(data){
			console.log("Data: " + data); 

			response = jQuery.parseJSON(JSON.stringify(data)); 

			console.log("response: " + response.recursos); 
			if(response.itens[0] != null){

				listaItens = "";
				var entradas = '<div class="col-6 mt-3"><div class="row ml-4"> <h3>Entradas: </h3></div>';
				var pratos = '<div class="col-6 mt-3"><div class="row ml-4"> <h3>Pratos: </h3></div>';
				var bebidas = '<div class="col-6 mt-3"><div class="row ml-4"> <h3>Bebidas: </h3></div>';
				var sobremesas = '<div class="col-6 mt-3"><div class="row ml-4"> <h3>Sobremesas: </h3></div>';

				var haEntradas = false; 
				var haPratos = false; 
				var haBebidas = false; 
				var haSobremesas = false; 
				
				for (let i = 0; i < response.itens.length; i++){

					var componente = '<div class="row ml-4"><div class="form-group col-12"><div class="row"><p>' + response.itens[i].designacao + '</p><input type="hidden" class="form-control" name="itens[]" min="0" value="' + response.itens[i].designacao + '"></div>' +
					'<div class="row"><div class="col-6"><img src="data:image/jpg;base64,' + response.recursos[i].imagemBase64 + '" alt="' + response.itens[i].designacao + '" width="100" height="100">' +
					'</div><div class="col-3"><div class="row"><label for="quantidade'+ response.itens[i].designacao + '""> Quantidade: </label>' +
					'</div><div class="col-2"></div><div class="row"><input type="number" class="form-control" id=' + response.itens[i].id + ' name="quantidades[]" min="0" value="0">' +
					'</div></div></div></div></div>'; 

					var tipo = response.itens[i].tipo;

					if(tipo == 'entrada'){
						haEntradas = true;
						entradas+=componente;
					}else if(tipo == 'prato'){
						haPratos = true; 
						pratos+=componente;
					}else if(tipo == 'bebida'){
						haBebidas = true;
						bebidas+=componente;
					}else if(tipo == 'sobremesa'){
						haSobremesas = true;
						sobremesas+=componente;
					}
				}

				if(haEntradas){
					listaItens+=entradas + "</div>"
				}if(haPratos){
					listaItens+=pratos + "</div>"
				}if(haBebidas){
					listaItens+=bebidas + "</div>"
				}if(haSobremesas){
					listaItens+=sobremesas + "</div>"
				}
				
			} else{
				table = "<div id='alert'> Não existe ementa disponível</div>"; 
			}
			
            $('.itensEmenta').html(listaItens);
			
		}
	});



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
				caracteristicas = "";


				for (let i = 0; i < response.caracteristicas.length; i++){

					caracteristicas += '<div class="form-check col-12"><input class="form-check-input" type="checkbox" id="' + response.caracteristicas[i].numero + '" name="caracteristicas[]"' + 
										'value="' + response.caracteristicas[i].caracteristica + '"> <label class="form-check-label" for="caracteristica1">' + response.caracteristicas[i].caracteristica + '</label></div>';

				}

			}else{

				table = "<div id='alert'> Não existem caracteristicas disponíveis</div>"; 
			}
            $('.caracteristicasEmenta').html(caracteristicas);
 
			} 
	});

	
}); 


$(".botaoReservar").on("click", function(){

	let codigoRestaurante = ${restaurante};
	let dataHoraMarcacao = ${dataHoraMarcacao}; 
	let pessoas = ${pessoas}; 

	let itensReservados = []; 
	let quantidadesReservadas = []; 

	let itens = $('input[name="quantidades[]"]');

	itens.each(function(){
		console.log($(this).val());
		if($(this).val() > 0){
			itensReservados.push($(this).attr("id")); 
			quantidadesReservadas.push($(this).val());
		}
	});


	let caracteristicas = $('input[name="caracteristicas[]"]');
	let caracteristicasReservadas = []; 

	caracteristicas.each(function(){
		if($(this).is(":checked")){
			caracteristicasReservadas.push($(this).attr("id")); 
		}
	});
		

	$.ajax({
		type: "POST", 
		url: "RealizarReservaServlet", 
		data: {
			codigoRestaurante : codigoRestaurante,
			numeroPessoas: pessoas, 
			dataHoraMarcacao: dataHoraMarcacao, 
			listaItens: itensReservados, 
			quantItens: quantidadesReservadas, 
			listaCaracteristicas: caracteristicasReservadas, 
			dataHoraReserva: new Date().getTime()		
		}, 
		success: function(data){

			console.log("Data" + data);

			response = jQuery.parseJSON(JSON.stringify(data)); 

			console.log("response: " + response);
			console.log("restaurante: " + response.restaurante.codigo);
			console.log("dataMarcacao: " + response.dataMarcacao);
			console.log("horaMarcacao: " + response.horaMarcacao);
			console.log("pessoas: " + response.pessoas); 

			$("#codigoRestaurante").val(response.restaurante.codigo);
			$("#codigoReserva").val(response.reserva.numero);
			/*$("#data").val(response.dataMarcacao);
			$("#hora").val(response.horaMarcacao);
			$("#numeroPessoas").val(response.pessoas);*/
			//$("#responseForm#pessoas").html(JSON.stringify(response.pessoas));
			//$("#responseForm#data").html(JSON.stringify(response.dataMarcacao));
			//$("#responseForm#hora").html(JSON.stringify(response.horaMarcacao));
			//$("#responseForm#itens").html(JSON.stringify(response.itens));
			//$("#responseForm#caracteristicas").html(JSON.stringify(response.caracteristicas));
			
			$('.formReserva').submit();

			/*var params = {"restaurante": response.restaurante, 
					"numeroPessoas": pessoas,
					"dataMarcacao": response.dataMarcacao,
					"horaMarcacao": response.horaMarcacao, 
					"caracterisiticas": response.caracteristicas, 
					"itens": response.itens};*/
			
			//faz submit do hidden form
			
			//window.location = "http://localhost:8080/the-spoon-project/frontend/sucesso_reserva.jsp"; // + $.param(params);
			console.log("Vou redirecionar para a página de sucesso"); 
		}, 
		error: function(){
			window.location.href = "./frontend/erro_reserva.jsp"	
			console.log("Vou redirecionar para a página de erro"); 
		}
	});

});


	
</script>