package view.body;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.utilities.CustomTableStyle;

public class CreationDataInvoiceCardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreationDataInvoiceCardPanel(JTextField client, String clientText, JComboBox<String> term, String termText,
			JTextField date, String dateText, JTextField product, String productText, JButton addButton) {
		this.setBackground(ColorConstants.LIGHT_BROWN);
		this.setBorder(new EmptyBorder(50, 10, 50, 10));
		this.setLayout(new BorderLayout());

		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new GridLayout(4, 3));
		dataPanel.setBackground(ColorConstants.LIGHT_BROWN);

		JLabel clientDescription = new JLabel(clientText);
		clientDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel termDescription = new JLabel(termText);
		termDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel dateDescription = new JLabel(dateText);
		dateDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel productDescription = new JLabel(productText);
		productDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel empty = new JLabel(" ");
		JLabel empty2 = new JLabel(" ");
		dataPanel.add(clientDescription);
		dataPanel.add(termDescription);
		dataPanel.add(dateDescription);
		dataPanel.add(client);
		dataPanel.add(term);
		dataPanel.add(date);
		dataPanel.add(productDescription);
		dataPanel.add(empty);
		dataPanel.add(empty2);
		dataPanel.add(product);
		dataPanel.add(addButton);

		String[] columnas = { "Nombre", "Impuesto", "Precio", "Cantidad" };
		Object[][] datos = { { "Juan", "Pérez", 30 }, { "María", "Gómez", 25 }, { "Pedro", "López", 40 },
				{ "María", "Gómez", 25 }};

		DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
		JTable productTable = new JTable(modelo);
		CustomTableStyle.customizeTable(productTable, ColorConstants.PURPLE, Color.WHITE, Color.WHITE, Color.BLACK,
				FontConstants.PUCK_BOLD_BOLD_FONT_18, FontConstants.PUCK_BOLD_PLAIN_FONT_14, 10, 40);
		JScrollPane scrollPane = new JScrollPane(productTable);
		scrollPane.setPreferredSize(new Dimension(900, 220));

		this.add(dataPanel, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.SOUTH);

	}

}
