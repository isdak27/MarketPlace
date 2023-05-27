package model;

public class ProductInvoice implements Comparable<ProductInvoice> {
	private String name;
	private int code;
	private double tax;
	private double priceSale;
	private int quantity;

	public ProductInvoice(String name, int code, double tax, double priceSale, int quantity) {
		super();
		this.name = name;
		this.code = code;
		this.tax = tax;
		this.priceSale = priceSale;
		this.quantity = quantity;
	}

	protected String getName() {
		return name;
	}

	protected int getCode() {
		return code;
	}

	protected double getTax() {
		return tax;
	}

	public double getPriceSale() {
		return priceSale;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int compareTo(ProductInvoice other) {
		return Integer.compare(this.code, other.code);
	}
	
}
