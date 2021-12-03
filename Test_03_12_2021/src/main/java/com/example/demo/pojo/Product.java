package com.example.demo.pojo;

import java.util.UUID;

//Test:
//1. Create a spring boot project using STS or any IDE with Web Dependency.
//2. Create CRUD For Product Entity: id, name, price, description
public class Product {
	private UUID id;
	private String name, Description;
	private int price;

	public Product(String name, String Description, int price) {
		UUID uuid = UUID.randomUUID();
		this.id = uuid;
		this.name = name;
		this.Description = Description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return Description;
	}

	public int getPrice() {
		return price;
	}

	public UUID getID() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.Description = description;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "data is:- " + this.getID() + " " + this.getName() + " " + this.getDescription() + " " + this.getPrice();
	}
}
