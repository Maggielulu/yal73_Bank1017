package edu.pitt.ui;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import edu.pitt.bank.Account;
import edu.pitt.bank.Customer;
import edu.pitt.bank.Security;
import edu.pitt.utilities.MySqlDbUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDetails {

	private JFrame frmBankAccountDetails;
	private Customer accountOwner;
	JComboBox cboAccounts;
	JLabel lblAccountTypeValue;
	private JTextField amountInput;
	public double input;

	/**
	 * Create the application.
	 */
	public AccountDetails(Customer c) {
		accountOwner = c;
		initialize();
		frmBankAccountDetails.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankAccountDetails = new JFrame();
		frmBankAccountDetails.setTitle("Bank1017 Account Details");
		frmBankAccountDetails.setBounds(100, 100, 450, 300);
		frmBankAccountDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankAccountDetails.getContentPane().setLayout(null);
		
		JLabel lblYourAccounts = new JLabel("Your Accounts:");
		lblYourAccounts.setBounds(41, 58, 111, 16);
		frmBankAccountDetails.getContentPane().add(lblYourAccounts);
		
		cboAccounts = new JComboBox();
		cboAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account selectedAccount = (Account) cboAccounts.getSelectedItem();	
			}
		});
		cboAccounts.setBounds(156, 54, 265, 27);
		frmBankAccountDetails.getContentPane().add(cboAccounts);
		
		amountInput = new JTextField();
		amountInput.setBounds(287, 105, 134, 28);
		frmBankAccountDetails.getContentPane().add(amountInput);
		amountInput.setColumns(10);
		
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(219, 146, 83, 27);
		frmBankAccountDetails.getContentPane().add(btnDeposit);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(307, 146, 117, 27);
		frmBankAccountDetails.getContentPane().add(btnWithdraw);
		
		MySqlDbUtilities db = new MySqlDbUtilities();
		String sql = "SELECT fk_accountID FROM customer_account ";
		sql += "WHERE fk_customerID = '" + accountOwner.getCustomerID() + "'"; 
		try {
				ResultSet rs = db.getResultSet(sql);
				while(rs.next()){
				Account acct = new Account(rs.getString("fk_accountID"));
				cboAccounts.addItem(acct);
				
				lblAccountTypeValue = new JLabel();
				lblAccountTypeValue.setBounds(137, 111, 61, 16);
				frmBankAccountDetails.getContentPane().add(lblAccountTypeValue);
				lblAccountTypeValue.setText(acct.getType());
				
				JLabel lblBalanceValue = new JLabel("New label");
				lblBalanceValue.setBounds(102, 139, 61, 16);
				frmBankAccountDetails.getContentPane().add(lblBalanceValue);
				String balance = Double.toString(acct.getBalance());
				lblBalanceValue.setText(balance);
				
				JLabel lblInterestRateValue = new JLabel("New label");
				lblInterestRateValue.setBounds(137, 167, 61, 16);
				frmBankAccountDetails.getContentPane().add(lblInterestRateValue);
				String interestRate = Double.toString(acct.getInterestRate());
				lblInterestRateValue.setText(interestRate);
				
				JLabel lblPenaltyValue = new JLabel("New label");
				lblPenaltyValue.setBounds(102, 195, 61, 16);
				frmBankAccountDetails.getContentPane().add(lblPenaltyValue);
				String penalty = Double.toString(acct.getPenalty());
				lblPenaltyValue.setText(penalty);
				
				amountInput.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String inputAmount = amountInput.getText();
						input = Double.parseDouble(inputAmount);
					}
				});
				
				btnDeposit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MySqlDbUtilities db = new MySqlDbUtilities();
						String sql = "SELECT fk_accountID FROM customer_account ";
						sql += "WHERE fk_customerID = '" + accountOwner.getCustomerID() + "'"; 
						try {
							ResultSet rs = db.getResultSet(sql);
							while(rs.next()){
								Account acct = new Account(rs.getString("fk_accountID"));
								acct.deposit(input);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	
					}
				});
				
				btnWithdraw.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MySqlDbUtilities db = new MySqlDbUtilities();
						String sql = "SELECT fk_accountID FROM customer_account ";
						sql += "WHERE fk_customerID = '" + accountOwner.getCustomerID() + "'"; 
						try {
							ResultSet rs = db.getResultSet(sql);
							while(rs.next()){
								Account acct = new Account(rs.getString("fk_accountID"));
								acct.withdraw(input);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	
						
					}
				});
				
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		JLabel lblAccountType = new JLabel("Account Type:");
		lblAccountType.setBounds(41, 111, 111, 16);
		frmBankAccountDetails.getContentPane().add(lblAccountType);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(41, 139, 61, 16);
		frmBankAccountDetails.getContentPane().add(lblBalance);
		
		JLabel lblInterestRate = new JLabel("Interest Rate:");
		lblInterestRate.setBounds(41, 167, 91, 16);
		frmBankAccountDetails.getContentPane().add(lblInterestRate);
		
		JLabel lblPenalty = new JLabel("Penalty:");
		lblPenalty.setBounds(41, 195, 61, 16);
		frmBankAccountDetails.getContentPane().add(lblPenalty);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(221, 111, 61, 16);
		frmBankAccountDetails.getContentPane().add(lblAmount);
		
		
		JButton btnShowTransactions = new JButton("Show Transactions");
		btnShowTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionUI trans = new TransactionUI();
			}
		});
		btnShowTransactions.setBounds(156, 224, 146, 29);
		frmBankAccountDetails.getContentPane().add(btnShowTransactions);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(304, 224, 117, 29);
		frmBankAccountDetails.getContentPane().add(btnExit);
		
		
		
	}
}
