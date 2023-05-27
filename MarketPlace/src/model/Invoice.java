package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Invoice implements Comparable<Invoice>{
	private int code;
	private Client client;
	private ArrayList<ProductInvoice> products;
	private Date generationDate;
	private String typeTerm;

	public Invoice(Client client, ArrayList<ProductInvoice> products, Date generationDate, String typeTerm) {
		super();
		this.client = client;
		this.products = products;
		this.generationDate = generationDate;
		this.typeTerm = typeTerm;
	}

	public Invoice(int code, Client client, ArrayList<ProductInvoice> products, Date generationDate, String typeTerm) {
		super();
		this.code = code;
		this.client = client;
		this.products = products;
		this.generationDate = generationDate;
		this.typeTerm = typeTerm;
	}

	public void addinvoiceProduct(ProductInvoice OnAddProduct) {
		if (!this.products.isEmpty()) {
			Collections.sort(products);
			if (Collections.binarySearch(this.products, OnAddProduct) < 0) {
				this.products.add(OnAddProduct);
			}
		} else {
			this.products.add(OnAddProduct);
		}
	}

	public void deleteInvoiceProduct(ProductInvoice onDeleteProduct) {
		this.products.remove(onDeleteProduct);
	}

	public void deleteProduct(int code) {
		Collections.sort(this.products);
		int index = Collections.binarySearch(this.products, new ProductInvoice(null, code, 0.0, 0.0, 0));
		if (index >= 0) {
			this.products.remove(index);
		}
	}

	public int getCode() {
		return code;
	}

	public Client getClient() {
		return client;
	}

	public ArrayList<ProductInvoice> getProducts() {
		return products;
	}

	public Date getGenerationDate() {
		return generationDate;
	}

	public String getTypeTerm() {
		return typeTerm;
	}

	@Override
	public int compareTo(Invoice other) {
		return Integer.compare(this.code, other.code);
	}

}
