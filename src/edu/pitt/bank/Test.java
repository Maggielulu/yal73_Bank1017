package edu.pitt.bank;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import edu.pitt.utilities.DbUtilities;
import edu.pitt.utilities.MySqlDbUtilities;
import edu.pitt.utilities.ErrorLogger;

public class Test {

	public static void main(String[] args) {
		
/*
		MySqlDbUtilities db = new MySqlDbUtilities();
		String sql1 = "SELECT * FROM account;";
		try {
			ResultSet rs = db.getResultSet(sql1);
			while(rs.next()){
				System.out.println(rs.getString("accountID"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ErrorLogger.log(e.getMessage());

		}
*/
		/*
		Account a = new Account("eff30178-5d42-11e3-94ef-97beef767f1d");
		System.out.println(a.getBalance());
		System.out.println(a.getBalance1());
		System.out.println(a.getAccountOwners());
		*/
/*
		Customer c = new Customer("16c5da2a-5d41-11e3-94ef-97beef767f1d");
		System.out.println(c.getFirstName());

		Customer d = new Customer("Betty","White", "299-44-2222","bwhite",1235,"287 Elder street","Pittsburgh", "PA",14829);
		System.out.println(d.getCustomerID());


		Bank b = new Bank();
		ArrayList<Account> a1 = new ArrayList<Account>();
		Account acct = new Account("eff30178-5d42-11e3-94ef-97beef767f1d");
		a1.add(acct);
		Account found = b.findAccount(a1);
		System.out.println(found.getBalance());
		ArrayList<Customer> c1 = new ArrayList<Customer>();
		Customer cust = new Customer("16c5da2a-5d41-11e3-94ef-97beef767f1d");
		c1.add(cust);
		Customer foundc = b.findCustomer(c1);
		System.out.println(foundc.getFirstName());


		Security s = new Security();
		Customer customer = s.validateLogin("nmarcus", 8125);
		System.out.println(customer.getCustomerID());
		 */

		/*
		
		DbUtilities db = new MySqlDbUtilities();
		ArrayList<Account> accountList = new ArrayList<Account>();
		Map<String, Account> betterAccountList = new Hashtable<String, Account>();

		String sql = "SELECT * FROM account";
		ResultSet rs;
		try {
			rs = db.getResultSet(sql);
			while(rs.next()){

				Account a = new Account(rs.getString("accountID"));
				betterAccountList.put(rs.getString("accountID"),a);
				accountList.add(a);
				System.out.println(rs.getString("accountID"));
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();

			
		}
		System.out.println("Better: "+betterAccountList.get("c725c9a1-8050-4a29-940f-ff3d37947935"));
		
		for(Account acct : accountList){
			System.out.println(acct.getBalance());
		}
		 
		
		*/
		
	}

}	  

