package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Market {

	private ArrayList<ProductStock> stock;
	private ArrayList<Client> users;
	private ArrayList<Invoice> issuedInvoices;

	public Market() {
		stock = new ArrayList<>();
		users = new ArrayList<>();
		issuedInvoices = new ArrayList<>();
	}

	public Market(ArrayList<ProductStock> stock, ArrayList<Client> users, ArrayList<Invoice> issuedInvoices) {
		super();
		this.stock = stock;
		this.users = users;
		this.issuedInvoices = issuedInvoices;
	}

	public void addProduct(ProductStock OnAddProduct) {
		if (!this.stock.isEmpty()) {
			Collections.sort(this.stock);
			if (Collections.binarySearch(this.stock, OnAddProduct) < 0) {
				this.stock.add(OnAddProduct);
			}
		} else {
			this.stock.add(OnAddProduct);
		}
	}

	public void addProduct(String name, int code, double tax, double priceSale, int quantity) {
		ProductStock OnAddProduct = new ProductStock(name, code, tax, priceSale);
		if (!this.stock.isEmpty()) {
			Collections.sort(this.stock);
			if (Collections.binarySearch(this.stock, OnAddProduct) < 0) {
				this.stock.add(OnAddProduct);
			}
		} else {
			this.stock.add(OnAddProduct);
		}
	}

	public void deleteProduct(int code) {
		Collections.sort(this.stock);
		int index = Collections.binarySearch(this.stock, new ProductStock(null, code, 0.0, 0.0, 0));
		if (index >= 0) {
			this.stock.remove(index);
		}
	}

	public void deleteProduct(ProductStock target) {
		this.stock.remove(target);
	}

	public void addClient(Client client) {
		if (!this.users.isEmpty()) {
			Collections.sort(this.users);
			if (Collections.binarySearch(this.users, client) < 0) {
				this.users.add(client);
			}
		} else {
			this.users.add(client);
		}
	}
	
	public Client clientSearch(long documentNumber) {
			Collections.sort(this.users);
			int position = Collections.binarySearch(this.users,new Client(null,documentNumber, null, null, null) );
			if (position >= 0) {
				return this.users.get(position);
			}
			return null;
	}

	public void addClient(String documentType, int documentNumber, String reasonSocial, String addres, String phone) {
		Client client = new Client(documentType, documentNumber, reasonSocial, addres, phone);
		if (!this.users.isEmpty()) {
			Collections.sort(this.users);
			if (Collections.binarySearch(this.users, client) < 0) {
				this.users.add(client);
			}
		} else {
			this.users.add(client);
		}
	}

	public void deleteClient(long id) {
		Collections.sort(this.users);
		int index = Collections.binarySearch(this.users, new Client(null, id, null, null, null));
		if (index >= 0) {
			this.users.remove(index);
		}
	}

	public void deleteClient(Client target) {
		this.users.remove(target);
	}

	public void addInvoice(int code, Client client, ArrayList<ProductInvoice> products, Date generationDate,
			String typeTerm) {
		Invoice invoiceinIssue = new Invoice(code,client, products, generationDate, typeTerm);
		if (!this.issuedInvoices.isEmpty()) {
			Collections.sort(this.issuedInvoices);
			if (Collections.binarySearch(this.issuedInvoices, invoiceinIssue) < 0) {
				this.issuedInvoices.add(invoiceinIssue);
			}
		} else {
			this.issuedInvoices.add(invoiceinIssue);
		}
	}
	
	public void addInvoice(int code,long documentNumber, ArrayList<ProductInvoice> products, Date generationDate,
			String typeTerm) {
		Client client= this.clientSearch(documentNumber);
		Invoice invoiceinIssue = new Invoice(code,client, products, generationDate, typeTerm);
		if (!this.issuedInvoices.isEmpty()) {
			Collections.sort(this.issuedInvoices);
			if (Collections.binarySearch(this.issuedInvoices, invoiceinIssue) < 0) {
				this.issuedInvoices.add(invoiceinIssue);
			}
		} else {
			this.issuedInvoices.add(invoiceinIssue);
		}
	}

	public void addInvoice(int code,long documentNumber, Date generationDate,
			String typeTerm) {
		Client client= this.clientSearch(documentNumber);
		Invoice invoiceinIssue = new Invoice(code,client, generationDate, typeTerm);
		if (!this.issuedInvoices.isEmpty()) {
			Collections.sort(this.issuedInvoices);
			if (Collections.binarySearch(this.issuedInvoices, invoiceinIssue) < 0) {
				this.issuedInvoices.add(invoiceinIssue);
			}
		} else {
			this.issuedInvoices.add(invoiceinIssue);
		}
	}
	
	public void addInvoice(Invoice invoiceinIssue) {
		if (!this.issuedInvoices.isEmpty()) {
			Collections.sort(this.issuedInvoices);
			if (Collections.binarySearch(this.issuedInvoices, invoiceinIssue) < 0) {
				this.issuedInvoices.add(invoiceinIssue);
			}
		} else {
			this.issuedInvoices.add(invoiceinIssue);
		}
	}

	public void deleteInvoice(int code) {
		Collections.sort(this.issuedInvoices);
		int index = Collections.binarySearch(this.issuedInvoices, new Invoice(code, null, null, null, null));
		if (index >= 0) {
			this.issuedInvoices.remove(index);
		}
	}

	public void addinvoiceProduct(Invoice invoiceinIssue, ProductStock target, int quantity) {
		if (this.stockReviewer(target, quantity)) {
			int actualQuantity = invoiceinIssue.getProducts().size();
			invoiceinIssue.addinvoiceProduct(new ProductInvoice(target.getName(), target.getCode(), target.getTax(),
					target.getPriceSale(), quantity));
			if(invoiceinIssue.getProducts().size()>actualQuantity) {
				target.setQuantity(target.getQuantity() - quantity);
			}
		}
	}
	
	public Invoice searchInvoice(int code) {
		Invoice invoiceinIssue = new Invoice(code, null, null, null, null);
		Collections.sort(this.issuedInvoices);
		int position = Collections.binarySearch(this.issuedInvoices, invoiceinIssue);
		if(position>= 0) {
			return this.issuedInvoices.get(position);
		}
		return null;
	}

	public void deleteInvoiceProduct(Invoice invoiceinIssue, int code) {
		invoiceinIssue.deleteProduct(code);
	}

	public void deleteInvoiceProduct(Invoice invoiceIssue, ProductInvoice product) {
		invoiceIssue.deleteInvoiceProduct(product);
	}

	public boolean stockReviewer(ProductStock reviewProduct, int quantity) {
		return reviewProduct.getQuantity() >= quantity;
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
