package com.osf.academyosf.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_customers")
public class Customers extends Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customers_id;

	private String first_name;
	private String last_name;

	@ManyToMany
	@JsonIgnore
	private List<Orders> orders;

	public Customers() {
	}

	public Customers(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Customers(String first_name, String last_name, String phone, String email, String street, String city,
			String state, String zip_code) {
		super(phone, email, street, city, state, zip_code);
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Integer getCustomers_id() {
		return customers_id;
	}

	public void setId(Integer customers_id) {
		this.customers_id = customers_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public List<Orders> getOrders() {
		return orders;
	}

}
