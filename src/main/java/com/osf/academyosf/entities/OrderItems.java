package com.osf.academyosf.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.osf.academyosf.entities.pk.OrderItemPk;

@Entity
@Table(name = "tb_oder_items")
public class OrderItems implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPk id;

	private Integer quantity;
	private Double list_price;
	private Double discount;

	public OrderItems() {
	}

	public OrderItems(Orders orders, Products product, Integer quantity, Double list_price, Double discount) {
		super();
		id.setOrder(orders);
		id.setProducts(product);
		this.quantity = quantity;
		this.list_price = list_price;
		this.discount = discount;
	}

	public Orders getOrders() {
		return id.getOrder();
	}

	public void setOrders(Orders orders) {
		id.setOrder(orders);
	}

	public Products getProducts() {
		return id.getProducts();
	}

	public void setProducts(Products products) {
		id.setProducts(products);
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
		// TODO Auto-generated method stub
		
	}

}
