package view.body;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Commads;
import model.Client;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.TextConstants;
import view.utilities.RoundedButton;
import view.utilities.RoundedJTextField;

public class CreationClientPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField name;
	private JComboBox<String> type;
	private JTextField identification;
	private JTextField address;
	private JTextField number;
	private JButton save;
	private ClientPanel clientPanel;

	public CreationClientPanel(ClientPanel clientPanel,ActionListener actionListener) {
		this.clientPanel = clientPanel;
		this.setBackground(ColorConstants.SOFT_PURPLE);
		this.initComponents(actionListener);
	}

	public void initComponents(ActionListener actionListener) {
		name = new RoundedJTextField();
		type = new JComboBox<String>();
		type.addItem(TextConstants.TYPE_IDENTIFICATION_TI_TEXT);
		type.addItem(TextConstants.TYPE_IDENTIFICATION_CC_TEXT);
		type.addItem(TextConstants.TYPE_IDENTIFICATION_NIT_TEXT);
		type.setBackground(Color.WHITE);
		type.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		identification = new RoundedJTextField();
		address = new RoundedJTextField();
		number = new RoundedJTextField();
		save = new JButton();
		save.addActionListener(actionListener);
		save.setActionCommand(Commads.C_SAVE_CLIENT.toString());
		RoundedButton.makeRounded(save, TextConstants.SAVE_BUTTON_TEXT, 25, ColorConstants.PURPLE,
				ColorConstants.LIGHT_BROWN, Color.WHITE, FontConstants.PUCK_BOLD_BOLD_FONT_15, 200, 50);

		CreationCardPanel creationCardPanel = new CreationCardPanel(TextConstants.CREATE_CUSTOMER_BUTTON_TEXT, name,
				TextConstants.NAME_TEXT, type, TextConstants.TYPE_IDENTIFICATION_TEXT, identification,
				TextConstants.NUMBER_IDENTIFICATION_TEXT, address, TextConstants.ADRESS_TEXT, number,
				TextConstants.CELL_PHONE_NUMBER_TEXT, save);

		this.add(creationCardPanel);
	}
	
	public Client clientDataReceptor() {
		String documentType = (String) type.getSelectedItem();
		String reasonSocial = name.getText();
		int documentNumber = Integer.parseInt(identification.getText());
		String addres = address.getText();
		String phone = number.getText();

		return new Client(documentType, documentNumber, reasonSocial, addres, phone);
	}

}
