package view.utilities;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.constants.ColorConstants;
import view.constants.FontConstants;

public class BasePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JButton createButton;

	public BasePanel(String labelText, String buttonText, JButton createButton) {
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		title = new JLabel(labelText);
		title.setFont(FontConstants.PUCK_BOLD_BOLD_FONT_26);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(0, 0, 10, 0);
		this.add(title, gbc);

		this.createButton = createButton;
		RoundedButton.makeRounded(this.createButton, buttonText, 25, ColorConstants.PURPLE, Color.WHITE, Color.WHITE,
				FontConstants.PUCK_BOLD_BOLD_FONT_15, 170, 50);
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.insets = new Insets(0, 0, 0, 0);
		this.add(this.createButton, gbc);
	}
}
