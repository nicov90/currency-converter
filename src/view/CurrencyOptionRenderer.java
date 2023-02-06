package view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.CurrencyList;
import model.CurrencyOption;

/**
 * Class that renders the currencies' selectors. 
 * <br>Receives a boolean that determines the combo box to be used for selection.
 * 
 * @author Nicolas Valdez
 *
 */

public class CurrencyOptionRenderer extends JLabel implements ListCellRenderer<CurrencyOption> {
	private static final long serialVersionUID = 1L;
	private CurrencyList currencyList = new CurrencyList();
	private static CurrencyOption selectedCurrency;
	private static CurrencyOption selectedCurrency2;
	private boolean isComboBox1;

	private Font font = new Font("Arial", Font.BOLD, 15);

	public CurrencyOptionRenderer(boolean isComboBox1) {
		setOpaque(true);
		this.isComboBox1 = isComboBox1;
	}
	@Override
	public Component getListCellRendererComponent(JList<? extends CurrencyOption> list, CurrencyOption option, int index,
			boolean isSelected, boolean cellHasFocus) {
		
		setText(option.getCountryCode());
		setIcon(option.getCountryIcon());
		setFont(font);
		
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
			if(isComboBox1) {
				CurrencyOptionRenderer.selectedCurrency = list.getSelectedValue();
			}else {
				CurrencyOptionRenderer.selectedCurrency2 = list.getSelectedValue();
			}
			
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
			// Si no se selecciona ninguna moneda, se utilizará la primer moneda.
			if(CurrencyOptionRenderer.selectedCurrency == null) {
				CurrencyOptionRenderer.selectedCurrency = currencyList.getCurrencyComboBoxInput().
						getItemAt(0);
			}
			if(CurrencyOptionRenderer.selectedCurrency2 == null) {
				CurrencyOptionRenderer.selectedCurrency2 = currencyList.getCurrencyComboBoxOutput().
						getItemAt(0);
			}
		}
		
		setEnabled(list.isEnabled());
		setOpaque(true);
		
		return this;
	}
	public CurrencyOption getSelectedCurrency() {
		return CurrencyOptionRenderer.selectedCurrency;
	}public CurrencyOption getSelectedCurrency2() {
		return CurrencyOptionRenderer.selectedCurrency2;
	}
}