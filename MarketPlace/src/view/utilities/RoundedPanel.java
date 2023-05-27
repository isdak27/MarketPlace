package view.utilities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Color backgroundColor;
	private int radius;

	public RoundedPanel(Color backgroundColor, int radius) {
		this.radius = radius;
		this.backgroundColor = backgroundColor;
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(backgroundColor);
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
		g2d.dispose();
	}
}