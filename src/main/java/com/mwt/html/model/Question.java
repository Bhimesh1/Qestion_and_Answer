package com.mwt.html.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Question {
	
	@Id
	@GeneratedValue
private int id;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	private String askquestion;
	public String getAskquestion() {
		return askquestion;
	}



	public void setAskquestion(String askquestion) {
		this.askquestion = askquestion;
	}



	private String email;

	private String name;
	private String edit;

	public String getEdit() {
		return edit;
	}



	public void setEdit(String edit) {
		this.edit = edit;
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


	

	
	
	

}
