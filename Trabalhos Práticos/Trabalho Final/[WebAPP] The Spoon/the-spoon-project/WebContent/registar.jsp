<!-- HEADER -->
<%@include file='../header.jsp'%>

<div class="col-12 d-flex justify-content-center align-middle">

	<form action="./registerServlet" method='POST'>
		<div class="row">
			<div class="col-5">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="tipo"
						id="logAsCliente" value="cliente" checked> <label
						class="form-check-label" for="logAsCliente"> Cliente </label>
				</div>

			</div>
			<div class="col-5">
				<div class="form-check">
					<input class="form-check-input" type="radio" name="tipo"
						id="logAsFuncionario" value="funcionario"> <label
						class="form-check-label" for="logAsFuncionario">
						Funcionario </label>
				</div>
			</div>
		</div>

		<div class="row" id="registarCliente">

			<div class="form-group">
				<label for="nif">Número de Contribuinte (NIF):</label> <input
					name="nif" type="text" class="form-control" id="nif"
					placeholder="Insira o seu número de contribuinte">
					
					<label for="nome">Nome:</label> <input
					name="nome" type="text" class="form-control" id="nome"
					placeholder="Insira o seu primeiro Nome">
					
					<label for="apelido">Apelido:</label> <input
					name="apelido" type="text" class="form-control" id="apelido"
					placeholder="Insira o seu primeiro Apelido">
					
					<label for="idade">Apelido:</label> <input
					name="idade" type="text" class="form-control" id="idade"
					placeholder="Insira a sua idade">
					
					<label for="morada">Morada:</label> <input
					name="morada" type="text" class="form-control" id="morada"
					placeholder="Insira a sua idade">
			</div>
		</div>

		<%-- <div class="row" id="registarFuncionario">
				<div class="form-check">
					<input class="form-check-input" type="text" name="nif" id="nif">
					<label class="form-check-label" for="nif"> Número de Contribuinte </label>
			
					<input class="form-check-input" type="text" name="nome" id="nome">
					<label class="form-check-label" for="nome"> Nome </label>
					
					<input class="form-check-input" type="text" name="apelido" id="apelido">
					<label class="form-check-label" for="apelido"> Apelido </label>
					
					<label for="restaurantes">Restaurante</label>
					<select id="restaurante" name="restaurante">
						<c:forEach var="restaurante" items="${restaurantes}">
							<option value="${restaurantes.nome}">${restaurantes.nome}</option>
						</c:forEach>
					</select>
				</div>
		</div> --%>

		<button type="registar" class="btn btn-primary">Registar</button>
	</form>

</div>

<!-- FOOTER -->
<%@include file='../footer.jsp'%>
