<!-- HEADER -->
<%@include file='../header.jsp'%>

<!-- Info restaurante -->

<div class="container-fluid">

	<div class="row">
		<div class="col-5" id="restaurantePhoto">
			<img src="data:image/jpg;base64,${recurso.imagemBase64}" height="300"
				alt="imagemRestaurante" />
		</div>


		<div class="col-5" id="restauranteInfos">
			<p>
				<b>Restaurante: </b> ${restaurante.nome}
			</p>
			<p>
				<b>Contacto: </b> ${restaurante.telefone}
			</p>
			<p>
				<b>Mail: </b> ${restaurante.email}
			</p>
		</div>
	</div>
</div>


<!-- Info restaurante -->
<div class="container-fluid">
	<p>
		<b>LISTAR OPÇÕES</b>
	</p>
</div>


<!-- FOOTER -->
<%@include file='../footer.jsp'%>