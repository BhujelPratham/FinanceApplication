package FinanceApplication;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class IncomeController {
    @FXML
    private TextField sourceField, amountField;
    @FXML
    private ListView<String> incomeList;

    private Budget budget = new Budget();

    @FXML
    public void handleAddIncome() {
        String source = sourceField.getText();
        double amount = Double.parseDouble(amountField.getText());

        Income income = new Income(source, amount);
        budget.addIncome(income);

        incomeList.getItems().add("Source: " + source + ", Amount: $" + amount);
        updateBudgetSummary();

        sourceField.clear();
        amountField.clear();
    }

    private void updateBudgetSummary() {
        // Optionally update budget summary (like total income) here
    	double totalIncome = budget.getTotalIncome();
    }
}
