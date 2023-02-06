package model;

import java.awt.Cursor;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import view.MainFrame;

public class APIClient {
	private String appId;
	private String inputFieldValue;
	private String selectedCurrencyCode;
	private String selectedCurrencyCode2;
	private String resultValue;
	private HttpURLConnection con;
	
	public APIClient(String inputFieldValue ,String selectedCurrencyCode, String selectedCurrencyCode2) {
		// pending protection
		this.appId = "4n8VLSfH9KcY5lxHqCh6svsgfk5k71bD";
		this.inputFieldValue = inputFieldValue;
		this.selectedCurrencyCode = selectedCurrencyCode;
		this.selectedCurrencyCode2 = selectedCurrencyCode2;
		
		try {
			// Loading cursor
			MainFrame.background.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			URL apiURL = new URL("https://api.apilayer.com/fixer/convert?"
					+ "to="+this.selectedCurrencyCode2+
					"&from="+this.selectedCurrencyCode+
					"&amount="+this.inputFieldValue+
					"&apikey="+this.appId);
			try {
				this.con = (HttpURLConnection) apiURL.openConnection();
				try {
					this.con.setRequestMethod("GET");
					
					this.con.connect();

					Gson gson = new Gson();
					Reader reader = new InputStreamReader(this.con.getInputStream());
					JsonObject response = gson.fromJson(reader, JsonObject.class);
					this.resultValue = response.get("result").getAsString();
					this.con.disconnect();
					MainFrame.background.setCursor(Cursor.getDefaultCursor());
					System.out.println("convertedResult: " + resultValue);
					
				} catch (ProtocolException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				ConnectionError();
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	private void ConnectionError() {
		JLabel messageDisplay = new JLabel("Error en la conexión.");
		messageDisplay.setFont(MainFrame.windowFont);
		JOptionPane.showMessageDialog(null, messageDisplay, "Connection Error", JOptionPane.ERROR_MESSAGE);
	}
	public String getResultValue() {
		return this.resultValue;
	}

}
