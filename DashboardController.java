package FinanceApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML
    private Label totalIncomeLabel;
    @FXML
    private Label totalExpensesLabel;
    @FXML
    private Label netBalanceLabel;

    private Budget budget;

    public void setBudget(Budget budget) {
        this.budget = budget;
        updateDashboard(); // Update dashboard initially with current budget values
    }

    public void updateDashboard() {
        if (budget != null) {
            totalIncomeLabel.setText("$" + budget.getTotalIncome());
            totalExpensesLabel.setText("$" + budget.getTotalExpenses());
            netBalanceLabel.setText("$" + budget.getNetBalance());
        }
    }
}
