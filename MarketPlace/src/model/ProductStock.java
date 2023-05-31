package model;

public class ProductStock implements Comparable<ProductStock> {
	private String name;
	private int code;
	private double tax;
	private double priceSale;
	private int quantity;

	public ProductStock(String name, int code, double tax, double priceSale) {
		super();
		this.name = name;
		this.code = code;
		this.tax = tax;
		this.priceSale = priceSale;
	}

	public ProductStock(String name, int code, double tax, double priceSale, int quantity) {
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

	protected void setTax(double tax) {
		this.tax = tax;
	}

	protected void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}

	protected void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(ProductStock other) {
		return Integer.compare(this.code, other.code);
	}

}
