package com.osf.academyosf.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String product_name;
	private int model_year;
	private Double list_price;

	public Products() {

	}

	public Products(Integer id, String product_name, int model_year, Double list_price) {
		this.id = id;
		this.product_name = product_name;
		this.model_year = model_year;
		this.list_price = list_price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getModel_year() {
		return model_year;
	}

	public void setModel_year(int model_year) {
		this.model_year = model_year;
	}

	public Double getList_price() {
		return list_price;
	}

	public void setList_price(Double list_price) {
		this.list_price = list_price;
	}

}
