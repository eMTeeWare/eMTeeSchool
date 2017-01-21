package net.emteeware;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class FXMLController implements Initializable {


    public ToggleButton btnPlus;
    public ToggleButton btnMinus;
    public ToggleButton btnMultiply;
    public ToggleButton btnDivision;
    public RadioButton radioTwenty;
    public RadioButton radioHundred;
    public RadioButton radioThousand;
    public Label lblFirstTask;
    public TextField txtFirstResult;
    public TextField txtSecondResult;
    public Label lblSecondTask;
    public Label lblThirdTask;
    public TextField txtThirdResult;
    public Label lblFourthTask;
    public TextField txtFourthResult;
    public Label lblFifthTask;
    public TextField txtFifthResult;
    public Button btnCheckResults;
    public Label lblResult;
    public Button btnNewTasks;
    public ToggleGroup radioGroupResultLimit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
