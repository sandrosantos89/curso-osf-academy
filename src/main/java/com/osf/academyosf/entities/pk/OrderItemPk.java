package com.osf.academyosf.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.osf.academyosf.entities.Orders;
import com.osf.academyosf.entities.Products;

@Embeddable
public class OrderItemPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products products;

	public Orders getOrder() {
		return order;
	}

	@OneToMany
	public void setOrder(Orders order) {
		this.order = order;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

}
