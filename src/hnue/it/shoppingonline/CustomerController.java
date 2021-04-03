package hnue.it.shoppingonline;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import hnue.it.shoppingonline.CustomerModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerController {
	public static ArrayList<CustomerModel> findAll() {
		ArrayList<CustomerModel> cusLst = new ArrayList();
		
		Connection con = null;
		Statement statement = null; // get data from database
		
		try {
			// collect all customer list
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "");
			
			//query 
			String sql = "select * from customer";
			statement = con.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				CustomerModel cus = new CustomerModel(resultSet.getInt("id"),
						resultSet.getString("fullname"), 
						resultSet.getString("phone_number"),
						resultSet.getString("email"), 
						resultSet.getString("customer_type"));
				cusLst.add(cus);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}
		return cusLst;
	}
	public static void insert(CustomerModel cus) {
		
		Connection con = null;
		PreparedStatement statement = null; // get data from database
		
		try {
			// collect all customer list
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "");
			
			//query 
			String sql = "insert into customer(fullname, phone_number, email, customer_type) values (?, ?, ?, ?)";
			statement = con.prepareCall(sql);

			statement.setString(1, cus.getUsername());
			statement.setString(2, cus.getPhoneNumber());
			statement.setString(3, cus.getEmail());
			statement.setString(4, cus.getCustomerType());
			statement.execute();
		} catch (SQLException e) {
			
			
			// TODO Auto-generated catch block
			Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}
	}
	
	
public static void delete(int id) {
		
		Connection con = null;
		PreparedStatement statement = null; // get data from database
		
		try {
			// collect all customer list
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshopping", "root", "");
			
			//query 
			String sql = "delete from customer where id=?";
			statement = con.prepareCall(sql);

			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			
			
			// TODO Auto-generated catch block
			Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, e);
				}
			}
		}
	}
}
