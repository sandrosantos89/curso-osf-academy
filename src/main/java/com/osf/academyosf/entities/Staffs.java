package com.osf.academyosf.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "staff")
public class Staffs{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staff_id;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
	@Column(name = "email", nullable= false)
	private String email;
	
	private String phone;
	private Integer active;
	private boolean manager;

	@OneToMany(mappedBy = "staff")
	private List<Order> orders = new ArrayList<>();

	@ManyToOne
	private Stores stores;

	public Staffs() {

	}

	public Integer getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public Stores getStores() {
		return stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}
	
	

}
