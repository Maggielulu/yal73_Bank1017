package edu.pitt.bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import edu.pitt.utilities.DbUtilities;
import edu.pitt.utilities.MySqlDbUtilities;

/**
 * Account class documents and creates new accounts in the database
 * @author Yao Lu
 *
 */

public class Account {
	private String accountID;
	private String type;
	private double balance;
	private double interestRate;
	private double penalty;
	private String status;
	private Date dateOpen;
	private ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	private ArrayList<Customer> accountOwners = new ArrayList<Customer>();
	
	private String transactionID;
	private String accountID1;
	private double amount;
	private Date transactionDate;
	private String type1;
	private double balance1;
	
	/**
	 * Default constructor for the account class taking in the parameter of accountID
	 * @param accountID
	 */
	
	
	public Account(String accountID){
		String sql = "SELECT * FROM account "; 
		sql += "WHERE accountID = '" + accountID + "'";
		DbUtilities db = new MySqlDbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				this.accountID = rs.getString("accountID");
				this.type = rs.getString("type");
				this.balance = rs.getDouble("balance");
				this.interestRate = rs.getDouble("interestRate");
				this.penalty = rs.getDouble("penalty");
				this.status = rs.getString("status");
				this.dateOpen = new Date();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql1 = "SELECT * FROM transaction ";
		sql1 += "WHERE accountID = '" + accountID + "'";
		MySqlDbUtilities db1 = new MySqlDbUtilities();
		try {
			ResultSet rs1 = db1.getResultSet(sql1);
			while(rs1.next()){
				this.transactionID = rs1.getString("transactionID");
				this.accountID1 = rs1.getString("accountID");
				this.amount = rs1.getDouble("amount");
				this.transactionDate = new Date();
				this.type1 = rs1.getString("type");
				this.balance1 = rs1.getDouble("balance");	
				createTransaction(this.transactionID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	/** 
	 * Alternative constructor
	 * @param accountType
	 * @param initialBalance
	 */
	
	
	public Account(String accountType, double initialBalance){
		this.accountID = UUID.randomUUID().toString();
		this.type = accountType;
		this.balance = initialBalance;
		this.interestRate = 0;
		this.penalty = 0;
		this.status = "active";
		this.dateOpen = new Date();
		
		String sql = "INSERT INTO account ";
		sql += "(accountID,type,balance,interestRate,penalty,status,dateOpen) ";
		sql += " VALUES ";
		sql += "('" + this.accountID + "', ";
		sql += "'" + this.type + "', ";
		sql += "'" + this.balance + ", ";
		sql += "'" + this.interestRate + ", ";
		sql += "'" + this.penalty + ", ";
		sql += "'" + this.status + "', ";
		sql += "CURDATE());";
		
		MySqlDbUtilities db = new MySqlDbUtilities();
		db.executeQuery(sql);
	}
	
	/**
	 * class withdraw lets the user update the amount in the account
	 * @param amount
	 */
	public void withdraw(double amount){
		this.balance -= amount;
		createTransaction(this.accountID, this.type, amount, this.balance);
		updateDatabaseAccountBalance();
	}
	
	/**
	 * class deposit lets the user update the amount in the account
	 * @param amount
	 */
	public void deposit(double amount){
		this.balance += amount;
		createTransaction(this.accountID, this.type, amount, this.balance);
		updateDatabaseAccountBalance();
	}
	
	private void updateDatabaseAccountBalance(){
		String sql = "UPDATE account SET balance = " + this.balance + " ";
		sql += "WHERE accountID = '" + this.accountID + "';";
		
		MySqlDbUtilities db = new MySqlDbUtilities();
		db.executeQuery(sql);
	}
	
	private Transaction createTransaction(String transactionID){
		Transaction t = new Transaction(transactionID);
		transactionList.add(t);
		return t;
	}
	
	private Transaction createTransaction(String accountID, String type, double amount, double balance){
		Transaction t = new Transaction(accountID, type, amount, balance);
		transactionList.add(t);
		return t;
	}
	
	public void addAccountOwner(Customer accountOwner){
		accountOwners.add(accountOwner);
	}
	
	public String getAccountID(){
		return this.accountID;
	}
	
	public double getBalance(){
		return this.balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOpen() {
		return dateOpen;
	}

	public void setDateOpen(Date dateOpen) {
		this.dateOpen = dateOpen;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(ArrayList<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public ArrayList<Customer> getAccountOwners() {
		return accountOwners;
	}

	public void setAccountOwners(ArrayList<Customer> accountOwners) {
		this.accountOwners = accountOwners;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getAccountID1() {
		return accountID1;
	}

	public void setAccountID1(String accountID1) {
		this.accountID1 = accountID1;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public double getBalance1() {
		return balance1;
	}

	public void setBalance1(double balance1) {
		this.balance1 = balance1;
	}
	
	@Override
	public String toString(){
		return this.accountID;
	}
	
}
