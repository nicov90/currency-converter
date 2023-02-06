package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.NumberOnlyDocument;

public class FieldView {
	private JLabel background = MainFrame.background;
	public static JTextField currencyInputField = new JTextField();
	public static JTextField currencyResultsField = new JTextField();
	
	public FieldView() {
		configureInputField();
		configureResultsField();
	}
	
	public void configureInputField() {
		currencyInputField.setHorizontalAlignment(JTextField.CENTER);
        currencyInputField.setBounds(165, 335, 125, 35);
        currencyInputField.setFont(MainFrame.generalFont);
        currencyInputField.setBorder(BorderFactory.createLineBorder(new Color(50,50,50), 1));
        currencyInputField.setDocument(new NumberOnlyDocument());
        background.add(currencyInputField);
        currencyInputField.requestFocus();
	}
	public void configureResultsField() {
		currencyResultsField.setEditable(false);
        currencyResultsField.setHorizontalAlignment(JTextField.CENTER);
        currencyResultsField.setBounds(515, 335, 125, 35);
        currencyResultsField.setFont(MainFrame.generalFont);
        currencyResultsField.setBorder(BorderFactory.createLineBorder(new Color(50,50,50), 1));
        background.add(currencyResultsField);
	}
}
