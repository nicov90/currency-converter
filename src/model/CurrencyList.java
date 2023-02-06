package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import view.MainFrame;

public class CurrencyList {
	private JComboBox<CurrencyOption> currencyComboBoxInput;
	private JComboBox<CurrencyOption> currencyComboBoxOutput;
	private CurrencyOption[] currencyOptions = {
            new CurrencyOption("USD", "res/USD.png"),
            new CurrencyOption("ARS", "res/ARS.png"),
            new CurrencyOption("EUR", "res/EUR.png"),
            new CurrencyOption("GBP", "res/GBP.png"),
            new CurrencyOption("PEN", "res/PEN.png"),
            new CurrencyOption("MXN", "res/MXN.png"),
        };
	private JLabel background;
	
	public CurrencyList() {
		this.background = MainFrame.background;
	}
	public JComboBox<CurrencyOption> getCurrencyComboBoxInput() {
		List<CurrencyOption> currencyList1 = new ArrayList<>(Arrays.asList(currencyOptions));
        Collections.sort(currencyList1);
        this.currencyComboBoxInput = new JComboBox<>
        (currencyList1.toArray(new CurrencyOption[currencyList1.size()]));
        this.currencyComboBoxInput.setBounds(125, 270, 200, 45);
        background.add(currencyComboBoxInput);
        
		return this.currencyComboBoxInput;
	}
	public JComboBox<CurrencyOption> getCurrencyComboBoxOutput(){
        CurrencyOption[] currencyOptions2 = currencyOptions.clone();
        List<CurrencyOption> currencyList2 = new ArrayList<>(Arrays.asList(currencyOptions2));
        Collections.sort(currencyList2);
        this.currencyComboBoxOutput = new JComboBox<>
        (currencyList2.toArray(new CurrencyOption[currencyList2.size()]));
        this.currencyComboBoxOutput.setBounds(475, 270, 200, 45);
        background.add(currencyComboBoxOutput);
		
		return this.currencyComboBoxOutput;
	}
}
