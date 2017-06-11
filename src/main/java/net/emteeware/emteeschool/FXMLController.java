package net.emteeware.emteeschool;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *  The controller connecting the FXML based UI view with the model.
 */

public class FXMLController implements Initializable {

    /**
     *  The UI elements used in the FXML based GUI.
     */
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

    private List<CalculationTask> calculationTasks;
    private int resultLimit = 20;
    private final OperationsManager operationsManager = new OperationsManager();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        radioGroupResultLimit.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(radioGroupResultLimit.getSelectedToggle() instanceof RadioButton) {
                    String text = ((RadioButton) radioGroupResultLimit.getSelectedToggle()).getText();
                    switch (text) {
                        case "bis 20":
                            resultLimit = 20;
                            break;
                        case "bis 100":
                            resultLimit = 100;
                            break;
                        default:
                            resultLimit = 1000;
                            break;
                    }
                }
            }
        });
    }


    public void createNewTasks(ActionEvent actionEvent) {
        lblResult.setText("");
        clearInputs();
        calculationTasks = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            calculationTasks.add(new CalculationTask(resultLimit, operationsManager.getNextOperation()));
        }
        lblFirstTask.setText(calculationTasks.get(0).toString());
        lblSecondTask.setText(calculationTasks.get(1).toString());
        lblThirdTask.setText(calculationTasks.get(2).toString());
        lblFourthTask.setText(calculationTasks.get(3).toString());
        lblFifthTask.setText(calculationTasks.get(4).toString());
    }

    private void clearInputs() {
        txtFirstResult.clear();
        txtSecondResult.clear();
        txtThirdResult.clear();
        txtFourthResult.clear();
        txtFifthResult.clear();
    }

    public void checkResults(ActionEvent actionEvent) {
        if(txtFirstResult.getText().equals(Integer.toString(calculationTasks.get(0).getResult())) &&
                txtSecondResult.getText().equals(Integer.toString(calculationTasks.get(1).getResult())) &&
                txtThirdResult.getText().equals(Integer.toString(calculationTasks.get(2).getResult())) &&
                txtFourthResult.getText().equals(Integer.toString(calculationTasks.get(3).getResult())) &&
                txtFifthResult.getText().equals(Integer.toString(calculationTasks.get(4).getResult()))) {
            lblResult.setText("Sehr gut!");
        } else {
            lblResult.setText("Sieh noch mal nach!");
        }
    }

    public void toggleSubtraction(ActionEvent actionEvent) {
        if(btnMinus.isSelected()) {
            operationsManager.enable(Operation.SUBTRACTION);
        } else {
            operationsManager.disable(Operation.SUBTRACTION);
        }
    }

    public void toggleAddition(ActionEvent actionEvent) {
        if(btnPlus.isSelected()) {
            operationsManager.enable(Operation.ADDITION);
        } else {
            operationsManager.disable(Operation.ADDITION);
        }
    }

    public void toggleMultiplication(ActionEvent actionEvent) {
        if(btnMultiply.isSelected()) {
            operationsManager.enable(Operation.MULTIPLICATION);
        } else {
            operationsManager.disable(Operation.MULTIPLICATION);
        }
    }

    public void toggleDivision(ActionEvent actionEvent) {
        if(btnDivision.isSelected()) {
            operationsManager.enable(Operation.DIVISION);
        } else {
            operationsManager.disable(Operation.DIVISION);
        }
    }
}
