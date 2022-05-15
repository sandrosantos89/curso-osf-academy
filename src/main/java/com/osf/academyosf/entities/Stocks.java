package com.osf.academyosf.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stocks")
public class Stocks {

	@Id
	@Column(name = "stoks_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stocks_id;

	private Integer quantity;

	@ManyToOne
	@JoinTable(name = "tb_stocks_products", joinColumns = @JoinColumn(name = "stocks_products_id_fkey"), inverseJoinColumns = @JoinColumn(name = "products_id"))
	private Products products;

	@ManyToOne
	@JoinTable(name = "tb_stocks_store", joinColumns = @JoinColumn(name = "stocks_store_id_fkey"), inverseJoinColumns = @JoinColumn(name = "stores_id"))
	private Stores stores;

	public Stocks() {
	}

	public Stocks(Integer stocks_id, Integer quantity, Products products, Stores stores) {
		super();
		this.stocks_id = stocks_id;
		this.quantity = quantity;
		this.products = products;
		this.stores = stores;
	}

	public static Products check_product() {
		Products prod = new Products();
		if (prod.getProduct_id() == null) {
			throw new IllegalArgumentException("Is necessary one product in stock");
		}
		return prod;
	}

	public Integer getStocks_id() {
		return stocks_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity, Staffs staff) {
		Staffs st = new Staffs();
		if (st.isManager() == true) {
			this.quantity = quantity;
		} else {
			System.out.println("You are not authorized to update stock");
		}
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Stores getStores() {
		return stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}
	

}
