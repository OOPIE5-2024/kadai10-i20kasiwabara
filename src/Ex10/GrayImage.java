package Ex10;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GrayImage extends BufferedImage{
	public GrayImage(BufferedImage img) {
		super(img.getWidth(), img.getHeight(), TYPE_BYTE_GRAY);
		
		Graphics g = createGraphics();
		g.drawImage(img, 0, 0, null);
	}
	int getGray(int x, int y) {
		int argb =  getRGB(x, y);
		int b = argb & 0xff; //b値の取り出し
		return b;//r,g,bの値はすべて同じなのでb値だけ返す
	}
	void setGray(int x, int y, int gray) {
		int argb = (0xff << 24) | (gray << 16) | (gray << 8) | gray;
		setRGB(x, y, argb);
	}
}
