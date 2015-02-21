package edu.pitt.bank;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import edu.pitt.utilities.MySqlDbUtilities;

public class Customer {
	private String customerID;
	private String firstName;
	private String lastName;
	private String ssn;
	private String streetAddress;
	private String city;
	private String state;
	private int zip;
	private String loginName;
	private int pin;
	
	public Customer(String customerID){
		String sql = "SELECT * FROM customer ";
		sql += "WHERE customerID = '" + customerID + "'";
		MySqlDbUtilities db = new MySqlDbUtilities();
		try {
			ResultSet rs = db.getResultSet(sql);
			while(rs.next()){
				this.customerID = rs.getString("customerID");
				this.firstName = rs.getString("firstName");
				this.lastName = rs.getString("lastName");
				this.ssn = rs.getString("ssn");
				this.streetAddress = rs.getString("streetAddress");
				this.city = rs.getString("city");
				this.state = rs.getString("state");
				this.zip = rs.getInt("zip");
				this.loginName = rs.getString("loginName");
				this.pin = rs.getInt("pin");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Customer(String lastName, String firstName, String ssn, String loginName, int pin, String streetAddress, String city, String state, int zip){
		this.customerID = UUID.randomUUID().toString();
		this.lastName = lastName;
		this.firstName = firstName;
		this.ssn = ssn;
		this.loginName = loginName;
		this.pin = pin;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		String sql = "INSERT INTO yal73_bank1017.customer ";
		sql += "(customerID, lastName, firstName, ssn, loginName, pin, streetAddress, city, state, zip) ";
		sql += " VALUES ";
		sql += "('" + this.customerID + "', ";
		sql += "'" + this.lastName + "', ";
		sql += "'" + this.firstName + "', ";
		sql += "'" + this.ssn + "', ";
		sql += "'" + this.loginName + "', ";
		sql += "'" + this.pin + "', ";
		sql += "'" + this.streetAddress + "', ";
		sql += "'" + this.city + "', ";
		sql += "'" + this.state + "', ";
		sql += "'" + this.zip +"')";
		
		MySqlDbUtilities db = new MySqlDbUtilities();
		db.executeQuery(sql);
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	
}