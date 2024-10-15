package FinanceApplication;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    private List<Income> incomes;
    private List<Expense> expenses;

    public Budget() {
        incomes = new ArrayList<>();
        expenses = new ArrayList<>();
    }

    public void addIncome(Income income) {
        incomes.add(income);
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public double getTotalIncome() {
        return incomes.stream().mapToDouble(Income::getAmount).sum();
    }

    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double getNetBalance() {
        return getTotalIncome() - getTotalExpenses();
    }
}
