package com.universidadeuropea.dao;

import java.sql.ResultSet;
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
	protected TipoUsuario mapear(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
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
