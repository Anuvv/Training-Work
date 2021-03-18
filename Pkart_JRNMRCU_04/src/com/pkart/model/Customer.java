
//	MODEL CLASS FOR CUSTOMER

package com.pkart.model;

public class Customer {

	private long id;
	private String name;
	private String email;
	private long phoneNumber;
	private String address;
	
	public Customer() {}
	
	public Customer(long id, String name, String email, long phoneNumber, String address)
	{
		this.id=id;
		this.name=name;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.address=address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + "]" + "\n";
	}
	
	
}
