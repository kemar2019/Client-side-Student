package client.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;

import javax.swing.JTextPane;

import java.awt.ComponentOrientation;


import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Complain Complain;
	private Quary Quary;
	private CardLayout view;
	private JPanel viewpanel;
	private  ClientHandler client;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main frame = new Main(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main(ClientHandler client) {
		this.client = client;
	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1111, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		//setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JPanel menu = new JPanel();
		menu.setBackground(new Color(0, 191, 255));
		menu.setBounds(6, 6, 177, 664);
		menu.setLayout(null);
		
		JTextPane txtpnWelcomePleaseSelect = new JTextPane();
		txtpnWelcomePleaseSelect.setOpaque(false);
		txtpnWelcomePleaseSelect.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnWelcomePleaseSelect.setEditable(false);
		txtpnWelcomePleaseSelect.setText("Welcome, please select a service you would like assistance with. ");
		txtpnWelcomePleaseSelect.setBounds(6, 75, 163, 77);
		menu.add(txtpnWelcomePleaseSelect);
		
		JButton btnNewButton_1 = new JButton("Query");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.show(viewpanel, "Query");
				
			}
		});
		
		JButton btnNewButton = new JButton("Complaint");
		btnNewButton.setBounds(6, 177, 179, 44);
		menu.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.show(viewpanel, "complain");
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		btnNewButton_1.setBounds(6, 229, 178, 49);
		menu.add(btnNewButton_1);
		
		
		Complain = new Complain(this.client);
		Quary = new Quary(this.client);
		
		view = new CardLayout();
		viewpanel = new JPanel(view);
		viewpanel.setBounds(210, 0, 901, 676);
		
		
		viewpanel.add("complain",Complain);
		viewpanel.add("Query",Quary);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		paneMainContent.setBounds(195, 648, 910, -635);
		menu.add(viewpanel);
		paneMainContent.setLayout(null);
		
		
		//paneMainContent.add(Complain);
		//paneMainContent.add(Quary);
		
		menuClicked(Complain);
		getContentPane().add(menu,BorderLayout.CENTER);
		
	}
	
	public void menuClicked(JPanel panel) {
		Complain.setVisible(false);
		Quary.setVisible(false);
		
		panel.setVisible(true);
	}
	
	
	
	
	
}
