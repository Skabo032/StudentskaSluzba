package view;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ResizeIcon extends ImageIcon{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	public ResizeIcon(String path, int sizeX, int sizeY) {
		Image img = new ImageIcon(path).getImage();
		Image newImg = img.getScaledInstance(sizeX, sizeY, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newImg);	
	}
	public ImageIcon getIcon() {
		return icon;
	}
}
