package FinanceApplication;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {
	
	 @FXML
	    private TextField incomeField;

	    @FXML
	    private TextField expenseField;

	    @FXML
	    private Label resultLabel;
	    
    @FXML
    public void handleCalculateBudget() {
        try {
            double income = Double.parseDouble(incomeField.getText());
            double expenses = Double.parseDouble(expenseField.getText());
            double remainingBudget = income - expenses;
            resultLabel.setText(String.format("$%.2f", remainingBudget));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    @FXML
    public void handleClearFields() {
        incomeField.clear();
        expenseField.clear();
        resultLabel.setText("");
    }

    @FXML
    public void goToBudget() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Budget.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Manage Budget");
        stage.show();
    }

    @FXML
    public void goToIncome() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Income.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Manage Income");
        stage.show();
    }

    @FXML
    public void goToExpense() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Expense.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Manage Expenses");
        stage.show();
    }

    @FXML
    public void goToDictionary() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Dictionary.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Financial Dictionary");
        stage.show();
    }

    @FXML
    public void goToDashboard() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Dashboard");
        stage.show();
    }

}
