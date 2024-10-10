module proyectoFormulario {
	requires javafx.controls;
	requires javafx.graphics;

	opens com.carballeira.aplicacion.view to javafx.controls, javafx.graphics, javafx.fxml;
    opens com.carballeira.aplicacion.model to javafx.base;
 }