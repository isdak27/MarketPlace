package view.body;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.TextConstants;
import view.utilities.CustomTableStyle;

public class CreationDataInvoiceCardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreationDataInvoiceCardPanel(JTextField client, String clientText, JTextField code, String codeText, JComboBox<String> term, String termText,
			JTextField date, String dateText, JTextField product, String productText, JButton addButton) {
		this.setBackground(ColorConstants.LIGHT_BROWN);
		this.setBorder(new EmptyBorder(50, 10, 50, 10));
		this.setLayout(new BorderLayout());

		JLabel clientDescription = new JLabel(clientText);
		clientDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel codeDescription = new JLabel(codeText);
		codeDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel termDescription = new JLabel(termText);
		termDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel dateDescription = new JLabel(dateText);
		dateDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel productDescription = new JLabel(productText);
		productDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel empty = new JLabel(" ");
		JLabel empty2 = new JLabel(" ");

		JPanel basicData = new JPanel();
		basicData.setBackground(ColorConstants.LIGHT_BROWN);
		basicData.setLayout(new GridLayout(2, 4));
		basicData.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
		basicData.add(clientDescription);
		basicData.add(codeDescription);
		basicData.add(termDescription);
		basicData.add(dateDescription);
		basicData.add(client);
		basicData.add(code);
		basicData.add(term);
		basicData.add(date);

		JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
		separador.setPreferredSize(new Dimension(this.getWidth(), 40));
		separador.setForeground(Color.DARK_GRAY);

		JPanel productsData = new JPanel();
		productsData.setLayout(new BorderLayout());
		productsData.setBackground(ColorConstants.LIGHT_BROWN);

		JPanel productsBasicData = new JPanel();
		productsBasicData.setLayout(new GridLayout(2, 2));
		productsBasicData.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		productsBasicData.setBackground(ColorConstants.LIGHT_BROWN);

		productsBasicData.add(productDescription);
		productsBasicData.add(empty);
		productsBasicData.add(empty2);
		productsBasicData.add(product);
		productsBasicData.add(addButton);

		String[] columnas = { TextConstants.PRODUCT_TEXT, TextConstants.TAX_TEXT, TextConstants.PRICE_TEXT,
				TextConstants.UNITS_TEXT };
		Object[][] datos = {};

		DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
		JTable productTable = new JTable(modelo);
		CustomTableStyle.customizeTable(productTable, ColorConstants.PURPLE, Color.WHITE, Color.WHITE, Color.BLACK,
				FontConstants.PUCK_BOLD_BOLD_FONT_18, FontConstants.PUCK_BOLD_PLAIN_FONT_14, 10, 40);
		JScrollPane scrollPane = new JScrollPane(productTable);
		scrollPane.setPreferredSize(new Dimension(900, 250));

		JLabel addProductTitle = new JLabel(TextConstants.ADD_PRODUCTS_TEXT);
		addProductTitle.setFont(FontConstants.PUCK_BOLD_BOLD_FONT_20);
		addProductTitle.setHorizontalAlignment(SwingConstants.CENTER);
		productsData.add(addProductTitle, BorderLayout.NORTH);
		productsData.add(productsBasicData, BorderLayout.CENTER);
		productsData.add(scrollPane, BorderLayout.SOUTH);

		this.add(basicData, BorderLayout.NORTH);
		this.add(separador, BorderLayout.CENTER);
		this.add(productsData, BorderLayout.SOUTH);

	}

}
