package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Client;
import model.ProductStock;
import view.banner.BannerPanel;
import view.body.BodyPanel;

public class PrincipalFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BannerPanel bannerPanel; 
	private BodyPanel bodyPanel; 
//	private FooterPanel footerPanel;
	
	public PrincipalFrame(ActionListener actionListener,ArrayList<Client> clients, ArrayList<ProductStock> products) {
		super("Los Rosales");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setLayout(new BorderLayout());
		this.initComponents(actionListener,clients, products);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initComponents(ActionListener actionListener,ArrayList<Client> clients, ArrayList<ProductStock> products) {
		bannerPanel = new BannerPanel();
		this.add(bannerPanel, BorderLayout.NORTH);
		bodyPanel = new BodyPanel(actionListener,clients, products);
		this.add(bodyPanel, BorderLayout.CENTER);
				
	}
	
	public Client clientDataReceptor() {
		return bodyPanel.clientDataReceptor();
	}
	
	public void openCreationClientPanel() {
		bodyPanel.openCreationClientPanel();
	}
	
	public void openDeleteClientPanel() {
		bodyPanel.openDeleteClientPanel();
	}

	public void updateTable(ArrayList<Client> clients) {
		bodyPanel.updateTableClients(clients);
	}
	
	public long getDeleteActionCode() {
		return bodyPanel.getDeleteActionCode();
	}

	public ProductStock productDataReceptor() {
		return bodyPanel.productDataReceptor();
	}
	
	public void openCreationProductPanel() {
		bodyPanel.openCreationProductPanel();
	}
	
	public void openDeleteProductPanel() {
		bodyPanel.openDeleteProductPanel();
	}

	public void updateTableProducts(ArrayList<ProductStock> products) {
		bodyPanel.updateTableProducts(products);
	}
	
	public int getDeleteActionCodeProduct() {
		return bodyPanel.getDeleteActionCodeProduct();
	}
	
}

