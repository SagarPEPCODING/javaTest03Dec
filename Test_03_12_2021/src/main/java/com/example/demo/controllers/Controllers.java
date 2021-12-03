package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Product;

@RestController
@RequestMapping("product")
public class Controllers {
	private ArrayList<Product> products = new ArrayList<>();

	@GetMapping("/")
	public String defaultGetRoute() {
		return "Welcome! server is working...";
	}

//	CRUD

//	Create method...
	@PostMapping("addProduct")
	public Product postUser(@RequestBody Product myProduct) {
		String name = myProduct.getName();
		String description = myProduct.getDescription();
		int price = myProduct.getPrice();
		System.out.println(name + " " + description + " " + price);
		Product product = new Product(name, description, price);
		this.products.add(product);
		return product;
	}

//	Read

	@GetMapping("allProduct")
	public ArrayList<Product> getAllProduct() {
		return this.products;
	}

	@GetMapping("getProductByID/{id}")
	public Product getProduct(@PathVariable("id") UUID id) {
		System.out.println(id);
		for (Product product : products) {
			System.out.println(product.getID() + "             " + id);
			if (product.getID().equals(id)) {
				return product;
			}
		}
		return null;
	}

//	update

	@PutMapping("update")
	public Boolean updateUser(@RequestBody Product newUser) {
		for (Product product : products) {
			if (product.getID().equals(newUser.getID())) {
				product.setName(newUser.getName());
				product.setDescription(newUser.getDescription());
				product.setPrice(newUser.getPrice());
				return true;
			}
		}

		return false;
	}

//	Delete
	@DeleteMapping("delete/{id}")
	public Boolean deleteUser(@PathVariable("id") UUID id) {
		System.out.println("thi is my id :- " + id);
		for (Product product : products) {
			if (product.getID().equals(id)) {
				return products.remove(product);
			}
		}
		return false;
	}

}
