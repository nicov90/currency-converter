package controller;

import javax.swing.JButton;

public class ButtonController {
	private JButton convertButton;
	private CurrencyController currencyController;
	
	public ButtonController(JButton convertButton) {
		this.convertButton = convertButton;
		this.currencyController = new CurrencyController();
		convertButtonAction(this.convertButton);
	}
	public void convertButtonAction(JButton convertButton) {
		currencyController.convertButtonAction(convertButton);
	}
}
