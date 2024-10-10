package com.carballeira.aplicacion.controller;

import com.carballeira.aplicacion.view.AlertasView;

import javafx.scene.control.Alert;

public class AlertasController {

	public void showAlertaInformativaClick(String sms) {
		Alert alerta1 = new AlertasView().addAlertaInformacionView(sms);
		alerta1.showAndWait();
	}
	
	public void showAlertaConfirmacionClick(String sms) {
		Alert alerta1 = new AlertasView().addAlertaConfirmacionView(sms);
		alerta1.showAndWait();
	}
}
