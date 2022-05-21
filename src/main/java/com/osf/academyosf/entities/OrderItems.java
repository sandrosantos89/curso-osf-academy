package com.osf.academyosf.entities;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "tb_order_items")
public class OrderItems implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer quantity;
	private Double list_price;
	private Double discount;

	@ManyToOne
	@JoinTable(name = "tb_order_items_orders", joinColumns = @JoinColumn(name = "order_items_orders_id_fkey"), inverseJoinColumns = @JoinColumn(name = "orders"))
	private Orders orders;

	@ManyToOne
	@JoinTable(name = "tb_order_items_products", joinColumns = @JoinColumn(name = "order_items_products_id_fkey"), inverseJoinColumns = @JoinColumn(name = "products"))
	private Products products;

	public Orders getOrder() {
		return orders;
	}

	public OrderItems() {
	}

	public OrderItems(Orders orders, Products product, Integer quantity, Double list_price, Double discount) {
		super();
		this.orders = orders;
		this.products = product;
		this.quantity = quantity;
		this.list_price = list_price;
		this.discount = discount;
	}

	@OneToMany
	public void setOrder(Orders orders) {
		this.orders = orders;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getList_price() {
		return list_price;
	}

	public void setList_price(Double list_price) {
		this.list_price = list_price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public void saveAll(List<OrderItems> asList) {

	}

	public Double getSubTotal() {
		return quantity * list_price;
	}

}
