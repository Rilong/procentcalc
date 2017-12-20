package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class Controller {

    String ResultText;

    @FXML
    TextField number;

    @FXML
    TextField procent;

    @FXML
    RadioButton substract;

    @FXML
    RadioButton added;

    @FXML
    Label displayResult;


    @FXML
    public void initialize() {
        ResultText = displayResult.getText();
    }

    public void OnClickResult() {
        float num;
        float proc;
        float result;
        String resultStr;


        try {
            num = Float.parseFloat(number.getText());
            proc = Float.parseFloat(procent.getText());
        }catch (Exception e) {
            num = 0;
            proc = 0;
        }

        if(added.isSelected())
            result = added(num, proc);
        else
            result = substract(num, proc);

        resultStr = formating(result);

        if(num == 0 && proc == 0 && number.getText().isEmpty() && procent.getText().isEmpty())
            resultStr = "ERROR";

        displayResult.setText(ResultText + " " + resultStr);
    }

    public void onChangeText() {
        if(!number.getText().matches("\\d*")) {
            number.setText(number.getText().replaceAll("[^\\d]", ""));
            number.positionCaret(number.getText().length());
        }

        if(!procent.getText().matches("\\d*")) {
            procent.setText(procent.getText().replaceAll("[^\\d]", ""));
            procent.positionCaret(procent.getText().length());
        }
    }

    private float added(float num, float proc) {
        return num + ((proc / 100) * num);
    }

    private float substract(float num, float proc) {
        return num - ((proc / 100) * num);
    }

    private String formating(float result) {
        String resultStr = Float.toString(result);
        String formated;

        if(resultStr.endsWith(".0"))
            formated = resultStr.substring(0, resultStr.length() - 2);
        else
            formated = resultStr;

        return formated;
    }


}
