package cn.edu.nju.software.demo.ui;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

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
