package model;

import javax.swing.ImageIcon;

/**
 * Add new currency to the list.
 * 
 * @author Nicolas Valdez
 *
 */
public class CurrencyOption implements Comparable<CurrencyOption>{
	private String countryCode;
	private ImageIcon countryIcon;

	public CurrencyOption(String countryCode, String iconPath) {
		this.countryCode = countryCode;
		this.countryIcon = new ImageIcon(iconPath);
	}

	public String getCountryCode() {
		return countryCode;
	}

	public ImageIcon getCountryIcon() {
		return countryIcon;
	}
	@Override
	  public int compareTo(CurrencyOption co) {
	    return this.countryCode.compareTo(co.countryCode);
	  }
	@Override
	public String toString() {
		return "Moneda: " + countryCode;
	}
}