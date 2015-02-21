package edu.pitt.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import edu.pitt.utilities.DbUtilities;
import edu.pitt.utilities.MySqlDbUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class TransactionUI {

	private JFrame frmBankAccountTransactions;
	private JScrollPane transactionPane;
	private JTable tblTransactions;
	
	/**
	 * Launch the application.
	 */

	public TransactionUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankAccountTransactions = new JFrame();
		frmBankAccountTransactions.setTitle("Bank1017 Account Transactions");
		frmBankAccountTransactions.setBounds(100, 100, 450, 300);
		frmBankAccountTransactions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankAccountTransactions.setVisible(true);
		
		transactionPane = new JScrollPane();
		
		frmBankAccountTransactions.getContentPane().add(transactionPane);
		
		
		
		DbUtilities db = new MySqlDbUtilities();
		String sql = "SELECT * FROM yal73_bank1017.transaction;";
		try {
			DefaultTableModel transactionList = db.getDataTable(sql);
			tblTransactions = new JTable(transactionList);
			tblTransactions.setFillsViewportHeight(true);
			transactionPane.getViewport().add(tblTransactions);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		
		
		
	}
}
