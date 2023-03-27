<!-- HEADER -->
<%@include file='../header.jsp'%>

<!-- LogIn Form -->



<div class="d-flex justify-content-center align-middle"
	stype='height=100vh'>

	<form action="./iniciarSessaoServlet" method="post">
		<div class="row mb-6">
			<div class="col">
				<img class="mb-4"
					src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg"
					alt="" width="72" height="72">
					<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			</div>

		</div>
		<div class="row mb-6">
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
		<div class="row">

			<label for="nif" class="sr-only">Número de Contribuinte</label> <input
				type="text" name="nif" id="nif" class="form-control" placeholder="NIF"
				required="" autofocus="">
		</div>



		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<!-- FOOTER -->
<%@include file='../footer.jsp'%>




