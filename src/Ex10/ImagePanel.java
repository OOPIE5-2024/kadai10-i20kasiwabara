package Ex10;



import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
  BufferedImage img;
  public void setImage(BufferedImage d) {
    setSize(d.getWidth(), d.getHeight());
    setPreferredSize(super.getSize());
    this.img = d;
  }
  
  public BufferedImage getImage() {
	  BufferedImage d = this.img;
	  return d;
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img, 0, 0, null);
  }
}
