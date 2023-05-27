package view.utilities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RoundedButton {

	public static void makeRounded(JButton button, String text, int radius, Color backgroundColor,
			Color backgroundButtonColor, Color textColor, Font font, int width, int height) {
		button.setBorderPainted(false);
		button.setBackground(backgroundButtonColor);
		button.setPreferredSize(new Dimension(width, height));
		JLabel panelLabel = new JLabel(text);
		panelLabel.setForeground(textColor);
		panelLabel.setFont(font);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JPanel buttonPanel = new RoundedPanel(backgroundColor, radius);
		buttonPanel.add(panelLabel);
		button.add(buttonPanel);
	}

	public static void makeRounded(JButton button, String text, String imageUrl, int radius, Color backgroundColor,
			Color backgroundButtonColor, Color textColor, Font font, int width, int height, int imageWidht,
			int imageHeight) {
		button.setBorderPainted(false);
		button.setBackground(backgroundButtonColor);
		button.setPreferredSize(new Dimension(width, height));
		JLabel panelLabel = new JLabel(text);
		panelLabel.setForeground(textColor);
		panelLabel.setFont(font);
		panelLabel.setIcon(SourcesUtilities.imageIconResize(imageUrl, imageWidht, imageHeight));
		JPanel buttonPanel = new RoundedPanel(backgroundColor, radius);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 0));
		buttonPanel.add(panelLabel);
		button.add(buttonPanel);
	}

}
