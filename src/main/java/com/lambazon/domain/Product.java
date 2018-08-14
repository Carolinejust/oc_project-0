package com.lambazon.domain;

public class Product {
	
	private Integer id;
	private String name, description, details;
	private int quantity;
	private double price;

	public Product(int id, int quantity, double price, String name, String description) {
		setId(id);
		setQuantity(quantity);
		setPrice(price);
		setName(name);
		setDescription(description);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		/**
		 * If quantity is >= 0 then field quantity show quantity else fiels quantity show 0.
		 */
		if (quantity >= 0) {
			this.quantity = quantity;
		} else {
			this.quantity = 0;
		}
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		/** If price is between 0 and 1000 then field price show price,
		 * else if price is > 1000 then field price show 1000
		 * else if price is < 0 then field price show 0
		 */
		if (price >= 0 && price <= 1000) {
			this.price = price;
		} else if (price > 1000) {
			this.price = 1000;
		} else if (price < 0) {
			this.price = 0;
		}
	}

	/** method for get inventory price on sheet "détail"  product :
	 * price x quantity
	*/
	public double getInventoryPrice() {
		return price * quantity;
	}
}
