package view.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.Invoice;
import model.ProductInvoice;
import persistence.JsonReaderWriter;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.ImagePathConstants;
import view.constants.TextConstants;
import view.utilities.BasePanel;
import view.utilities.ButtonRenderer;
import view.utilities.CustomTableStyle;
import view.utilities.JComponentsUtilities;

public class InvoicePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable invoiceTable; 
	private JButton createButton; 
	private JButton deleteButton;
	
	public InvoicePanel() {
        this.setBackground(Color.WHITE);
        this.initComponents();
    	this.setupListeners();
    }

 
	public void initComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		createButton = new JButton();
		BasePanel panel = new BasePanel(TextConstants.INVOICES_TEXT, TextConstants.CREATE_INVOICE_BUTTON_TEXT, createButton);
		panel.setMaximumSize(new Dimension(1100, 180));
		this.add(panel);
		
		JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
		separador.setMaximumSize(new Dimension(1100, 25));
		separador.setForeground(Color.DARK_GRAY);
		this.add(separador);
		
		deleteButton = new JButton();
        JComponentsUtilities.buttonPlusOnlyImage(deleteButton, ImagePathConstants.DELETE_ICON_URL, 25, 25);
        
		String[] columnas = {TextConstants.CODE_TEXT, "Cliente", "Fecha", "Plazo", "Total", "Acciones"};
	    Object[][] datos = {};

	    DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
	    invoiceTable = new JTable(modelo);
	    CustomTableStyle.customizeTable(invoiceTable, ColorConstants.PURPLE, Color.WHITE, Color.WHITE, Color.BLACK,
	            FontConstants.PUCK_BOLD_BOLD_FONT_18, FontConstants.PUCK_BOLD_PLAIN_FONT_14, 10, 40);
	    
	    ButtonRenderer buttonRenderer = new ButtonRenderer();
	    invoiceTable.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);

	    JScrollPane scrollPane = new JScrollPane(invoiceTable);
	    scrollPane.setMaximumSize(new Dimension(1100, 400));
	    this.add(scrollPane);

	    // Load invoices from JSON
	    loadInvoicesFromJson();
		
	}

	public JButton getCreateButton() {
		return createButton;
	}
	
	private void setupListeners() {
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCreationClientPanel();
			}
		});
	}

	private void openCreationClientPanel() {
		CreationInvoicePanel creationInvoicePanel = new CreationInvoicePanel();

		JFrame frame = new JFrame(TextConstants.CREATE_PRODUCT_BUTTON_TEXT);
		frame.setPreferredSize(new Dimension(1000, 680));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(creationInvoicePanel);

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
	        	Object[] row = new Object[6];
                row[0] = invoice.getCode();
                row[1] = invoice.getClient().getReasonSocial();
                row[2] = invoice.getGenerationDate();
                row[3] = invoice.getTypeTerm();
                row[4] = calculateTotal(invoice);
                row[5] = deleteButton;
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
