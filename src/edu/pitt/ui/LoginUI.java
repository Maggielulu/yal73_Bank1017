package edu.pitt.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import edu.pitt.bank.Customer;
import edu.pitt.bank.Security;
import edu.pitt.ui.AccountDetails;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI {

	private JFrame frmBankLogin;
	private JTextField txtLoginName;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI window = new LoginUI();
					window.frmBankLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankLogin = new JFrame();
		frmBankLogin.setTitle("Bank1017 Login");
		frmBankLogin.setBounds(100, 100, 450, 300);
		frmBankLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankLogin.getContentPane().setLayout(null);
		
		JLabel lblLoginName = new JLabel("Login Name:");
		lblLoginName.setBounds(37, 49, 84, 16);
		frmBankLogin.getContentPane().add(lblLoginName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(37, 116, 84, 16);
		frmBankLogin.getContentPane().add(lblPassword);
		
		txtLoginName = new JTextField();
		txtLoginName.setBounds(133, 43, 260, 22);
		frmBankLogin.getContentPane().add(txtLoginName);
		txtLoginName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(133, 110, 260, 28);
		frmBankLogin.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginName = txtLoginName.getText();
				String Password = txtPassword.getText();
				int password = Integer.parseInt(Password);
				Security s = new Security();
				Customer c = s.validateLogin(loginName,password );
				if(c != null){
					AccountDetails ad = new AccountDetails(c);
					frmBankLogin.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Login");
				}
			}
			});
		
		
		btnLogin.setBounds(217, 212, 117, 29);
		frmBankLogin.getContentPane().add(btnLogin);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(332, 212, 84, 29);
		frmBankLogin.getContentPane().add(btnExit);
	}

}
