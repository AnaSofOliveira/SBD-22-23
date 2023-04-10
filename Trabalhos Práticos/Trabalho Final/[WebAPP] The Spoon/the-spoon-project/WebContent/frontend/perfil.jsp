
<!-- HEADER -->
<%@include file='../header.jsp'%>


<c:if test="${user != null}">
	<div class="container-fluid">
		<div class="row justify-content-center align-middle">
			<h2>Perfil</h2>
		</div>

		<form action="./UpdateUserProfileServlet" method="post">

			<c:if test="${sucesso == true}">
				<div class="row justify-content-center align-middle"
					id="mensagemSucesso">
					<p>Perfil atualizado</p>
				</div>
			</c:if>
			<c:if test="${sucesso == false}">
				<div class="row justify-content-center align-middle"
					id="mensagemErro">
					<p>Erro ao atualizar o perfil</p>
				</div>
			</c:if>

			<div class="row justify-content-center align-middle">
				<div class="form-group">
					<label for="nif">Número de Contribuinte</label> <input name="nif"
						type="text" class="form-control" id="nif" value="${user.nif}">
				</div>
			</div>
			<div class="row justify-content-center align-middle">
				<div class="form-group">
					<label for="nomeProprio">Nome Proprio</label> <input
						name="nomeProprio" type="text" class="form-control"
						id="nomeProprio" value='${user.nomeProprio}'>
				</div>
			</div>
			<div class="row justify-content-center align-middle">
				<div class="form-group">
					<label for="apelido">Apelido</label> <input name="apelido"
						type="text" class="form-control" id="apelido"
						value="${user.apelido}">
				</div>
			</div>
			<div class="row justify-content-center align-middle">
				<div class="form-group">
					<label for="idade">Idade</label> <input name="idade" type="text"
						class="form-control" id="idade" value="${user.idade}">
				</div>
			</div>
			<div class="row justify-content-center align-middle">
				<div class="form-group">
					<label for="morada">Morada</label> <input name="morada" type="text"
						class="form-control" id="morada" value="${morada.designacao}">
				</div>
			</div>
			<div class="row justify-content-center align-middle">
				<div class="form-group">
					<label for="codigoPostal">Codigo Postal</label>
					<div class="col">
						<input name="codigoPostal" type="number" class="form-control"
							id="codigoPostal" value="${morada.codigoPostal}">
					</div>
					<div class="col">
						<input name="areaPostal" type="number" class="form-control"
							id="areaPostal" value="${morada.areaPostal}">
					</div>

				</div>
			</div>
			<div class="row justify-content-center align-middle">
				<button type="submit" class="btn btn-primary">Guardar
					Perfil</button>
			</div>
		</form>
	</div>

</c:if>

<c:if test="${user == null}">


</c:if>

<!-- FOOTER -->
<%@include file='../footer.jsp'%>
