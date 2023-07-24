package game.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static BufferedImage loadImage(String path)	{
		try {
			BufferedImage image = ImageIO.read(ImageLoader.class.getResource(path));
			return image;
		} catch (IOException e)	{
			e.printStackTrace();
		}
		return null;
	}

}
