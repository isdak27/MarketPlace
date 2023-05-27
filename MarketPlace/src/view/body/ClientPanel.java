package view.body;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import control.Commads;
import model.Client;
import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.TextConstants;
import view.utilities.BasePanel;
import view.utilities.CustomTableStyle;

public class ClientPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable clientTable;
	private JButton createButton;
	private JButton deleteButton;
	private CreationClientPanel creation;
	private DeleteClientPanel deleteClient;

	public ClientPanel(ActionListener actionListener,ArrayList<Client> clients) {
		this.setBackground(Color.WHITE);
		this.initComponents(actionListener,clients);
		creation= new CreationClientPanel(this,actionListener);
		deleteClient = new DeleteClientPanel(actionListener);
	}

	public void initComponents(ActionListener actionListener,List<Client> clients) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		createButton = new JButton();
		createButton.addActionListener(actionListener);
		createButton.setActionCommand(Commads.C_ADD_CLIENT.toString());
		deleteButton = new JButton();
		deleteButton.addActionListener(actionListener);
		deleteButton.setActionCommand(Commads.C_DELETE_CLIENT.toString());
		BasePanel panel = new BasePanel(TextConstants.CLIENTS_TEXT, TextConstants.CREATE_CUSTOMER_BUTTON_TEXT,
				createButton, TextConstants.DELETE_CUSTOMER_BUTTON_TEXT, deleteButton);
		panel.setMaximumSize(new Dimension(1100, 180));
		panel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		this.add(panel);

		String[] columnas = { TextConstants.NAME_TEXT, TextConstants.TYPE_IDENTIFICATION_TEXT,
				TextConstants.NUMBER_IDENTIFICATION_TEXT, TextConstants.ADRESS_TEXT,
				TextConstants.CELL_PHONE_NUMBER_TEXT };
		Object[][] datos = {};

		DefaultTableModel model = new DefaultTableModel(datos, columnas);
		
		if (clients != null) {
			for (Client client : clients) {
				Object[] row = new Object[5];
				row[0] = client.getReasonSocial();
				row[1] = client.getDocumentType();
				row[2] = client.getDocumentNumber();
				row[3] = client.getAddress();
				row[4] = client.getPhone();
				model.addRow(row);
			}
		}
		clientTable = new JTable(model);
		CustomTableStyle.customizeTable(clientTable, ColorConstants.PURPLE, Color.WHITE, Color.WHITE, Color.BLACK,
				FontConstants.PUCK_BOLD_BOLD_FONT_18, FontConstants.PUCK_BOLD_PLAIN_FONT_14, 10, 40);

		JScrollPane scrollPane = new JScrollPane(clientTable);
		scrollPane.setMaximumSize(new Dimension(1100, 500));
		this.add(scrollPane);
	}

	public void openCreationClientPanel() {
		JFrame frame = new JFrame(TextConstants.CREATE_CUSTOMER_BUTTON_TEXT);
		frame.setPreferredSize(new Dimension(900, 460));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(creation);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width - getWidth()) * 2;
		int y = (screenSize.height - getHeight());

		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void openDeleteClientPanel() {
		JFrame frame = new JFrame(TextConstants.CREATE_CUSTOMER_BUTTON_TEXT);
		frame.setPreferredSize(new Dimension(450, 265));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(deleteClient);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (screenSize.width - getWidth()) * 2;
		int y = (screenSize.height - getHeight());

		frame.setLocation(x, y);
		frame.pack();
		frame.setVisible(true);
	}

	public void updateTable(ArrayList<Client> clients) {
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
		SwingUtilities.getWindowAncestor(creation).dispose();
	}

	public long getDeleteActionCode() {
		return deleteClient.getIdentification();
	}
	
	public Client clientDataReceptor() {
		return creation.clientDataReceptor();
	}
}
