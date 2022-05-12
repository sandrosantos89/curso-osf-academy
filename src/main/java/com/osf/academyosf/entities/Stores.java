package com.osf.academyosf.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_stores")
public class Stores extends Adress {

	private Integer store_id;
	private String store_name;

	@ManyToOne()
	@JoinTable(name = "tb_stocks_store", joinColumns = @JoinColumn(name = "stocks_store_id_fkey"), inverseJoinColumns = @JoinColumn(name = "stock_id"))
	private Stocks stocks;

	@OneToMany
	@JsonIgnore
	private List<Products> product_list;

	@OneToMany(mappedBy = "stores")
	private List<Orders> orders_list = new ArrayList<>();

	@OneToMany
	@JsonIgnore
	private List<Staffs> staffs_list;

	public Stores() {

	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_name() {
		return store_name;
	}

	public Stocks getStocks() {
		return stocks;
	}

	public void setStocks(Stocks stocks) {
		this.stocks = stocks;
	}

	public List<Staffs> getStaffs_list() {
		return staffs_list;
	}

	public List<Orders> getOrders() {
		return orders_list;
	}
}
