package view.body;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.utilities.RoundedPanel;

public class CreationCardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel title;
	private CreationDataCardPanel creationDataCardPanel;
	private JButton saveInfo;

	public CreationCardPanel(String titleText, JTextField name, String nameText, JComboBox<String> type,
			String typeText, JTextField code, String codeText, JTextField data, String dataText, JTextField number,
			String numberText, JButton save) {
		this.setBackground(ColorConstants.SOFT_PURPLE);
		RoundedPanel roundedPanel = new RoundedPanel(ColorConstants.LIGHT_BROWN, 30);
		roundedPanel.setPreferredSize(new Dimension(700, 400));
		roundedPanel.setLayout(new BorderLayout());

		title = new JLabel(titleText);
		title.setFont(FontConstants.PUCK_BOLD_BOLD_FONT_26);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(new EmptyBorder(30, 0, 0, 0));
		roundedPanel.add(this.title, BorderLayout.NORTH);

		creationDataCardPanel = new CreationDataCardPanel(name, nameText, type, typeText, code, codeText, data,
				dataText, number, numberText);
		roundedPanel.add(creationDataCardPanel, BorderLayout.CENTER);

		this.saveInfo = save;
		roundedPanel.add(saveInfo, BorderLayout.SOUTH);
		this.add(roundedPanel);
	}
}
