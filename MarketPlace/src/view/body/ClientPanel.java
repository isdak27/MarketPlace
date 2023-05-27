package view.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.Client;
import persistence.JsonReaderWriter;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.ImagePathConstants;
import view.constants.TextConstants;
import view.utilities.BasePanel;
import view.utilities.ButtonRenderer;
import view.utilities.CustomTableStyle;
import view.utilities.JComponentsUtilities;

public class ClientPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable clientTable;
	private JButton createButton;
	private JButton deleteButton;

	public ClientPanel() {
		this.setBackground(Color.WHITE);
		this.initComponents();
		this.setupListeners();
	}

	public void initComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		createButton = new JButton();
		BasePanel panel = new BasePanel(TextConstants.CLIENTS_TEXT, TextConstants.CREATE_CUSTOMER_BUTTON_TEXT,
				createButton);
		panel.setMaximumSize(new Dimension(1100, 180));
		this.add(panel);

		JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
		separador.setMaximumSize(new Dimension(1100, 25));
		separador.setForeground(Color.DARK_GRAY);
		this.add(separador);

		deleteButton = new JButton();
		JComponentsUtilities.buttonPlusOnlyImage(deleteButton, ImagePathConstants.DELETE_ICON_URL, 25, 25);

		String[] columnas = { TextConstants.NAME_TEXT, TextConstants.TYPE_IDENTIFICATION_TEXT,
				TextConstants.NUMBER_IDENTIFICATION_TEXT, TextConstants.ADRESS_TEXT,
				TextConstants.CELL_PHONE_NUMBER_TEXT, TextConstants.ACTIONS_TEXT };
		Object[][] datos = {};

		DefaultTableModel model = new DefaultTableModel(datos, columnas);

		List<Client> clients = JsonReaderWriter.readClientsFromJson();
		if (clients != null) {
			for (Client client : clients) {
				Object[] row = new Object[6];
				row[0] = client.getReasonSocial();
				row[1] = client.getDocumentType();
				row[2] = client.getDocumentNumber();
				row[3] = client.getAddress();
				row[4] = client.getPhone();
				row[5] = deleteButton;
				model.addRow(row);
			}
		}
		clientTable = new JTable(model);
		CustomTableStyle.customizeTable(clientTable, ColorConstants.PURPLE, Color.WHITE, Color.WHITE, Color.BLACK,
				FontConstants.PUCK_BOLD_BOLD_FONT_18, FontConstants.PUCK_BOLD_PLAIN_FONT_14, 10, 40);

		ButtonRenderer buttonRenderer = new ButtonRenderer();
		clientTable.getColumnModel().getColumn(5).setCellRenderer(buttonRenderer);

		JScrollPane scrollPane = new JScrollPane(clientTable);
		scrollPane.setMaximumSize(new Dimension(1100, 400));
		this.add(scrollPane);
	}

	private void setupListeners() {
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCreationClientPanel();
			}
		});
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción que deseas realizar al hacer clic en el botón de eliminar
			}
		});
	}

	private void openCreationClientPanel() {
		CreationClientPanel creationClientPanel = new CreationClientPanel(this);

		JFrame frame = new JFrame(TextConstants.CREATE_CUSTOMER_BUTTON_TEXT);
		frame.setPreferredSize(new Dimension(900, 460));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(creationClientPanel);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width - getWidth()) * 2;
		int y = (screenSize.height - getHeight());

		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}

	public void updateTable() {
		List<Client> clients = JsonReaderWriter.readClientsFromJson();
		DefaultTableModel model = (DefaultTableModel) clientTable.getModel();
		model.setRowCount(0);
		for (Client client : clients) {
			Object[] row = new Object[6];
			row[0] = client.getReasonSocial();
			row[1] = client.getDocumentType();
			row[2] = client.getDocumentNumber();
			row[3] = client.getAddress();
			row[4] = client.getPhone();
			row[5] = deleteButton;
			model.addRow(row);
		}
		clientTable.repaint();
	}

}
