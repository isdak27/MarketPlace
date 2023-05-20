package model;

public class Product implements Comparable<Product>{
	private String name;
	private int code;
	private double tax;
	private double priceSale;
	private int quantity;
	
	public Product(String name, int code, double tax, double priceSale) {
		super();
		this.name = name;
		this.code = code;
		this.tax = tax;
		this.priceSale = priceSale;
	}

	public Product(String name, int code, double tax, double priceSale, int quantity) {
		super();
		this.name = name;
		this.code = code;
		this.tax = tax;
		this.priceSale = priceSale;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	public double getTax() {
		return tax;
	}

	public double getPriceSale() {
		return priceSale;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int compareTo(Product other) {
		return Integer.compare(this.code, other.code);
	}
	
}
