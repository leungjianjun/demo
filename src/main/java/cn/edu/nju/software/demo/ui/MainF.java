package cn.edu.nju.software.demo.ui;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.StandardButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.SaharaSkin;
import org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

public class MainF extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainF(){
		super("Simple Demo");
		this.setTitle("Simple Demo");
		this.setIconImage(new ImageIcon("src/main/resources/images/Sweets_001.png").getImage());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//this.setUndecorated(true);
		try{
			
			UIManager.setLookAndFeel(new SubstanceOfficeBlue2007LookAndFeel());
			JFrame.setDefaultLookAndFeelDecorated(true);
		    JDialog.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel.setSkin(new SaharaSkin());
			SubstanceLookAndFeel
					.setCurrentButtonShaper(new StandardButtonShaper());

			SubstanceLookAndFeel
					.setCurrentWatermark(new SubstanceBubblesWatermark());
			SubstanceLookAndFeel
					.setCurrentBorderPainter(new StandardBorderPainter());
			SubstanceLookAndFeel
					.setCurrentGradientPainter(new StandardGradientPainter());

	}catch (Exception exx) {
		System.err.println("Something went wrong!");
	}
		
		MainP mainP=new MainP(this);
		this.getContentPane().add(mainP);
		this.setSize(500, 350);
		this.setLocation(400, 200);
		this.setVisible(true);
		this.setResizable(false);
		
	}
	
	public static void main(String[] args){
		MainF frame =new MainF();
		frame.setVisible(true);
	}
	

}
