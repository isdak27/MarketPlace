package model;

public class Client implements Comparable<Client>{
	private String documentType;
	private long documentNumber;
	private String reasonSocial;
	private String address;
	private String phone;

	public Client(String documentType, long documentNumber, String reasonSocial, 
			String addres, String phone) {
		super();
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.reasonSocial = reasonSocial;
		this.address = addres;
		this.phone = phone;
	}

	public String getDocumentType() {
		return documentType;
	}

	public long getDocumentNumber() {
		return documentNumber;
	}

	public String getReasonSocial() {
		return reasonSocial;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public int compareTo(Client other) {
		return Long.compare(this.documentNumber, other.documentNumber);
	}

}
