package view.utilities;

import java.awt.Image;

import javax.swing.ImageIcon;

public class SourcesUtilities {

	public static ImageIcon imageIconResize(String url, int widht, int height) {
		ImageIcon icon = new ImageIcon(
				new ImageIcon(url).getImage().getScaledInstance(widht, height, Image.SCALE_DEFAULT));
		return icon;
	}

	public static Image imageResize(String url, int widht, int height) {
		Image icon = new ImageIcon(url).getImage().getScaledInstance(widht, height, Image.SCALE_DEFAULT);
		return icon;
	}
}
