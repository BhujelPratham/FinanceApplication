package FinanceApplication;

import java.util.HashMap;
import java.util.Map;

public class FinancialDictionary {
    private Map<String, String> terms;

    public FinancialDictionary() {
        terms = new HashMap<>();
        terms.put("Budget", "A plan for managing your income and expenses.");
        terms.put("Income", "Money received from various sources such as salary or allowance.");
        terms.put("Expense", "Money spent on various things, such as tuition and supplies.");
        terms.put("Savings", "The portion of income not spent and kept for future use.");
        terms.put("Investment", "Using money to earn a return, such as buying stocks or bonds.");
        terms.put("Debt", "Money owed to someone else, such as student loans or credit card balances.");
    }

    public String getDefinition(String term) {
        return terms.getOrDefault(term, "Term not found");
    }
}
