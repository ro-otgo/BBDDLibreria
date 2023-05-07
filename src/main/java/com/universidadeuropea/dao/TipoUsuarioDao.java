package com.universidadeuropea.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.universidadeuropea.entities.TipoUsuario;

public class TipoUsuarioDao extends Dao<TipoUsuario, Long> implements ITipoUsuarioDao {

	@Override
	protected String selectById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String deleteById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected String getAllQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected TipoUsuario mapear(ResultSet rs) throws SQLException {
		TipoUsuario tipoUsuario = new TipoUsuario();
		while(rs.next()) {
			tipoUsuario.setId(rs.getLong("id"));
			tipoUsuario.setRol(rs.getString("rol"));
			tipoUsuario.setDescripcion(rs.getString("descripcion"));
		}
		return tipoUsuario;
	}

	
	/*-
	 * =========================================================
	 * Intefaz 
	 * ========================================================= 
	 */
	
	@Override
	public TipoUsuario save(TipoUsuario objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(TipoUsuario objeto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TipoUsuario update(TipoUsuario objeto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
