package model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.CurrencyOptionRenderer;
import view.FieldView;
import view.MainFrame;

public class ConvertCurrency {
	private CurrencyOptionRenderer currencyOptionRenderer = new CurrencyOptionRenderer(true);
	
	public ConvertCurrency() {
		// Obtener valor del inputField
		String inputFieldValue = FieldView.currencyInputField.getText();
		System.out.println("valor: " + inputFieldValue);
		
		// Obtener ambos items seleccionadoss de los comboBox
		CurrencyOption selectedCurrency = currencyOptionRenderer.getSelectedCurrency();
		String selectedCurrencyCode = selectedCurrency.getCountryCode();
		System.out.println("currency1: " + selectedCurrencyCode);
		
		CurrencyOption selectedCurrency2 = currencyOptionRenderer.getSelectedCurrency2();
		String selectedCurrencyCode2 = selectedCurrency2.getCountryCode();
		System.out.println("currency2: " + selectedCurrencyCode2);
		
		// Pasar los valores a la API.
		if(!inputFieldValue.isEmpty()) {
			APIClient convertCurrency = new APIClient(inputFieldValue,
					selectedCurrencyCode,selectedCurrencyCode2);
			String results = convertCurrency.getResultValue();
			
			// Muestra el resultado en pantalla
			FieldView.currencyResultsField.setText(results);
		}else {
			valueMissingError();
		}
	}
	private void valueMissingError() {
		JLabel messageDisplay = new JLabel("Por favor ingrese un número!");
		messageDisplay.setFont(MainFrame.windowFont);
		JOptionPane.showMessageDialog(null, messageDisplay, "Missing Value", JOptionPane.WARNING_MESSAGE);
	}
}
