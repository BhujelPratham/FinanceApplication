package FinanceApplication;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ExpenseController {
    @FXML
    private TextField categoryField, expenseAmountField;
    @FXML
    private ListView<String> expenseList;

    private Budget budget = new Budget();

    @FXML
    public void handleAddExpense() {
        String category = categoryField.getText();
        double amount = Double.parseDouble(expenseAmountField.getText());

        Expense expense = new Expense(category, amount);
        budget.addExpense(expense);

        expenseList.getItems().add("Category: " + category + ", Amount: $" + amount);
        updateBudgetSummary();

        categoryField.clear();
        expenseAmountField.clear();
    }

    private void updateBudgetSummary() {
        // Optionally update budget summary (like total expenses) here
    	double totalIncome = budget.getTotalIncome();
    }
}
