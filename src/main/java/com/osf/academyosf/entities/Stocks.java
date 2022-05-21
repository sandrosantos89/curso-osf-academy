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

import com.osf.academyosf.entities.enums.OrderStatus;

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

	public Stocks(Integer stocks_id, Integer quantity, Products products) {
		super();
		this.stocks_id = stocks_id;
		this.quantity = quantity;
		this.products = products;

	}

	public void addQtdeStocks(int qtde) {
		this.quantity += qtde;
	}

	public static Products check_product() {
		Products prod = new Products();
		if (prod.getProduct_id() == null) {
			throw new IllegalArgumentException("Is necessary one product in stock");
		}
		return prod;
	}

	public void returnStocks(Orders order, OrderStatus orderStatus, Integer qtde) {
		Orders od = new Orders();
		if (od.getOrderStatus() == OrderStatus.Canceled) {
			this.quantity += qtde;
		} else {
			this.quantity -= qtde;
		}
	}

	public int getQtdeStocks(int qtde) {
		return this.quantity;
	}

	public void setQuantity(Integer quantity, Staffs staff) {
		Staffs stf = new Staffs();
		if (stf.isManager() == true) {
			this.quantity = quantity;
		} else {
			throw new IllegalArgumentException("You are not authorized to update stock");
		}
	}

	public Integer getStocks_id() {
		return stocks_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

}
