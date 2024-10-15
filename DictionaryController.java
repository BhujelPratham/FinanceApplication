package FinanceApplication;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DictionaryController {
    @FXML
    private TextField termField;
    @FXML
    private Label definitionLabel;

    private FinancialDictionary dictionary = new FinancialDictionary();

    @FXML
    public void searchTerm() {
        String term = termField.getText().trim();
        String definition = dictionary.getDefinition(term);
        definitionLabel.setText(definition);
    }
}
