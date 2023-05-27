package view.body;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.constants.ColorConstants;
import view.constants.FontConstants;

public class CreationDataCardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreationDataCardPanel(JTextField name, String nameText, JComboBox<String> type, String typeText,
			JTextField code, String codeText, JTextField data, String dataText, JTextField number, String numberText) {
		this.setBackground(ColorConstants.LIGHT_BROWN);
		this.setBorder(new EmptyBorder(50, 10, 50, 10));
		this.setLayout(new GridLayout(4, 3));

		JLabel nameDescription = new JLabel(nameText);
		nameDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel typeDescription = new JLabel(typeText);
		typeDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel codeDescription = new JLabel(codeText);
		codeDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel dataDescription = new JLabel(dataText);
		dataDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel numberDescription = new JLabel(numberText);
		numberDescription.setFont(FontConstants.PUCK_BOLD_PLAIN_FONT_16);
		JLabel empty = new JLabel(" ");

		this.add(nameDescription);
		this.add(typeDescription);
		this.add(codeDescription);
		this.add(name);
		this.add(type);
		this.add(code);
		this.add(dataDescription);
		this.add(numberDescription);
		this.add(empty);
		this.add(data);
		this.add(number);

	}

}
