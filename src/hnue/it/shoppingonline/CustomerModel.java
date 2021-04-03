package hnue.it.shoppingonline;


public class CustomerModel {
	private int id;
	private	String username;
	private String phoneNumber;
	private	String email;
	private String customerType;
	public CustomerModel() {
		// TODO Auto-generated constructor stub
	}
	public CustomerModel(int id, String username, String phoneNumber, String email, String customerType) {
		super();
		this.id = id;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.email = email;	
		this.customerType = customerType;
	}
	public CustomerModel(String username, String phoneNumber, String email, String customerType) {
		super();
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.customerType = customerType;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
	
	
		

