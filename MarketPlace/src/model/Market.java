package model;

import java.util.ArrayList;
import java.util.Collections;

public class Market {
	private ArrayList<Product> stock = new ArrayList<>();
	private ArrayList<Client> users=new ArrayList<>();
	private ArrayList<Invoice> issuedInvoices;
	
	public Market(ArrayList<Product> stock, ArrayList<Client> users, ArrayList<Invoice> issuedInvoices) {
		super();
		this.stock = stock;
		this.users = users;
		this.issuedInvoices = issuedInvoices;
	}
	
	public void addProduct(Product OnAddProduct) {
		if (!this.stock.isEmpty()) {
			Collections.sort(stock);
			if (Collections.binarySearch(this.stock,OnAddProduct)< 0) {
				this.stock.add(OnAddProduct);
			}
		} else {
			this.stock.add(OnAddProduct);
		}
	}
	
	public void addProduct(String name, int code, double tax, double priceSale, int quantity) {
		Product OnAddProduct= new Product(name, code, tax, priceSale);
		if (!this.stock.isEmpty()) {
			Collections.sort(stock);
			if (Collections.binarySearch(this.stock,OnAddProduct)< 0) {
				this.stock.add(OnAddProduct);
			}
		} else {
			this.stock.add(OnAddProduct);
		}
	}
	
	public void deleteProduct(int code) {
		Collections.sort(stock);
		int index = Collections.binarySearch(this.stock, new Product(null,code, 0.0, 0.0, 0));
		if (index >= 0) {
		    this.stock.remove(index);
		}
	}
	
	public void deleteProduct(Product target) {
		this.stock.remove(target);
	}

	public ArrayList<Product> getStock() {
		return stock;
	}

	public ArrayList<Client> getUsers() {
		return users;
	}

	public ArrayList<Invoice> getIssuedInvoices() {
		return issuedInvoices;
	}
	
}
