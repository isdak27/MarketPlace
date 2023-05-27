package view.body;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Commads;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.TextConstants;
import view.utilities.RoundedButton;
import view.utilities.RoundedJTextField;

public class DeleteClientPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField identification;
	private JButton deleteButton;

	public DeleteClientPanel(ActionListener actionListener) {
		
		this.setBackground(ColorConstants.SOFT_PURPLE);
		identification = new RoundedJTextField();
		deleteButton = new JButton();
		deleteButton.addActionListener(actionListener);
		deleteButton.setActionCommand(Commads.C_DELETE_CLIENT_ACTION.toString());
		RoundedButton.makeRounded(deleteButton, TextConstants.DELETE_BUTTON_TEXT, 25, ColorConstants.DARK_RED,
				ColorConstants.LIGHT_BROWN, Color.WHITE, FontConstants.PUCK_BOLD_BOLD_FONT_15, 200, 50);

		DeleteCardPanel deleteCardPanel = new DeleteCardPanel(TextConstants.DELETE_CUSTOMER_BUTTON_TEXT,
				TextConstants.NUMBER_IDENTIFICATION_TEXT, identification, deleteButton);
		this.add(deleteCardPanel);
	}

	public long getIdentification() {
		return  Long.valueOf(identification.getText());
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}
	
	

}
