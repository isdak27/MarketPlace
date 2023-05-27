package view.body;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.ImagePathConstants;
import view.constants.TextConstants;
import view.utilities.JComponentsUtilities;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton invoicesButton;
	private JButton clientsButton;
	private JButton stockButton;

	public MenuPanel() {
		this.setBackground(ColorConstants.DARK_PURPLE);
		this.initComponents();
	}

	public void initComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel empty = new JLabel("    ");
		this.add(empty);

		invoicesButton = new JButton();
		JComponentsUtilities.buttonPlusImageText(invoicesButton, ImagePathConstants.INVOICES_ICON_URL,
				ColorConstants.PURPLE, TextConstants.INVOICES_TEXT, 30, 30, 160, 100, Color.WHITE,
				FontConstants.PUCK_BOLD_BOLD_FONT_16);
		this.add(invoicesButton);

		clientsButton = new JButton();
		JComponentsUtilities.buttonPlusImageText(clientsButton, ImagePathConstants.CLIENTS_ICON_URL,
				ColorConstants.PURPLE, TextConstants.CLIENTS_TEXT, 30, 30, 160, 100, Color.WHITE,
				FontConstants.PUCK_BOLD_BOLD_FONT_16);
		this.add(clientsButton);

		stockButton = new JButton();
		JComponentsUtilities.buttonPlusImageText(stockButton, ImagePathConstants.STOCK_ICON_URL, ColorConstants.PURPLE,
				TextConstants.STOCK_TEXT, 30, 30, 160, 100, Color.WHITE, FontConstants.PUCK_BOLD_BOLD_FONT_16);
		this.add(stockButton);

	}
	

    public JButton getInvoiceButton() {
        return invoicesButton;
    }

    public JButton getClientButton() {
        return clientsButton;
    }

    public JButton getStockButton() {
        return stockButton;
    }

}
