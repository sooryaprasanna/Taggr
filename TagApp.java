package taggr;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TagApp extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public TagApp(){
		super("Welcome to Frames");
		setSize(580,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				new Frame().setVisible(true);
			}
		});
	}
}