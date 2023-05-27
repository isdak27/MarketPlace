package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonWriter;

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
		frontend = new PrincipalFrame( this,backend.getUsers(), backend.getStock());
	}

	public PrincipalFrame getFrontend() {
		return frontend;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commads
				.valueOf(e.getActionCommand())) {
		case C_ADD_CLIENT:
			frontend.openCreationClientPanel();
			break;
		case C_ADD_INVOICE:
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
			frontend.updateTable(backend.getUsers());
			JsonReaderWriter.writeClientsToJson(backend.getUsers());
			break;
		case C_DELETE_INVOICE:
			break;
		case C_DELETE_INVOICE_ACTION:
			break;
		case C_DELETE_PRODUCT:
			frontend.openDeleteProductPanel();
			break;
		case C_DELETE_PRODUCT_ACTION:
			backend.deleteProduct(frontend.getDeleteActionCodeProduct());
			frontend.updateTableProducts(backend.getStock());
			JsonReaderWriter.writeProductsToJson(backend.getStock());
			break;
		case C_SAVE_CLIENT:
			backend.addClient(frontend.clientDataReceptor());
			frontend.updateTable(backend.getUsers());
			JsonReaderWriter.writeClientsToJson(backend.getUsers());
			break;
		case C_SAVE_INVOICE:
			
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
