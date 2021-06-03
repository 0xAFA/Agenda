package calendario.ui;

import java.util.HashMap;

import calendario.repository.ICalendarioManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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

    }

    @FXML
    void volver(ActionEvent event) {

    }
    
    public void setManager(ICalendarioManager manager) {
        this.manager = manager;
    }

}
