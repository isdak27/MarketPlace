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

import model.ProductStock;
import persistence.JsonReaderWriter;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.ImagePathConstants;
import view.constants.TextConstants;
import view.utilities.BasePanel;
import view.utilities.ButtonRenderer;
import view.utilities.CustomTableStyle;
import view.utilities.JComponentsUtilities;

public class StockPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable stockTable;
	private JButton createButton;
	private JButton deleteButton;

	public StockPanel() {
		this.setBackground(Color.WHITE);
		this.initComponents();
		this.setupListeners();
	}

	public void initComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		createButton = new JButton();
		BasePanel panel = new BasePanel(TextConstants.STOCK_TEXT, TextConstants.CREATE_PRODUCT_BUTTON_TEXT,
				createButton);
		panel.setMaximumSize(new Dimension(1100, 180));
		this.add(panel);

		JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
		separador.setMaximumSize(new Dimension(1100, 25));
		separador.setForeground(Color.DARK_GRAY);
		this.add(separador);

		deleteButton = new JButton();
		JComponentsUtilities.buttonPlusOnlyImage(deleteButton, ImagePathConstants.DELETE_ICON_URL, 25, 25);

		String[] columnas = { TextConstants.NAME_TEXT, TextConstants.CODE_TEXT, TextConstants.TAX_TEXT,
				TextConstants.PRICE_TEXT, TextConstants.UNITS_TEXT, TextConstants.ACTIONS_TEXT };
		Object[][] datos = {};

		DefaultTableModel model = new DefaultTableModel(datos, columnas);

		List<ProductStock> products = JsonReaderWriter.readProductsFromJson();
		if (products != null) {
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

			stockTable = new JTable(model);
			CustomTableStyle.customizeTable(stockTable, ColorConstants.PURPLE, Color.WHITE, Color.WHITE, Color.BLACK,
					FontConstants.PUCK_BOLD_BOLD_FONT_18, FontConstants.PUCK_BOLD_PLAIN_FONT_14, 10, 40);

			ButtonRenderer buttonRenderer = new ButtonRenderer();
			stockTable.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);

			JScrollPane scrollPane = new JScrollPane(stockTable);
			scrollPane.setMaximumSize(new Dimension(1100, 400));
			this.add(scrollPane);
		}

	}

	private void setupListeners() {
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCreationProductPanel();
			}
		});
	}

	private void openCreationProductPanel() {
		CreationProductPanel creationProductPanel = new CreationProductPanel(this);

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
