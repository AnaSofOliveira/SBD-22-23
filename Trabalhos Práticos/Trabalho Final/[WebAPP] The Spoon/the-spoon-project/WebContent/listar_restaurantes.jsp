
<!-- HEADER -->
<%@include file='../header.jsp'%>


<div class="container-fluid">
	<div class="row justify-content-md-center">
		<c:forEach var="restaurante" items="${restaurantes}" varStatus="loop">

			<div class="card" style="width: 18rem; margin: 25px">
				<a href="./RestauranteInfoServlet?codigo=${restaurante.codigo}">
					<img class="card-img-top"
					src="data:image/jpg;base64,${recursos[loop.index].imagemBase64}"
					alt="Restaurante Card image" width="200px" height="200px">
				</a>

				<div class="card-body">
					<p class="card-text">
						<b>${restaurante.nome}</b>
					</p>
					<p class="card-text">${restaurante.email}</p>
					<p class="card-text">Contato: ${restaurante.telefone}</p>
				</div>
			</div>
		</c:forEach>
	</div>
</div>


<!-- FOOTER -->
<%@include file='../footer.jsp'%>
