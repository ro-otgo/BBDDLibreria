package com.universidadeuropea.test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.universidadeuropea.dao.ReservaDao;
import com.universidadeuropea.entities.Reserva;

/**
 * Clase para probar el mapeo de datetime a localdateTime
 * @author Rodrigo
 *
 */
public class TestReserva {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dbURL = "jdbc:sqlite:src/test/resources/libros_test_reserva.db";
		
//		almacenarReserva(dbURL);
		recuperarReserva(dbURL);

	}

	private static void recuperarReserva(String dbURL) {
		ReservaDao reservaDao = new ReservaDao();
		reservaDao.setDBUrl(dbURL);
		
		try {
			List<Reserva> all = reservaDao.getAll();
			for(Reserva r: all) {
				System.out.println(r);
				System.out.println("Fecha devolucion " + r.getFechaDevolucion());
				System.out.println("Fecha reserva" + r.getFechaReserva());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
	}
	
	private static void almacenarReserva(String dbURL) {
		ReservaDao reservaDao = new ReservaDao();
		reservaDao.setDBUrl(dbURL);
		
		Reserva reserva = new Reserva();
		reserva.setIdLibro(1L);
		reserva.setIdUsuario(1L);
		reserva.setTipoReserva(1L);
		reserva.setFechaDevolucion(LocalDateTime.now());
		reserva.setFechaReserva(LocalDateTime.now());
		try {
			reservaDao.save(reserva);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
