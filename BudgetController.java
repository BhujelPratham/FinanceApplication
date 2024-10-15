package FinanceApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class BudgetController {
    @FXML
    private Label totalIncomeLabel;
    @FXML
    private Label totalExpensesLabel;
    @FXML
    private Label netBalanceLabel;

    @FXML
    private TextField incomeSourceField;
    @FXML
    private TextField incomeAmountField;

    @FXML
    private TextField expenseCategoryField;
    @FXML
    private TextField expenseAmountField;

    @FXML
    private ListView<String> incomeList;
    @FXML
    private ListView<String> expenseList;

    private Budget budget;
    private DashboardController dashboardController; // Reference to the DashboardController

    public void setBudget(Budget budget) {
        this.budget = budget;
        updateDashboard();
    }

    public void setDashboardController(DashboardController dashboardController) {
        this.dashboardController = dashboardController; // Set the reference to the DashboardController
    }

    private void updateDashboard() {
        totalIncomeLabel.setText("$" + budget.getTotalIncome());
        totalExpensesLabel.setText("$" + budget.getTotalExpenses());
        netBalanceLabel.setText("$" + budget.getNetBalance());

        // Update the dashboard view
        if (dashboardController != null) {
            dashboardController.updateDashboard();
        }
    }

    @FXML
    public void handleAddIncome() {
        if (budget == null) {
            showAlert("Error", "Budget is not initialized.");
            return;
        }

        String source = incomeSourceField.getText();
        String amountText = incomeAmountField.getText();

        if (source.isEmpty() || amountText.isEmpty()) {
            showAlert("Error", "Please fill in both the income source and amount.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            Income income = new Income(source, amount);
            budget.addIncome(income);
            incomeList.getItems().add("Source: " + source + ", Amount: $" + amount);

            incomeSourceField.clear();
            incomeAmountField.clear();

            updateDashboard();
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid number for the amount.");
        }
    }

    @FXML
    public void handleAddExpense() {
        if (budget == null) {
            showAlert("Error", "Budget is not initialized.");
            return;
        }

        String category = expenseCategoryField.getText();
        String amountText = expenseAmountField.getText();

        if (category.isEmpty() || amountText.isEmpty()) {
            showAlert("Error", "Please fill in both the expense category and amount.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountText);

            Expense expense = new Expense(category, amount);
            budget.addExpense(expense);
            expenseList.getItems().add("Category: " + category + ", Amount: $" + amount);

            expenseCategoryField.clear();
            expenseAmountField.clear();

            updateDashboard();
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid number for the amount.");
        }
    }

    private void showAlert(String title, String message) {
        // JavaFX Alert implementation
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
