package com.osf.academyosf.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "stocks")
	private List<Stores> stores_list;

	public Stocks() {
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

	public void setStocks_id(Integer stocks_id) {
		this.stocks_id = stocks_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<Stores> getStores_list() {
		return stores_list;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

}
