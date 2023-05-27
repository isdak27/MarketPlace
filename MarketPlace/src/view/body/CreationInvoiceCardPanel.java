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

public class CreationInvoiceCardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel title;
	private CreationDataInvoiceCardPanel creationDataInvoiceCardPanel;
	private JButton saveInfo;

	public CreationInvoiceCardPanel(String titleText, JTextField client, String clientText, JComboBox<String> term, String termText,
			JTextField date, String dateText, JTextField product, String productText, JButton addButton, JButton save) {
		this.setBackground(ColorConstants.SOFT_PURPLE);
		RoundedPanel roundedPanel = new RoundedPanel(ColorConstants.LIGHT_BROWN, 30);
		roundedPanel.setPreferredSize(new Dimension(900, 600));
		roundedPanel.setLayout(new BorderLayout());

		title = new JLabel(titleText);
		title.setFont(FontConstants.PUCK_BOLD_BOLD_FONT_26);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBorder(new EmptyBorder(20, 0, 0, 0));
		roundedPanel.add(this.title, BorderLayout.NORTH);

		creationDataInvoiceCardPanel = new CreationDataInvoiceCardPanel(client, clientText, term, termText, date, dateText, product,
				productText, addButton);
		roundedPanel.add(creationDataInvoiceCardPanel, BorderLayout.CENTER);

		this.saveInfo = save;
		roundedPanel.add(saveInfo, BorderLayout.SOUTH);
		this.add(roundedPanel);
	}
}
