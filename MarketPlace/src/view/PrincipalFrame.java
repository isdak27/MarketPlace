package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

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
	
	public PrincipalFrame() {
		super("Los Rosales");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setLayout(new BorderLayout());
		this.initComponents();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initComponents() {
		bannerPanel = new BannerPanel();
		this.add(bannerPanel, BorderLayout.NORTH);
		bodyPanel = new BodyPanel();
		this.add(bodyPanel, BorderLayout.CENTER);
				
	}

}

