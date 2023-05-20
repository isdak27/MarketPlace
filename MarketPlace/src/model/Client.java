package model;

public class Client {
	private String documentType;
	private int documentNumber;
	private String reasonSocial;
	private String addres;
	private String phone;
	
	public Client(String documentType, int documentNumber, String reasonSocial, String addres, String phone) {
		super();
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.reasonSocial = reasonSocial;
		this.addres = addres;
		this.phone = phone;
	}

	public String getDocumentType() {
		return documentType;
	}

	public int getDocumentNumber() {
		return documentNumber;
	}

	public String getReasonSocial() {
		return reasonSocial;
	}

	public String getAddres() {
		return addres;
	}

	public String getPhone() {
		return phone;
	}

}
