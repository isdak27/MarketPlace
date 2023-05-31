package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Client;
import model.Invoice;
import model.Market;
import model.ProductStock;
import persistence.JsonReaderWriter;
import view.PrincipalFrame;

public class AppController implements ActionListener {

	private PrincipalFrame frontend;
	private Market backend;

	public AppController() {
		ArrayList<Client> clients = JsonReaderWriter.readClientsFromJson();
		ArrayList<ProductStock> products = JsonReaderWriter.readProductsFromJson();
		ArrayList<Invoice> invoices = JsonReaderWriter.readInvoicesFromJson();
		backend = new Market(products, clients, invoices);
		frontend = new PrincipalFrame(this, backend.getUsers(), backend.getStock(), backend.getIssuedInvoices());
	}

	public PrincipalFrame getFrontend() {
		return frontend;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commads.valueOf(e.getActionCommand())) {
		case C_ADD_CLIENT:
			frontend.openCreationClientPanel();
			break;
		case C_ADD_INVOICE:
			frontend.openCreationInvoicePanel();
			break;
		case C_ADD_PRODUCT:
			frontend.openCreationProductPanel();
			break;
		case C_ADD_PRODUCT_INVOICE:
			break;
		case C_DELETE_CLIENT:
			frontend.openDeleteClientPanel();
			break;
		case C_DELETE_CLIENT_ACTION:
			backend.deleteClient(frontend.getDeleteActionCode());
			JsonReaderWriter.writeClientsToJson(backend.getUsers());
			frontend.updateTable(backend.getUsers());
			break;
		case C_DELETE_INVOICE:
			frontend.openDeleteInvoicePanel();
			break;
		case C_DELETE_INVOICE_ACTION:
			backend.deleteInvoice(frontend.getDeleteActionCodeInvoice());
			JsonReaderWriter.writeInvoicesToJson(backend.getIssuedInvoices());
			frontend.updateTableInvoice(backend.getIssuedInvoices());
			break;
		case C_DELETE_PRODUCT:
			frontend.openDeleteProductPanel();
			break;
		case C_DELETE_PRODUCT_ACTION:
			backend.deleteProduct(frontend.getDeleteActionCodeProduct());
			JsonReaderWriter.writeProductsToJson(backend.getStock());
			frontend.updateTableProducts(backend.getStock());
			break;
		case C_SAVE_CLIENT:
			backend.addClient(frontend.clientDataReceptor());
			JsonReaderWriter.writeClientsToJson(backend.getUsers());
			frontend.updateTable(backend.getUsers());
			break;
		case C_SAVE_INVOICE:
//			backend.add(frontend.clientDataReceptor());
//			frontend.updateTable(backend.getUsers());
//			JsonReaderWriter.writeClientsToJson(backend.getUsers());
			break;
		case C_SAVE_PRODUCT:
			backend.addProduct(frontend.productDataReceptor());
			frontend.updateTableProducts(backend.getStock());
			JsonReaderWriter.writeProductsToJson(backend.getStock());
			break;
		default:
			break;

		}

	}

	public static void main(String[] args) {
		new AppController();
	}

}
