public Morada getMoradaFromRestaurante(Restaurante restaurante) {
		System.out.println("RestauranteDAO -> Start getMoradaFromRestaurante");
		Morada morada = null;

		try {

			try (Statement stmt = connection.createStatement()) {
				String getMorada = "select * " + " from morada " + "where codigo=" + restaurante.getCodigoMorada()
						+ " and codigoArea=" + restaurante.getCodigoArea() + " and zonaArea="
						+ restaurante.getZonaArea() + ";";

				System.out.println("-> Instrução SQL: " + getMorada);
				ResultSet result = stmt.executeQuery(getMorada);

				while (result.next()) {
					morada = new Morada(result.getInt("codigo"), result.getInt("codigoPostal"),
							result.getInt("zonaPostal"), result.getString("designacao"));

				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return morada;
		}
	}

	public HashMap<Horario, Ementa> getEmentasEHorariosFromRestaurante(Restaurante restaurante) {

		System.out.println("RestauranteDAO -> Start getEmentasEHorariosFromRestaurante");
		HashMap<Horario, Ementa> ementas_horarios = new HashMap<>();

		try {

			try (Statement stmt = connection.createStatement()) {
				String getHorario = "select h.horaInicio, h.horaFim, h.diaSemana, h.idEmenta, e.designacao "
						+ "from horario as h" + " inner join ementa as e on h.idEmenta = e.id"
						+ "where h.codigoRestaurante=1 " + "order by diaSemana;";

				System.out.println("-> Instrução SQL: " + getHorario);
				ResultSet result = stmt.executeQuery(getHorario);

				Horario horario = null;
				Ementa ementa = null;

				while (result.next()) {
					horario = new Horario(new Date(result.getDate("horaInicio").getTime()),
							new Date(result.getDate("horaFim").getTime()), (DiaSemana) result.getObject("diaSemana"),
							result.getInt("idEmenta"), result.getInt("codigoRestaurante"));

					ementa = new Ementa(result.getInt("idEmenta"), restaurante.getCodigo(),
							result.getString("designacao"));

					ementas_horarios.put(horario, ementa);
				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return ementas_horarios;
		}

	}

	public Ementa getEmentasInTime(Restaurante restaurante, Date time) {
		System.out.println("RestauranteDAO -> Start getEmenta");
		Ementa ementa = null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);

		DiaSemana weekDay = DiaSemana.fromInt(calendar.get(Calendar.DAY_OF_WEEK));
		int hour = calendar.get(Calendar.HOUR);

		try {

			try (Statement stmt = connection.createStatement()) {
				String getEmenta = "select * from horario where diaSemana='" + weekDay + "' and horaInicio <= '" + hour
						+ "' and horaFim >= '" + hour + "' and codigoRestaurante=" + restaurante.getCodigo() + ";";

				System.out.println("-> Instrução SQL: " + getEmenta);
				ResultSet result = stmt.executeQuery(getEmenta);

				while (result.next()) {
					ementa = new Ementa(result.getInt("id"), restaurante.getCodigo(), result.getString("designacao"));
				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return ementa;
		}
	}

	public ArrayList<Item> getItensFromEmenta(Ementa ementa) {

		System.out.println("RestauranteDAO -> Start getEmentasEHorariosFromRestaurante");
		ArrayList<Item> itens = new ArrayList<>();

		try {

			try (Statement stmt = connection.createStatement()) {
				String getItem = "select * from item_ementa as ie" + "	inner join item as i on i.id = ie.idItem"
						+ "where ie.idEmenta=" + ementa.getId() + " and ie.codigoRestaurante="
						+ ementa.getCodigoRestaurante() + ";";

				System.out.println("-> Instrução SQL: " + getItem);
				ResultSet result = stmt.executeQuery(getItem);

				Item item = null;
				while (result.next()) {
					item = new Item(result.getInt("id"), result.getString("desginacao"), result.getString("descricao"),
							(TipoItem) result.getObject("tipo"), result.getInt("idRecurso"));

					itens.add(item);
				}
				System.out.println("Commited");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} finally {
			return itens;
		}

	}