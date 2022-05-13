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
@Table(name = "tb_products")
public class Products implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;
	private String product_name;
	private int model_year;
	private Double list_price;

	@ManyToOne
	@JoinTable(name = "tb_products_brands", joinColumns = @JoinColumn(name = "products_brand_id_fkey"), inverseJoinColumns = @JoinColumn(name = "brand_id"))
	private Brands brands;

	@ManyToOne
	@JoinTable(name = "tb_products_category", joinColumns = @JoinColumn(name = "products_category_id_fkey"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Categories categories;

	@OneToMany(mappedBy = "products")
	private List<Stocks> stocks_list;

	public Products() {

	}

	public Products(Integer product_id, String product_name, int model_year, Double list_price) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.model_year = model_year;
		this.list_price = list_price;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setId(Integer product_id) {
		this.product_id = product_id;
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

	public Brands getBrands() {
		return brands;
	}

	public void setBrands(Brands brands) {
		this.brands = brands;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public List<Stocks> getStocks_list() {
		return stocks_list;
	}

}
