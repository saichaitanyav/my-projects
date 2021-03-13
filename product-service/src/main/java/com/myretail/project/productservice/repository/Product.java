package com.myretail.project.productservice.repository;

package com.targetstudy.myretail.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="Product")
public class Product {
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name="PRODUCT_ID")
	private Long productId;
	
	@NotNull
	@Column(name="NAME")
	private String name;

	public Product(Long productId, String name) {
		super();
		this.productId = productId;
		this.name = name;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}