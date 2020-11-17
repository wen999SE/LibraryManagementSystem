package com.example.demo.pojo;

public class User {
	private String ID;
	private String Name;
	private String Password;
	private String Email;
	@Override
	public String toString() {
		return "User [ID=" + ID + ", Name=" + Name + ", Password=" + Password + ", Email=" + Email + "]";
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
}
