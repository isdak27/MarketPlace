package model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
	private int code;
	private Client client;
	private ArrayList<Product> products;
	private Date generationDate;
	private String typeTerm;
	
	public Invoice(Client client, ArrayList<Product> products, Date generationDate, String typeTerm) {
		super();
		this.client = client;
		this.products = products;
		this.generationDate = generationDate;
		this.typeTerm = typeTerm;
	}

	public Invoice(int code, Client client, ArrayList<Product> products, Date generationDate, String typeTerm) {
		super();
		this.code = code;
		this.client = client;
		this.products = products;
		this.generationDate = generationDate;
		this.typeTerm = typeTerm;
	}	

	public int getCode() {
		return code;
	}

	public Client getClient() {
		return client;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public String getTypeTerm() {
		return typeTerm;
	}

}
