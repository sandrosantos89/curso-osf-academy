package com.osf.academyosf.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

public class Stores extends Adress {

	private Integer store_id;
	private String store_name;

	@OneToMany(mappedBy = "stores")
	private List<Order> orders = new ArrayList<>();

	@OneToMany
	private Staffs staffs;

	public Stores() {

	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
