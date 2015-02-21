package edu.pitt.bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.pitt.utilities.MySqlDbUtilities;


/**
 * Class Bank set up the account owners and load the account in an array list
 * @author Yao Lu
 *
 */
public class Bank {
		
	private ArrayList<Account> accountList = new ArrayList<Account>();
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public Bank() {
		loadAccounts();
		setAccountOwners();
	}
	
	/**
	 * class loadAccount return the arraylist of accounts in the MYSQL database
	 * @return
	 */
	public ArrayList<Account> loadAccounts(){
		String sql = "SELECT * from account";
		MySqlDbUtilities db = new MySqlDbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				Account a = new Account(rs.getString("accountID"));
				accountList.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountList;
	}

	/**
	 * class findAccount take in the parameter of the accountlist and return the searched account
	 * @param accountList
	 * @return
	 */
	
	public Account findAccount(ArrayList<Account> accountList){
		for(int i = 0; i < accountList.size(); i++){
			Account selectedAcct = accountList.get(i);
			String sql = "SELECT accountID from account";
			sql += " WHERE accountID = '" + selectedAcct.getAccountID() + "'";
			MySqlDbUtilities db = new MySqlDbUtilities();
			try {
				ResultSet rs = db.getResultSet(sql);
				while(rs.next()){
				Account a = new Account(rs.getString("accountID"));
				return a;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * class findCustomer performs a linear search of the customerlist
	 * @param customerList
	 * @return
	 */
	
	public Customer findCustomer(ArrayList<Customer> customerList){
		for(int i = 0; i < accountList.size(); i++){
			Customer selectedCust = customerList.get(i);
			String sql = "SELECT customerID from customer";
			sql += " WHERE customerID = '" +selectedCust.getCustomerID() + "'";
			MySqlDbUtilities db = new MySqlDbUtilities();
			try {
				ResultSet rs = db.getResultSet(sql);
				while(rs.next()){
				Customer c = new Customer(rs.getString("customerID"));
				return c;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
	
	public void setAccountOwners(){
		
		String sql = "SELECT * FROM customer_account";
		MySqlDbUtilities db = new MySqlDbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				Customer c = new Customer(rs.getString("fk_customerID"));
				customerList.add(c);
				Account a = new Account(rs.getString("fk_accountID"));
				a.addAccountOwner(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public ArrayList<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
	
}
	


