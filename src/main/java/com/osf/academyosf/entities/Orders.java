package com.osf.academyosf.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "tb_orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;

	private Date order_date;
	private Date required_date;
	private Date shipped_date;

	private Integer orderStatus;

	@ManyToOne
	@JoinTable(name = "tb_orders_customers", joinColumns = @JoinColumn(name = "orders_customer_id_fkey"), inverseJoinColumns = @JoinColumn(name = "customers_id"))
	private Customers customers;

	@ManyToOne
	@JoinTable(name = "tb_orders_staffs", joinColumns = @JoinColumn(name = "orders_staff_id_fkey"), inverseJoinColumns = @JoinColumn(name = "staffs_id"))
	private Staffs staffs;

	@ManyToOne
	@JoinTable(name = "tb_orders_stores", joinColumns = @JoinColumn(name = "orders_store_id_fkey"), inverseJoinColumns = @JoinColumn(name = "stores_id"))
	private Stores stores;

	public Orders() {
	}

	public Orders(Integer order_id, Date order_date, Date required_date, Date shipped_date, OrderStatus orderStatus,
			Customers customers, Staffs staffs, Stores stores) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.required_date = required_date;
		this.shipped_date = shipped_date;
		setOrderStatus(orderStatus);
		this.customers = customers;
		this.staffs = staffs;
		this.stores = stores;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setId(Integer id) {
		this.order_id = id;
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

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public Staffs getStaffs() {
		return staffs;
	}

	public void setStaffs(Staffs staff) {
		this.staffs = staff;
	}

	public Stores getStores() {
		return stores;
	}

	public void setStores(Stores stores) {
		this.stores = stores;
	}

}
