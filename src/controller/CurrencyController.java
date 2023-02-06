package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import model.ConvertCurrency;
import model.CurrencyList;
import model.CurrencyOption;

public class CurrencyController {
	private CurrencyList currencyList;
	
	public CurrencyController() {
        this.currencyList = new CurrencyList();
	}

	public JComboBox<CurrencyOption> getCurrencyComboBoxInput() {
		return currencyList.getCurrencyComboBoxInput();
	}

	public JComboBox<CurrencyOption> getCurrencyComboBoxOutput() {
		return currencyList.getCurrencyComboBoxOutput();
	}
	public void convertButtonAction(JButton convertButton){
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ConvertCurrency();
			}
		});
	}
}
