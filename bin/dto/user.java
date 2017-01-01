package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String name;
	private String surname;
	
	public int getU_id() {
		return id;
	}
	public void setU_id(int u_id) {
		this.id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	


}