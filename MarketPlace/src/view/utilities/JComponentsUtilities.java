package view.utilities;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JComponentsUtilities {

	public static JButton buttonPlusImageText(JButton element, String imageUrl, Color background, String text,
			int imageWidht, int imageHeight, int widht, int height, Color foreground, Font font) {
		element.setIcon(SourcesUtilities.imageIconResize(imageUrl, imageWidht, imageHeight));
		element.setText(text);
		element.setBackground(background);
		element.setForeground(foreground);
		element.setFont(font);
		element.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		element.setSize(widht, height);
		element.setBorderPainted(false);
		return element;
	}

	public static JButton buttonPlusImageTextTrans(JButton element, String imageUrl, String text, int imageWidht,
			int imageHeight, int widht, int height, Color foreground, Font font) {
		element.setIcon(SourcesUtilities.imageIconResize(imageUrl, imageWidht, imageHeight));
		element.setText(text);
		element.setBackground(new Color(0, 0, 0, 0));
		element.setForeground(foreground);
		element.setFont(font);
		element.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		element.setSize(widht, height);
		element.setOpaque(false);
		element.setBorderPainted(false);
		return element;
	}

	public static JButton buttonPlusOnlyImage(JButton element, String imageUrl, int widht, int height) {
		element.setIcon(SourcesUtilities.imageIconResize(imageUrl, widht, height));
		element.setSize(widht, height);
		element.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		element.setContentAreaFilled(false);
		element.setBorderPainted(false);
		element.setBorder(null);
		return element;
	}

	public static JButton buttonSimple(JButton element, Color background, Font font, Color foreground, String text,
			int width, int height) {
		Dimension size = new Dimension();
		size.setSize(width, height);
		element.setText(text);
		element.setForeground(foreground);
		element.setFont(font);
		element.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		element.setMaximumSize(size);
		element.setContentAreaFilled(false);
		element.setBorderPainted(false);
		return element;
	}

	public static JButton buttonSimpleBorde(JButton element, Color background, Font font, Color foreground, String text,
			int width, int height) {
		Dimension size = new Dimension();
		size.setSize(width, height);
		element.setText(text);
		element.setBackground(background);
		element.setForeground(foreground);
		element.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		element.setFont(font);
		element.setMaximumSize(size);
		return element;
	}

	public static JButton buttonSimple(JButton element, Color background, int width, int height) {
		Dimension size = new Dimension();
		size.setSize(width, height);
		element.setMaximumSize(size);
		element.setContentAreaFilled(false);
		element.setBorderPainted(false);
		element.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return element;
	}

	public static JTextField textFieldSimple(JTextField element, String text, Font fond, Color color, int width,
			int height) {
		Dimension size = new Dimension();
		size.setSize(width, height);
		element.setText(text);
		element.setFont(fond);
		element.setForeground(color);
		element.setMaximumSize(size);
		element.setEditable(true);
		return element;
	}

	public static JLabel labelSimpleFont(JLabel element, Font font, Color foreground, String text, int width,
			int height) {
		Dimension size = new Dimension();
		size.setSize(width, height);
		element.setText(text);
		element.setForeground(foreground);
		element.setFont(font);
		element.setMaximumSize(size);
		return element;
	}

	public static JLabel labelSimple(JLabel element, String text) {
		element.setText(text);
		return element;
	}

	public static JLabel labelImage(JLabel element, String imageUrl, int widht, int height) {
		element.setIcon(SourcesUtilities.imageIconResize(imageUrl, widht, height));
		element.setBorder(null);
		return element;
	}

	public static JPasswordField paswordSimple(JPasswordField element, String text, Font fond, Color color, int widht,
			int height) {
		Dimension size = new Dimension();
		size.setSize(widht, height);
		element.setText(text);
		element.setFont(fond);
		element.setForeground(color);
		element.setEditable(true);
		element.setMaximumSize(size);
		return element;
	}

}
