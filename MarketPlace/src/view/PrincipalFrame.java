package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

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
	
	public PrincipalFrame(ActionListener actionListener) {
		super("Los Rosales");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().setLayout(new BorderLayout());
		this.initComponents(actionListener);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initComponents(ActionListener actionListener) {
		bannerPanel = new BannerPanel();
		this.add(bannerPanel, BorderLayout.NORTH);
		bodyPanel = new BodyPanel(actionListener);
		this.add(bodyPanel, BorderLayout.CENTER);
				
	}

}

