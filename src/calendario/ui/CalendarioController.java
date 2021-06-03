package calendario.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import calendario.repository.ICalendarioManager;
import common.ui.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import receta.repository.IRecetaManager;

public class CalendarioController {
	
	private ICalendarioManager manager;
    private HashMap<String, Label> labels = new HashMap<>();

    @FXML
    private Button botonVolver;

    @FXML
    private Label labelDia;

    @FXML
    private Label labelSemana;

    @FXML
    private DatePicker calendario;

    @FXML
    private Label labelError;

    @FXML
    private ListView<String> tareas;

    @FXML
    private TextField texto;

    @FXML
    private Button botAgregar;

    @FXML
    private Button botEditar;

    @FXML
    private Button botBorrar;

    @FXML
    void agregar(ActionEvent event) {

    }

    @FXML
    void borrar(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void verDia(ActionEvent event) {
    	String fecha = calendario.getValue().toString();
    	Vector<String> dias = new Vector<String>();
    	dias.add("Domingo");
    	dias.add("Lunes");
    	dias.add("Martes");
    	dias.add("Miercoles");
    	dias.add("Jueves");
    	dias.add("Viernes");
    	dias.add("Sabado");
    	
    	try {
    		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha); 
    		labelDia.setText(String.valueOf(date.getDate()));
        	labelSemana.setText(dias.get(date.getDay()));
    	}catch(Exception e) {
    		System.out.println("Error");
    	}
    }

    @FXML
    void volver(ActionEvent event) {

    	texto.setText("");
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(Scenes.getData().getSceneAgenda());
    }
    
    public void setManager(ICalendarioManager manager) {
        this.manager = manager;
    }

}
