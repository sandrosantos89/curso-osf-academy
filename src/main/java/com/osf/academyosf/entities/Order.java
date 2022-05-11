package com.osf.academyosf.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.apache.catalina.Store;

import com.osf.academyosf.entities.enums.OrderStatus;

@Entity
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date order_date;
	private Date required_date;
	private Date shipped_date;

	private OrderStatus order_status = OrderStatus.Awaiting_shipment;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;

	@ManyToOne
	@JoinColumn(name = "staff_id")
	private Staffs staffs;

	@ManyToOne
	@JoinColumn(name = "store_id")
	private Stores stores;

	public Order() {
	}

	public Order(Customers customers, Stores stores) {
		Integer stock_store = stores.getStock().getId();
		if (stock_store == null) {
			throw new IllegalStateException("No stock in store");
		}
		this.customers = customers;
		this.stores = stores;

	}

	public Order(Integer id, Date order_date, Date required_date, Date shipped_date, Integer orderStatus,
			Customers customers, Staffs staff, Store store) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.required_date = required_date;
		this.shipped_date = shipped_date;
		this.orderStatus = orderStatus;
		this.customers = customers;
		this.staff = staff;
		this.store = store;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getRequired_date() {
		return required_date;
	}

	public void setRequired_date(Date required_date) {
		this.required_date = required_date;
	}

	public Date getShipped_date() {
		return shipped_date;
	}

	public void setShipped_date(Date shipped_date) {
		this.shipped_date = shipped_date;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Staffs getStaff() {
		return staff;
	}

	public void setStaff(Staffs staff) {
		this.staff = staff;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
