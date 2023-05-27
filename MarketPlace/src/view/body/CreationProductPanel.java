package view.body;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import control.Commads;
import model.Client;
import model.ProductStock;
import persistence.JsonReaderWriter;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.TextConstants;
import view.utilities.RoundedButton;
import view.utilities.RoundedJTextField;

public class CreationProductPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField name;
	private JComboBox<String> tax;
	private JTextField priceSale;
	private JTextField code;
	private JTextField quantity;
	private JButton save;
	private StockPanel stockPanel;

	public CreationProductPanel(StockPanel stockPanel,ActionListener actionListener) {
		this.stockPanel = stockPanel;
		this.setBackground(ColorConstants.SOFT_PURPLE);
		this.initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		name = new RoundedJTextField();
		tax = new JComboBox<String>();
		tax.addItem(TextConstants.TAX_0_TEXT);
		tax.addItem(TextConstants.TAX_15_TEXT);
		tax.addItem(TextConstants.TAX_16_TEXT);
		tax.addItem(TextConstants.TAX_19_TEXT);
		tax.setBackground(Color.WHITE);
		tax.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		priceSale = new RoundedJTextField();
		code = new RoundedJTextField();
		quantity = new RoundedJTextField();
		save = new JButton();
		save.addActionListener(actionListener);
		save.setActionCommand(Commads.C_SAVE_PRODUCT.toString());
		RoundedButton.makeRounded(save, TextConstants.SAVE_BUTTON_TEXT, 25, ColorConstants.PURPLE,
				ColorConstants.LIGHT_BROWN, Color.WHITE, FontConstants.PUCK_BOLD_BOLD_FONT_15, 200, 50);

		CreationCardPanel creationCardPanel = new CreationCardPanel(TextConstants.CREATE_PRODUCT_BUTTON_TEXT, name,
				TextConstants.NAME_TEXT, tax, TextConstants.TAX_TEXT, priceSale, TextConstants.PRICE_TEXT, code,
				TextConstants.CODE_TEXT, quantity, TextConstants.UNITS_TEXT, save);

		this.add(creationCardPanel);
	}
	
	public ProductStock productDataReceptor() {
		String productName = name.getText();
		int productCode = Integer.parseInt(code.getText());
		String selectedTax = (String) tax.getSelectedItem();
		double taxValue = Double.parseDouble(selectedTax);
		double productPriceSale = Double.parseDouble(priceSale.getText());
		int productQuantity = Integer.parseInt(quantity.getText());

		return new ProductStock(productName, productCode, taxValue, productPriceSale, productQuantity);
	}
}
