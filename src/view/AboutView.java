package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutView {
	private JFrame aboutWindow;
	private JPanel panelLinks;
	
	public AboutView() {
		aboutWindow = new JFrame();
		aboutWindow.setIconImage(MainFrame.logo.getImage());
		aboutWindow.setTitle("Acerca de");
		aboutWindow.setSize(275, 400);
		aboutWindow.setResizable(false);
		aboutWindow.setLocationRelativeTo(MainFrame.background);
		
		addTitle();
		addDescription();
		addImgLinks();

		aboutWindow.setVisible(true);
	}
	private void addTitle() {
		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(new BoxLayout(panelTitle, BoxLayout.Y_AXIS));
		panelTitle.setBorder(BorderFactory.createEmptyBorder(26, 0, 0, 0));
		
		JLabel labelTitle1 = new JLabel("Nicolás");
		labelTitle1.setFont(new Font("Skranji",Font.PLAIN,26));
		labelTitle1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTitle.add(labelTitle1);
		panelTitle.add(Box.createVerticalStrut(0));

		JLabel labelTitle2 = new JLabel("Valdez");
		labelTitle2.setFont(new Font("Skranji",Font.PLAIN,26));
		labelTitle2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTitle.add(labelTitle2);
		panelTitle.add(Box.createVerticalStrut(0));

		JLabel labelTitle3 = new JLabel("Full Stack Developer");
		labelTitle3.setFont(new Font("Arial",Font.BOLD | Font.ITALIC,14));
		labelTitle3.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelTitle3.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 0));
		panelTitle.add(labelTitle3);
		
		aboutWindow.add(panelTitle, BorderLayout.NORTH);
	}
	private void addDescription() {
		JPanel panelDescription = new JPanel();
		panelDescription.setLayout(new BoxLayout(panelDescription, BoxLayout.Y_AXIS));
		panelDescription.setBorder(BorderFactory.createEmptyBorder(45, 0, 0, 0));
		
		JLabel labelDescription1 = new JLabel("Java language-created");
		labelDescription1.setFont(new Font("Calibri",Font.BOLD | Font.ITALIC,14));
		labelDescription1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelDescription.add(labelDescription1);

		JLabel labelDescription2 = new JLabel("Application.");
		labelDescription2.setFont(new Font("Calibri",Font.BOLD | Font.ITALIC,14));
		labelDescription2.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelDescription2.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));
		panelDescription.add(labelDescription2);
		
		JLabel labelDescription3 = new JLabel("Icons by Flaticon.");
		labelDescription3.setFont(new Font("Calibri",Font.PLAIN,14));
		labelDescription3.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelDescription3.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0));
		panelDescription.add(labelDescription3);

		JLabel labelDescription4 = new JLabel("Thanks for using my App!");
		labelDescription4.setFont(new Font("Calibri",Font.BOLD | Font.ITALIC,14));
		labelDescription4.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelDescription4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		panelDescription.add(labelDescription4);
		
		aboutWindow.add(panelDescription, BorderLayout.CENTER);
	}
	private void addImgLinks(){
		panelLinks = new JPanel();
		panelLinks.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		panelLinks.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
		addImgLink1();
		addImgLink2();
		addImgLink3();
		aboutWindow.add(panelLinks, BorderLayout.SOUTH);
	}

	private void addImgLink1() {
		ImageIcon icon1 = new ImageIcon("res/portfolio.png");
		JLabel label1 = new JLabel(icon1);
		label1.setHorizontalAlignment(JLabel.CENTER);
		label1.setCursor(new Cursor(12));
		panelLinks.add(label1);
		
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().
					browse(new URL("https://nicov90.github.io/Portfolio/").toURI());
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	private void addImgLink2() {
		ImageIcon icon2 = new ImageIcon("res/linkedin.png");
		JLabel label2 = new JLabel(icon2);
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setCursor(new Cursor(12));
		panelLinks.add(label2);
		
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().
					browse(new URL("https://www.linkedin.com/in/nicov90/").toURI());
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	private void addImgLink3() {
		ImageIcon icon3 = new ImageIcon("res/github.png");
		JLabel label3 = new JLabel(icon3);
		label3.setHorizontalAlignment(JLabel.CENTER);
		label3.setCursor(new Cursor(12));
		panelLinks.add(label3);
		
		label3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().
					browse(new URL("https://github.com/nicov90").toURI());
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
}
