package edu.pitt.bank;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.pitt.utilities.MySqlDbUtilities;

public class Security {
	public Customer validateLogin(String loginName, int pin){
		String sql = "SELECT * FROM customer WHERE loginName = '" + loginName + "'" + " AND pin = '" + pin + "';";
		Customer cust = null;
		//System.out.println(sql);
		MySqlDbUtilities db = new MySqlDbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			if(rs.next()){
				cust = new Customer(rs.getString("customerID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return cust;
	}

	/*
	public ArrayList<String> listUserGroups(){
		
	}
	*/

}
