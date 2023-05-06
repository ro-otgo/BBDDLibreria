package com.universidadeuropea.entities;

public class Escritor {

	private long id_autor;
	
	private long id_libro;

	public long getId_autor() {
		return id_autor;
	}

	public void setId_autor(long id_autor) {
		this.id_autor = id_autor;
	}

	public long getId_libro() {
		return id_libro;
	}

	public void setId_libro(long id_libro) {
		this.id_libro = id_libro;
	}

	@Override
	public String toString() {
		return "Escritor [id_autor=" + id_autor + ", id_libro=" + id_libro + "]";
	}
	
}
