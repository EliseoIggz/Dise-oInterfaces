package com.carballeira.aplicacion.view;

import com.carballeira.aplicacion.controller.FormularioController;
import com.carballeira.aplicacion.model.Usuario;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FormularioView extends Application {
	public static TextField nombreText = new TextField();
	public static TextField apellidosText = new TextField();
	public static TextField usuarioText = new TextField();
	public static PasswordField passwordText = new PasswordField();
	public static ToggleGroup estatusGroup = new ToggleGroup();
    public static TableView<Usuario> tableView = new TableView<>();

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			
			grid.setPadding(new Insets(10, 10, 10, 10));
	        grid.setHgap(10);
	        grid.setVgap(10);

	        Label nombreLabel = new Label("Nombre:*");

	        Label apellidosLabel = new Label("Apellidos:");

	        Label usuarioLabel = new Label("Usuario:*");

	        Label contrasenaLabel = new Label("Contraseña:*");

	        Label estatusLabel = new Label("Estatus:");

	        RadioButton activoRadio = new RadioButton("Activo");
	        activoRadio.setToggleGroup(estatusGroup);
	        RadioButton inactivoRadio = new RadioButton("Inactivo");
	        inactivoRadio.setToggleGroup(estatusGroup);

	        HBox estatusBox = new HBox(10, activoRadio, inactivoRadio);

	        Button addButton = new Button("Añadir Usuario");

	        grid.add(nombreLabel, 0, 0);
	        grid.add(nombreText, 1, 0);

	        grid.add(apellidosLabel, 2, 0);
	        grid.add(apellidosText, 3, 0);

	        grid.add(usuarioLabel, 0, 1);
	        grid.add(usuarioText, 1, 1);

	        grid.add(contrasenaLabel, 2, 1);
	        grid.add(passwordText, 3, 1);

	        grid.add(estatusLabel, 0, 2);
	        grid.add(estatusBox, 1, 2);

	        grid.add(addButton, 2, 2);

	        
	        TableColumn<Usuario, String> nombreColumn = new TableColumn<>("Nombre");
	        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));

	        TableColumn<Usuario, String> apellidosColumn = new TableColumn<>("Apellidos");
	        apellidosColumn.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

	        TableColumn<Usuario, String> usuarioColumn = new TableColumn<>("Usuario");
	        usuarioColumn.setCellValueFactory(new PropertyValueFactory<>("usuario"));

	        TableColumn<Usuario, Boolean> estatusColumn = new TableColumn<>("Estatus");
	        estatusColumn.setCellValueFactory(new PropertyValueFactory<>("estatus"));

	        tableView.getColumns().addAll(nombreColumn, apellidosColumn, usuarioColumn, estatusColumn);

	        grid.add(tableView, 0, 3, 4, 1);

	        addButton.setOnAction(event -> {
	            String nombre = nombreText.getText();
	            String apellidos = apellidosText.getText();
	            String usuario = usuarioText.getText();
	            String password = passwordText.getText();
	            RadioButton rbselected = (RadioButton)estatusGroup.getSelectedToggle();
	            String estatus = rbselected.getText(); 

	            Usuario nuevoUsuario = new Usuario(nombre, apellidos, usuario, password, estatus);

	            FormularioController formulario = new FormularioController(nuevoUsuario, this);
	            formulario.addDatosTabla(); 
	        });
			
			Scene scene = new Scene(grid,600,600);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void addTable(Usuario nuevoUsuario) {
		tableView.getItems().add(nuevoUsuario);
		
		nombreText.clear();
        apellidosText.clear();
        usuarioText.clear();
        passwordText.clear();
        estatusGroup.selectToggle(null);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
