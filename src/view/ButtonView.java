package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ButtonController;

public class ButtonView {
	private JLabel background;
	private JButton convertButton = new JButton("Convertir");
	private JButton aboutBtn;
	
	public ButtonView() {
		this.background = MainFrame.background;
		configureConvertButton();
		configureAboutButton();
		new ButtonController(convertButton);
	}
	public void configureConvertButton() {
        convertButton.setFont(new Font("Arial", Font.BOLD, 17));
        convertButton.setBounds(335, 420, 130, 40);
        convertButton.setBackground(new Color(95,95,95));
        convertButton.setForeground(Color.WHITE);
        convertButton.setHorizontalAlignment(JTextField.CENTER);
        convertButton.setVerticalAlignment(JTextField.CENTER);
        convertButton.setBorder(BorderFactory.createLineBorder(new Color(20,20,20), 1));
        convertButton.setFocusPainted(false);
        background.add(convertButton);
	}
	public void configureAboutButton() {
		aboutBtn = new JButton("Acerca de");
		aboutBtn.setBounds(685, 531, 100, 30);
		aboutBtn.setBackground(new Color(60,60,60));
		aboutBtn.setFont(new Font("Tahoma",Font.BOLD,12));
		aboutBtn.setForeground(Color.WHITE);
		aboutBtn.setBorder(BorderFactory.createLineBorder(new Color(60,60,60), 1));
		aboutBtn.setFocusPainted(false);
		aboutBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	new AboutView();
	        }
	    });
	    background.add(aboutBtn);
	}
}
