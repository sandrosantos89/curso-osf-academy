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

import org.apache.catalina.Store;

import com.osf.academyosf.entities.enums.OrderStatus;

@Entity
@Table (name = "tb_orders")
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer order_id;

	private Date order_date;
	private Date required_date;
	private Date shipped_date;

	private OrderStatus order_status = OrderStatus.Awaiting_shipment;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customers;

	@ManyToOne
	@JoinTable(name = "tb_orders_staffs", joinColumns = @JoinColumn(name = "orders_staff_id_fkey"), inverseJoinColumns = @JoinColumn(name = "staffs_id"))
	private Staffs staffs;

	@ManyToOne
	@JoinTable(name = "tb_orders_stores", joinColumns = @JoinColumn(name = "orders_store_id_fkey"), inverseJoinColumns = @JoinColumn(name = "stores_id"))
	private Stores stores;

	public Orders() {
	}

	public Orders(Customers customers, Stores stores) {
		Integer stock_store = stores.getStock().getId();
		if (stock_store == null) {
			throw new IllegalStateException("No stock in store");
		}
		this.customers = customers;
		this.stores = stores;

	}

	public Orders(Integer order_id, Date order_date, Date required_date, Date shipped_date, Integer orderStatus,
			Customers customers, Staffs staffs, Stores stores) {
		super();
		this.order_id = order_id;
		this.order_date = order_date;
		this.required_date = required_date;
		this.shipped_date = shipped_date;
		this.orderStatus = orderStatus;
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
