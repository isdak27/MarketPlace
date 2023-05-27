package view.body;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Client;
import model.Invoice;
import model.ProductStock;
import view.constants.TextConstants;

public class BodyPanel extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuPanel menuPanel;
	private JPanel centralPanel;
	private InvoicePanel invoicePanel;
	private ClientPanel clientPanel;
	private StockPanel stockPanel;

	public BodyPanel(ActionListener actionListener, ArrayList<Client> clients, ArrayList<ProductStock> products, ArrayList<Invoice> invoices) {
		this.initComponents(actionListener, clients, products, invoices);
	}

	public void initComponents(ActionListener actionListener, ArrayList<Client> clients,
			ArrayList<ProductStock> products, ArrayList<Invoice> invoices) {
		this.setLayout(new BorderLayout());

		menuPanel = new MenuPanel();
		this.add(menuPanel, BorderLayout.WEST);

		centralPanel = new JPanel(new CardLayout());

		invoicePanel = new InvoicePanel(actionListener, invoices);
		centralPanel.add(invoicePanel, TextConstants.INVOICE_PANEL_ID);

		clientPanel = new ClientPanel(actionListener, clients);
		centralPanel.add(clientPanel, TextConstants.CLIENT_PANEL_ID);

		stockPanel = new StockPanel(actionListener, products);
		centralPanel.add(stockPanel, TextConstants.STOCK_PANEL_ID);

		this.add(centralPanel, BorderLayout.CENTER);

		menuPanel.getInvoiceButton().addActionListener(this);
		menuPanel.getClientButton().addActionListener(this);
		menuPanel.getStockButton().addActionListener(this);

	}

	public Client clientDataReceptor() {
		return clientPanel.clientDataReceptor();
	}

	public void openCreationClientPanel() {
		clientPanel.openCreationClientPanel();
	}

	public void openDeleteClientPanel() {
		clientPanel.openDeleteClientPanel();
	}

	public void updateTableClients(ArrayList<Client> clients) {
		clientPanel.updateTable(clients);
	}

	public long getDeleteActionCode() {
		return clientPanel.getDeleteActionCode();
	}

	public ProductStock productDataReceptor() {
		return stockPanel.productDataReceptor();
	}

	public void openCreationProductPanel() {
		stockPanel.openCreationProductPanel();
	}

	public void openDeleteProductPanel() {
		stockPanel.openDeleteProductPanel();
	}

	public void updateTableProducts(ArrayList<ProductStock> products) {
		stockPanel.updateTable(products);
	}

	public int getDeleteActionCodeProduct() {
		return stockPanel.getDeleteActionCode();
	}

	
//	public Invoice invoiceDataReceptor() {
//		return invoicePanel.invoiceDataReceptor();
//	}

	public void openCreationInvoicePanel() {
		invoicePanel.openCreationInvoicePanel();
	}

	public void openDeleteInvoicePanel() {
		invoicePanel.openDeleteInvoicePanel();
	}

	public void updateTableInvoice(ArrayList<Invoice> invoices) {
		invoicePanel.updateTable(invoices);
	}

	public int getDeleteActionCodeInvoice() {
		return invoicePanel.getDeleteActionCode();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuPanel.getInvoiceButton()) {
			CardLayout layout = (CardLayout) centralPanel.getLayout();
			layout.show(centralPanel, TextConstants.INVOICE_PANEL_ID);
		} else if (e.getSource() == menuPanel.getClientButton()) {
			CardLayout layout = (CardLayout) centralPanel.getLayout();
			layout.show(centralPanel, TextConstants.CLIENT_PANEL_ID);
		} else if (e.getSource() == menuPanel.getStockButton()) {
			CardLayout layout = (CardLayout) centralPanel.getLayout();
			layout.show(centralPanel, TextConstants.STOCK_PANEL_ID);
		}

	}
}
