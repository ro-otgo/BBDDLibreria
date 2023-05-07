package com.universidadeuropea.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class Dao<T, K> implements IDao<T, K> {


	/**
	 * Metodo que permite mapear un result set a un objeto Java
	 * 
	 * @param rs Resultado de la query
	 * @return Objeto Java
	 */
	protected abstract T mapear(ResultSet rs);

	/**
	 * Query que permite obtener todos los registros de una tabla
	 * 
	 * @return
	 */
	protected abstract String getAllQuery();

	/**
	 * Query que permite obtener todos los registros de una tabla por el id
	 * 
	 * @return
	 */
	protected abstract String selectById();

	/*- 
	 * ========================================================= 
	 * Implementaciones
	 * =========================================================
	 */

	@Override
	public List<T> getAll() {
		List<T> data = new ArrayList<>();
		try {
			obtenerConexionDB();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(getAllQuery());
			while (rs.next()) {
				data.add(mapear(rs));
			}
			cerrarConexion();
		} catch (SQLException e) {
			cerrarConexion();
		}
		return data;
	}

	@Override
	public T getById(K id) throws Exception {
		try {
			T data = null;
			obtenerConexionDB();
			PreparedStatement ps = connection.prepareStatement(selectById());
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				data = mapear(rs);
			}
			return data;
		} finally {
			cerrarConexion();
		}
	}

	@Override
	public boolean deleteById(K id) throws Exception {
		try {
			obtenerConexionDB();
			PreparedStatement ps = connection.prepareStatement(deleteById());
			ps.setObject(1, id);
			boolean execute = ps.execute();
			return execute;
		} finally {
			cerrarConexion();
		}
	}

	/*-
	 * ========================================================= 
	 * Constructores
	 * =========================================================
	 */

	protected abstract String deleteById();

	protected Dao() {

	}

	/*-
	 * ========================================================= 
	 * Protected
	 * =========================================================
	 */
	
	protected String getDBUrl() {
		return null;
	}

	protected void obtenerConexionDB() {
		try {
			System.out.println("Conectando a la base de datos ...");
			connection = DriverManager.getConnection(getDBUrl());
			System.out.println("Conectado a la base de datos.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void cerrarConexion() {
		if (connection != null) {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				errorHandler(e);
			}
		}
	}

	protected void errorHandler(Exception e) {
		System.out.println("Se ha producido una exceccion");
		e.printStackTrace();
	}

	/*-
	 * ========================================================= 
	 * Privados
	 * =========================================================
	 */

	private Connection connection;

	protected Connection getConnection() {
		return connection;
	}

	protected void setConnection(Connection connection) {
		this.connection = connection;
	}

}