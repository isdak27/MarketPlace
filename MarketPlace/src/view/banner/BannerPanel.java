package view.banner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.constants.ColorConstants;
import view.constants.FontConstants;
import view.constants.ImagePathConstants;
import view.constants.TextConstants;
import view.utilities.JComponentsUtilities;

public class BannerPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel title; 
	private JLabel logo;
	
	public BannerPanel() {
		this.setBackground(ColorConstants.DARK_PURPLE);
		this.setPreferredSize(new Dimension(0, 80));
		this.initComponents();
	}
	
	public void initComponents() {
		this.setLayout(new BorderLayout());
		logo = new JLabel();
		JComponentsUtilities.labelImage(logo, ImagePathConstants.LOS_ROSALES_IMAGE_URL, 80, 80);
		this.add(logo, BorderLayout.LINE_START);
		
		title = new JLabel(TextConstants.COMPANY_NAME_TEXT);
		title.setForeground(Color.WHITE);
		title.setFont(FontConstants.PUCK_BOLD_BOLD_FONT_18);
		this.add(title);
	}
	

}
