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
import model.ProductStock;
import persistence.JsonReaderWriter;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.TextConstants;
import view.utilities.BasePanel;
import view.utilities.CustomTableStyle;

public class StockPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable stockTable;
	private JButton createButton;
	private JButton deleteButton;

	public StockPanel(ActionListener actionListener) {
		this.setBackground(Color.WHITE);
		this.initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		createButton = new JButton();
		createButton.addActionListener(actionListener);
		createButton.setActionCommand(Commads.C_ADD_PRODUCT.toString());
		deleteButton = new JButton();
		deleteButton.addActionListener(actionListener);
		deleteButton.setActionCommand(Commads.C_DELETE_PRODUCT.toString());
		BasePanel panel = new BasePanel(TextConstants.STOCK_TEXT, TextConstants.CREATE_PRODUCT_BUTTON_TEXT,
				createButton, TextConstants.DELETE_PRODUCT_BUTTON_TEXT, deleteButton);
		panel.setMaximumSize(new Dimension(1100, 180));
		panel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		this.add(panel);

		String[] columnas = { TextConstants.PRODUCT_TEXT, TextConstants.CODE_TEXT, TextConstants.TAX_TEXT,
				TextConstants.PRICE_TEXT, TextConstants.UNITS_TEXT };
		Object[][] datos = {};

		DefaultTableModel model = new DefaultTableModel(datos, columnas);

		List<ProductStock> products = JsonReaderWriter.readProductsFromJson();
		if (products != null) {
			for (ProductStock product : products) {
				Object[] row = new Object[5];
				row[0] = product.getName();
				row[1] = product.getCode();
				row[2] = product.getTax();
				row[3] = product.getPriceSale();
				row[4] = product.getQuantity();
				model.addRow(row);
			}

			stockTable = new JTable(model);
			CustomTableStyle.customizeTable(stockTable, ColorConstants.PURPLE, Color.WHITE, Color.WHITE, Color.BLACK,
					FontConstants.PUCK_BOLD_BOLD_FONT_18, FontConstants.PUCK_BOLD_PLAIN_FONT_14, 10, 40);

			JScrollPane scrollPane = new JScrollPane(stockTable);
			scrollPane.setMaximumSize(new Dimension(1100, 500));
			this.add(scrollPane);
		}

	}

	private void openCreationProductPanel(ActionListener actionListener) {
		CreationProductPanel creationProductPanel = new CreationProductPanel(this,actionListener);

		JFrame frame = new JFrame(TextConstants.CREATE_PRODUCT_BUTTON_TEXT);
		frame.setPreferredSize(new Dimension(900, 460));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(creationProductPanel);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width - getWidth()) * 2;
		int y = (screenSize.height - getHeight());

		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}
	
	private void openDeleteProductPanel() {
		DeleteProductPanel seleteProductPanel = new DeleteProductPanel();

		JFrame frame = new JFrame(TextConstants.CREATE_CUSTOMER_BUTTON_TEXT);
		frame.setPreferredSize(new Dimension(450, 265));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(seleteProductPanel);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width - getWidth()) * 2;
		int y = (screenSize.height - getHeight());

		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}

	public void updateTable() {
		List<ProductStock> products = JsonReaderWriter.readProductsFromJson();
		DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
		model.setRowCount(0);
		for (ProductStock product : products) {
			Object[] row = new Object[6];
			row[0] = product.getName();
			row[1] = product.getCode();
			row[2] = product.getTax();
			row[3] = product.getPriceSale();
			row[4] = product.getQuantity();
			row[5] = deleteButton;
			model.addRow(row);
		}
		stockTable.repaint();
	}

}
