package view.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Commads;
import model.Invoice;
import model.ProductInvoice;
import persistence.JsonReaderWriter;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.TextConstants;
import view.utilities.BasePanel;
import view.utilities.CustomTableStyle;

public class InvoicePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable invoiceTable;
	private JButton createButton;
	private JButton deleteButton;

	public InvoicePanel(ActionListener actionListener) {
		this.setBackground(Color.WHITE);
		this.initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		createButton = new JButton();
		createButton.addActionListener(actionListener);
		createButton.setActionCommand(Commads.C_ADD_INVOICE.toString());
		deleteButton = new JButton();
		deleteButton.addActionListener(actionListener);
		deleteButton.setActionCommand(Commads.C_DELETE_INVOICE.toString());
		BasePanel panel = new BasePanel(TextConstants.INVOICES_TEXT, TextConstants.CREATE_INVOICE_BUTTON_TEXT,
				createButton, TextConstants.DELETE_INVOICE_BUTTON_TEXT, deleteButton);
		panel.setMaximumSize(new Dimension(1100, 180));
		panel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		this.add(panel);

		String[] columnas = { TextConstants.CODE_TEXT, TextConstants.CLIENT_TEXT, TextConstants.DATE_TEXT,
				TextConstants.TERM_TEXT, TextConstants.TOTAL_TEXT };
		Object[][] datos = {};

		DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
		invoiceTable = new JTable(modelo);
		CustomTableStyle.customizeTable(invoiceTable, ColorConstants.PURPLE, Color.WHITE, Color.WHITE, Color.BLACK,
				FontConstants.PUCK_BOLD_BOLD_FONT_18, FontConstants.PUCK_BOLD_PLAIN_FONT_14, 10, 40);

		JScrollPane scrollPane = new JScrollPane(invoiceTable);
		scrollPane.setMaximumSize(new Dimension(1100, 500));
		this.add(scrollPane);

		loadInvoicesFromJson();

	}

	public JButton getCreateButton() {
		return createButton;
	}

	private void openCreationInvoicePanel(ActionListener actionListener) {
		CreationInvoicePanel creationInvoicePanel = new CreationInvoicePanel(this,actionListener);

		JFrame frame = new JFrame(TextConstants.CREATE_PRODUCT_BUTTON_TEXT);
		frame.setPreferredSize(new Dimension(1000, 750));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(creationInvoicePanel);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width - getWidth()) * 2;
		int y = (screenSize.height - getHeight() - 100);

		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void openDeleteInvoicePanel() {
		DeleteInvoicePanel deleteInvoicePanel = new DeleteInvoicePanel();

		JFrame frame = new JFrame(TextConstants.CREATE_CUSTOMER_BUTTON_TEXT);
		frame.setPreferredSize(new Dimension(450, 265));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(deleteInvoicePanel);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width - getWidth()) * 2;
		int y = (screenSize.height - getHeight());

		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void loadInvoicesFromJson() {
		List<Invoice> invoices = JsonReaderWriter.readInvoicesFromJson();
		if (invoices != null) {
			DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
			for (Invoice invoice : invoices) {
				Object[] row = new Object[5];
				row[0] = invoice.getCode();
				row[1] = invoice.getClient().getReasonSocial();
				row[2] = invoice.getGenerationDate();
				row[3] = invoice.getTypeTerm();
				row[4] = calculateTotal(invoice);
				model.addRow(row);
			}
		}
	}

	private double calculateTotal(Invoice invoice) {
		double total = 0.0;
		for (ProductInvoice product : invoice.getProducts()) {
			total += product.getPriceSale() * product.getQuantity();
		}
		return total;
	}

}
