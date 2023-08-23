<!-- HEADER -->
<%@include file='../header.jsp'%>

<!-- Mensagem de sucesso com informações da reserva -->
<!-- TODO: Mensagem de sucesso com informações da reserva -->
<!--  Adicionar informações dinamicas consoante a reserva -->
<div class="container mt-5">
    <div class="jumbotron success text-center">
      <h1 class="display-4">Reserva Confirmada!</h1>
      <p class="lead">Sua reserva no restaurante XYZ foi confirmada com sucesso.</p>
    </div>
    <div class="row">
      <div class="col-md-6">
        <h2>Detalhes da Reserva</h2>
        <p><strong>Restaurante:</strong> Restaurante XYZ</p>
        <p><strong>Número de Pessoas:</strong> 4 pessoas</p>
        <p><strong>Data e Hora:</strong> 2023-08-25, 19:00</p>
        <h3>Itens Reservados</h3>
        <ul>
          <li>Prato 1 - Quantidade: 2</li>
          <li>Prato 2 - Quantidade: 3</li>
          <li>Bebida 1 - Quantidade: 4</li>
        </ul>
      </div>
      <div class="col-md-6">
        <h2>Mesas Selecionadas</h2>
        <p><strong>Mesa 1:</strong> Janela, Capacidade: 6 pessoas</p>
        <p><strong>Mesa 2:</strong> Canto, Capacidade: 4 pessoas</p>
      </div>
    </div>
  </div>
  

  
  <!-- Página para reserva -->
  
  <div class="container mt-5">
    <div class="row">
      <div class="col-md-6">
        <h1>Restaurante XYZ</h1>
        <p>Morada: Rua A, 123</p>
        <p>Contacto: 123 456 789</p>
        <p>Horário de Funcionamento:</p>
        <ul>
          <li>Segunda a Sexta: 11:00 - 22:00</li>
          <li>Sábado e Domingo: 12:00 - 23:00</li>
        </ul>
        <button class="btn btn-primary" data-toggle="modal" data-target="#reservaModal">Fazer Reserva</button>
      </div>
    </div>
  </div>

  <!-- Modal de Reserva -->
  <div class="modal fade" id="reservaModal" tabindex="-1" role="dialog" aria-labelledby="reservaModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="reservaModalLabel">Fazer Reserva</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <!-- Formulário de reserva -->
          <form id="formularioReserva">
            <div class="form-group">
              <label for="nome">Nome:</label>
              <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <div class="form-group">
              <label for="data">Data:</label>
              <input type="date" class="form-control" id="data" name="data" required>
            </div>
            <div class="form-group">
              <label for="hora">Hora:</label>
              <input type="time" class="form-control" id="hora" name="hora" required>
            </div>
            <div class="form-group">
              <label for="numeroPessoas">Número de Pessoas:</label>
              <input type="number" class="form-control" id="numeroPessoas" name="numeroPessoas" required>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
          <button type="submit" form="formularioReserva" class="btn btn-primary">Reservar</button>
        </div>
      </div>
    </div>
  </div>
  

<!-- FOOTER -->
<%@include file='../footer.jsp'%>