package com.blackparty.questionclassifier.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_TABLE")
public class User implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USERID")
	private int userId;
	

	@Column(name="USERNAME")
	private String username;
	@Column(name="PASSWORD")
	private String password;
	
	
	public User(){
	}
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
