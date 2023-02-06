package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.CurrencyController;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static ImageIcon logo;
	private JLabel title;
	public static JLabel background;
	public static Font titleFont;
	public static Font generalFont = new Font("Arial", Font.PLAIN, 18);
	public static Font windowFont = new Font("Calibri", Font.PLAIN, 18);
	
	public MainFrame() {
        windowProperties();
        setAppIcon();
        background();
        customFontLoader();
        setTitle();
        new FieldView();
        createArrow();
        new ButtonView();
        
        currencySelectors();
        setVisible(true);
        FieldView.currencyInputField.requestFocusInWindow();
	}
	private void background() {
		background = new JLabel();
        background.setIcon(new ImageIcon("res/background.png"));
        add(background, BorderLayout.CENTER);
	}
	private void windowProperties() {
		setTitle("Conversor");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
	}
	private void setAppIcon() {
		MainFrame.logo = new ImageIcon("res/logo.png");
        setIconImage(MainFrame.logo.getImage());
	}
	private void customFontLoader() {
		try {
			MainFrame.titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/Skranji.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(titleFont);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	private void setTitle() {
        title = new JLabel("Conversor de monedas");
        title.setForeground(new Color(255,255,255));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(MainFrame.titleFont.deriveFont(Font.PLAIN, 48));
        title.setBounds(0, 110, 800, 50);
		
        background.add(title);
	}
	private void createArrow() {
		ImageIcon arrowImg = new ImageIcon("res/right-arrow.png");
		JLabel arrowImgDisplay = new JLabel(arrowImg);
		arrowImgDisplay.setBounds(365,265,64,64);
		background.add(arrowImgDisplay);
	}
	private void currencySelectors() {
		CurrencyController currencyController = new CurrencyController();
		currencyController.getCurrencyComboBoxInput().setRenderer(new CurrencyOptionRenderer(true));
        currencyController.getCurrencyComboBoxOutput().setRenderer(new CurrencyOptionRenderer(false));
	}
}