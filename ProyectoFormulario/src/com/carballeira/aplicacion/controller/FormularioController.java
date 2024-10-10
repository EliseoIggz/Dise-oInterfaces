package com.carballeira.aplicacion.controller;

import com.carballeira.aplicacion.model.Usuario;
import com.carballeira.aplicacion.view.FormularioView;

public class FormularioController {
	private Usuario modelo;
	private FormularioView vista;
	
	public FormularioController(Usuario modelo, FormularioView vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}
	
	public void addDatosTabla(){
		vista.addTable(modelo);
	}
}
