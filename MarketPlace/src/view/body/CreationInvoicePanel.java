package view.body;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Commads;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.TextConstants;
import view.utilities.RoundedButton;
import view.utilities.RoundedJTextField;

public class CreationInvoicePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField client;
	private JTextField code;
	private JComboBox<String> term;
	private JTextField date;
	private JTextField product;
	private JButton save;
	private JButton addButton;

	public CreationInvoicePanel(ActionListener actionListener) {
		this.setBackground(ColorConstants.SOFT_PURPLE);
		this.initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		client = new RoundedJTextField();
		code = new RoundedJTextField();
		term = new JComboBox<String>();
		term.addItem(TextConstants.TERM_COUNTED_TEXT);
		term.addItem(TextConstants.TERM_CREDIT_TEXT);
		term.setBackground(Color.WHITE);
		term.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		date = new RoundedJTextField();
		product = new RoundedJTextField();
		save = new JButton();
		save.addActionListener(actionListener);
		save.setActionCommand(Commads.C_SAVE_INVOICE.toString());
		RoundedButton.makeRounded(save, TextConstants.SAVE_BUTTON_TEXT, 25, ColorConstants.PURPLE,
				ColorConstants.LIGHT_BROWN, Color.WHITE, FontConstants.PUCK_BOLD_BOLD_FONT_15, 200, 50);

		addButton = new JButton();
		addButton.addActionListener(actionListener);
		addButton.setActionCommand(Commads.C_ADD_PRODUCT_INVOICE.toString());
		RoundedButton.makeRounded(addButton, TextConstants.ADD_BUTTON_TEXT, 25, ColorConstants.PURPLE,
				ColorConstants.LIGHT_BROWN, Color.WHITE, FontConstants.PUCK_BOLD_BOLD_FONT_15, 100, 40);

		CreationInvoiceCardPanel creationInvoiceCardPanel = new CreationInvoiceCardPanel(
				TextConstants.CREATE_INVOICE_BUTTON_TEXT, client, TextConstants.CLIENT_TEXT, code,TextConstants.CODE_TEXT, term,
				TextConstants.TERM_TEXT, date, TextConstants.DATE_TEXT, product, TextConstants.PRODUCT_TEXT, addButton,
				save);

		this.add(creationInvoiceCardPanel);
	}
	
//	public Invoice invoiceDataReceptor() {
//		
//		return new Invoice(documentType, documentNumber, reasonSocial, addres, phone);
//	}
	
	
	
//	private void saveInvoice() {
//	    // Obtener los detalles de la factura del panel
//	    String invoiceCode = invoiceCodeField.getText();
//	    String clientDocumentNumber = clientDocumentNumberField.getText();
//
//	    // Verificar si existe el cliente
//	    Client client = findClientByDocumentNumber(clientDocumentNumber);
//	    if (client == null) {
//	        JOptionPane.showMessageDialog(this, "El cliente no existe.", "Error", JOptionPane.ERROR_MESSAGE);
//	        return;
//	    }
//
//	    // Crear la factura
//	    Invoice invoice = new Invoice(invoiceCode, client, new Date());
//
//	    // Agregar los productos a la factura
//	    for (ProductInvoicePanel productPanel : productInvoicePanels) {
//	        String productCode = productPanel.getProductCode();
//	        ProductStock product = findProductByCode(productCode);
//	        if (product != null) {
//	            int quantity = productPanel.getQuantity();
//	            ProductInvoice productInvoice = new ProductInvoice(product.getName(), product.getCode(), product.getTax(), product.getPriceSale(), quantity);
//	            invoice.addProduct(productInvoice);
//	        }
//	    }
//
//	    // Obtener las facturas existentes desde el archivo JSON
//	    List<Invoice> invoices = JsonReaderWriter.readInvoicesFromJson();
//	    if (invoices == null) {
//	        invoices = new ArrayList<>();
//	    }
//
//	    // Agregar la nueva factura a la lista
//	    invoices.add(invoice);
//
//	    // Guardar las facturas en el archivo JSON
//	    if (JsonReaderWriter.writeInvoicesToJson(invoices)) {
//	        JOptionPane.showMessageDialog(this, "La factura se ha guardado correctamente.", "Factura guardada", JOptionPane.INFORMATION_MESSAGE);
//	    } else {
//	        JOptionPane.showMessageDialog(this, "Error al guardar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
//	    }
//
//	    // Limpiar los campos del panel
//	    clearFields();
//	}
}
