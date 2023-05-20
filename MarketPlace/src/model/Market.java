package model;

import java.util.ArrayList;
import java.util.Collections;

public class Market {
	private ArrayList<ProductStock> stock = new ArrayList<>();
	private ArrayList<Client> users=new ArrayList<>();
	private ArrayList<Invoice> issuedInvoices;
	
	public Market(ArrayList<ProductStock> stock, ArrayList<Client> users, ArrayList<Invoice> issuedInvoices) {
		super();
		this.stock = stock;
		this.users = users;
		this.issuedInvoices = issuedInvoices;
	}
	
	public void addProduct(ProductStock OnAddProduct) {
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
		ProductStock OnAddProduct= new ProductStock(name, code, tax, priceSale);
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
		int index = Collections.binarySearch(this.stock, new ProductStock(null,code, 0.0, 0.0, 0));
		if (index >= 0) {
		    this.stock.remove(index);
		}
	}
	
	public void deleteProduct(ProductStock target) {
		this.stock.remove(target);
	}
	
	public void addinvoiceProduct(Invoice invoiceinIssue,ProductStock target, int quantity) {
		if (this.stockReviewer(target, quantity)) {
			target.setQuantity(target.getQuantity()-quantity);
			invoiceinIssue.addinvoiceProduct(new ProductInvoice(target.getName(),target.getCode(),target.getTax(),target.getPriceSale(), quantity));
		}
	}
	
	public void deleteInvoiceProduct(Invoice invoiceinIssue, int code) {
		invoiceinIssue.deleteProduct(code);
	}
	
	public void deleteInvoiceProduct(Invoice invoiceIssue,ProductInvoice product) {
		invoiceIssue.deleteInvoiceProduct(product);
	}
	
	public boolean stockReviewer(ProductStock reviewProduct,int quantity) {
		return reviewProduct.getQuantity()>= quantity;
	}
	

	public ArrayList<ProductStock> getStock() {
		return stock;
	}

	public ArrayList<Client> getUsers() {
		return users;
	}

	public ArrayList<Invoice> getIssuedInvoices() {
		return issuedInvoices;
	}
	
}
