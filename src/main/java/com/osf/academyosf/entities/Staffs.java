package com.osf.academyosf.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_staff")
public class Staffs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staff_id;

	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private boolean active;
	private boolean manager;

	@OneToMany(mappedBy = "staffs")
	@JsonIgnore
	private List<Orders> orders;

	@ManyToOne
	private Stores stores;

	public Staffs() {

	}

	public Staffs(Integer staff_id, String first_name, String last_name, String email, String phone, boolean active,
			boolean manager) {
		super();
		this.staff_id = staff_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.active = active;
		this.manager = manager;

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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public List<Orders> getOrders() {
		return orders;
	}

}
