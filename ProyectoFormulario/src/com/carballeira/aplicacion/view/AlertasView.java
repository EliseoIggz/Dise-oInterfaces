package com.carballeira.aplicacion.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertasView {

	public final String TITULO_INFORMATIVO="Mensaje informativo";
	public final String TITULO_CONFIRMACION="Mensaje de confirmacion";
	
	public Alert addAlertaInformacionView(String sms) {
		Alert alerta1 = new Alert(AlertType.INFORMATION);
		alerta1.setTitle(TITULO_INFORMATIVO);
		alerta1.setHeaderText(sms);
		//alerta1.setHeaderText(sms); //Subtitulado
		return alerta1;
	}
	
	public Alert addAlertaConfirmacionView(String sms) {
		Alert alerta1 = new Alert(AlertType.CONFIRMATION);
		alerta1.setTitle(TITULO_CONFIRMACION);
		alerta1.setHeaderText(sms);
		//alerta1.setHeaderText(sms); //Subtitulado
		return alerta1;
	}

}
