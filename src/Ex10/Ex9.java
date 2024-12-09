package Ex10;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.ActionEvent;

public class Ex9 {
  private JFrame frame;
  private ImagePanel imgPanel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Ex9 window = new Ex9();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public Ex9() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    frame.getContentPane().add(panel, BorderLayout.WEST);
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
    JLabel lblNewLabel = new JLabel("File Name");
    panel.add(lblNewLabel);
    
    JTextField textField = new JTextField();
    textField.setColumns(10);
    //textArea_1.setRows(1);
    panel.add(textField);
    
    JButton btnNewButton = new JButton("Load");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          BufferedImage img = ImageIO.read(new File(textField.getText()));
          imgPanel.setImage(img);
        }
        catch(Exception ex) {
          System.out.println(ex);
        }
      }
    });
    panel.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Binary");
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		GrayImage gimg = new GrayImage(imgPanel.getImage());
    		for(int i=0; i<gimg.getWidth(); i++) {
    			for(int j=0; j<gimg.getHeight(); j++) {
    				int gray = gimg.getGray(i, j);
    				gimg.setGray(i, j, gray);
    			}
    		}
    		imgPanel.setImage(gimg);
    	}
    });
    panel.add(btnNewButton_1);
    
    JButton btnNewButton_2 = new JButton("Negative");
    panel.add(btnNewButton_2);
    
    JScrollPane scrollPane = new JScrollPane();
    frame.getContentPane().add(scrollPane, BorderLayout.SOUTH);
    
    JTextArea textArea = new JTextArea();
    scrollPane.setViewportView(textArea);
    
    JScrollPane scrollPane_1 = new JScrollPane();
    frame.getContentPane().add(scrollPane_1, BorderLayout.CENTER);
    
    imgPanel = new ImagePanel();
    scrollPane_1.setViewportView(imgPanel);
  }
}
