package com.osf.academyosf.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date order_date;
	private Date required_date;
	private Date shipped_date;

	private Integer orderStatus;

	@ManyToOne
	private Customers customers;

	@ManyToOne
	private Staff staff;

	public Order() {

	}
}
