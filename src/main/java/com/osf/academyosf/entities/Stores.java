package com.osf.academyosf.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_stores")
public class Stores extends Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer store_id;
	private String store_name;

	@OneToMany(mappedBy = "stores")
	private List<Stocks> stocks_list;

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

	public Stores(Integer store_id, String store_name, List<Stocks> stocks_list, List<Products> product_list,
			List<Staffs> staffs_list) {
		super();
		this.store_id = store_id;
		this.store_name = store_name;
		this.stocks_list = stocks_list;
		this.product_list = product_list;
		this.staffs_list = staffs_list;
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

	public List<Staffs> getStaffs_list() {
		return staffs_list;
	}

	public List<Stocks> getStocks_list() {
		return stocks_list;
	}

}
