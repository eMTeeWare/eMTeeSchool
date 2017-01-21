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

    }

    public void createNewTasks(ActionEvent actionEvent) {
        lblResult.setText("");
        clearInputs();
        lblFirstTask.setText("4 + 7 =");
        lblSecondTask.setText("12 + 7 =");
        lblThirdTask.setText("2 + 9 =");
        lblFourthTask.setText("11 + 3 =");
        lblFifthTask.setText("6 + 13 =");
    }

    private void clearInputs() {
        txtFirstResult.clear();
        txtSecondResult.clear();
        txtThirdResult.clear();
        txtFourthResult.clear();
        txtFifthResult.clear();
    }

    public void checkResults(ActionEvent actionEvent) {
        if(txtFirstResult.getText().equals("11") &&
                txtSecondResult.getText().equals("19") &&
                txtThirdResult.getText().equals("11") &&
                txtFourthResult.getText().equals("14") &&
                txtFifthResult.getText().equals("19")) {
            lblResult.setText("Sehr gut!");
        } else {
            lblResult.setText("Sieh noch mal nach!");
        }
    }
}
