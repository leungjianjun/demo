package cn.edu.nju.software.demo.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cn.edu.nju.software.demo.controller.ScoreController;

/**
 * 
 * @author Cancy
 *
 */
public class MainP extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ScoreController scoreController=new ScoreController();
	
	//界面的显示
			@SuppressWarnings("unused")
			private JFrame fatherFrame = null;
			private JLabel startNoLabel = null;
			private JLabel endNoLabel = null;
			private JTextField startNoTextField = null;
			private JTextField endNoTextField = null;
			
			private JButton calc = null;
			private JButton exit=null;
			private JButton intro=null;
			
			//获得数据时存放的变量
			private String startNo =  null;
			private String endNo = null;
			
			/**
			 * 构造函数
			 * @param f 父容器
			 */
			MainP(JFrame f){
				this.setLayout(null);
				this.fatherFrame = f;
				initilize();
			}
			
			
			private void initilize() {
				// TODO Auto-generated method stub
				startNoLabel=new JLabel("起始学号：");
				startNoLabel.setBounds(new Rectangle(10, 45, 80, 31));
				startNoLabel.setPreferredSize(new Dimension(26, 20));
				startNoLabel.setFont(new Font("Dialog", Font.BOLD, 10));
				startNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				startNoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
				
				endNoLabel = new JLabel("结束学号：");
				endNoLabel.setBounds(new Rectangle(10, 95, 80, 31));
				endNoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
				endNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				endNoLabel.setFont(new Font("Dialog", Font.BOLD, 10));
				//endNoLabel.setBorder(null);
				
				
				add(startNoLabel, null);
				add(endNoLabel, null);
				add(getStartNoTextField(), null);
				add(getEndNoTextField(), null);
				add(getIntroButton(), null);
				add(getExitButton(), null);
				add(getCalcButton(), null);
				
			}
			
			/**
			 * 
			 * @return
			 */
			private JTextField getStartNoTextField() {
				if (startNoTextField == null) {
					startNoTextField = new JTextField();
					startNoTextField.setBounds(new Rectangle(92, 45, 100, 26));
				}
				return startNoTextField;
			}
			
			/**
			 * 
			 * @return
			 */
			private JTextField getEndNoTextField() {
				if (endNoTextField == null) {
					endNoTextField = new JTextField();
					endNoTextField.setBounds(new Rectangle(92, 95, 100, 26));
				}
				return endNoTextField;
			}
			
			/**
			 * 
			 * @return
			 */
			private JButton getCalcButton() {
				if (calc == null) {
					calc = new JButton("计算");
					calc.setBorder(null);
					calc.setBounds(new Rectangle(20, 250, 40, 40));
					calc.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							// TODO Auto-generated Event stub actionPerformed()
							
							//get user input
							startNo = startNoTextField.getText();
							endNo = endNoTextField.getText();
							
							if(startNo.equals(""))
								JOptionPane.showMessageDialog(null, "请输入起始学号！", "提示", JOptionPane.INFORMATION_MESSAGE);
							else if(endNo.equals(""))
								JOptionPane.showMessageDialog(null, "请输入结束学号！", "提示", JOptionPane.INFORMATION_MESSAGE);
							else{
								double average=0.0;
								average=scoreController.calcScores(startNo, endNo);
								JOptionPane.showMessageDialog(null, "平均分为: "+average, "结果", JOptionPane.INFORMATION_MESSAGE);
													
							}	
								
						}
					});
				}		
				return calc;
			}
			
			private JButton getIntroButton(){
				if(intro==null){
					intro=new JButton("导入");
					
					intro.setBounds(new Rectangle(90,250,40,40));
					intro.setBorder(null);
					intro.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if(scoreController.addScores())
								JOptionPane.showMessageDialog(null, "导入成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
							else
								JOptionPane.showMessageDialog(null, "导入失败！", "提示", JOptionPane.INFORMATION_MESSAGE);
						}
					    });
				}
				return intro;
			}

			
			
			/**
			 * 
			 * @return
			 */
			private JButton getExitButton(){
				if(exit==null){
					exit=new JButton("取消");
					
					exit.setBounds(new Rectangle(160,250,40,40));
				    exit.setBorder(null);
				    exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.exit(0);
						}
					    });
				}
				return exit;
			}
			
			
			
			/**
			 * 重写父类的方法画背景
			 */
			
			public void paintComponent(Graphics g) { 
		        g.setColor(Color.blue); 
		        ImageIcon img=null;
				img = new ImageIcon("src/main/resources/images/大图效果君.jpg");
				g.drawImage(img.getImage(),0,0,null); 
		    }

}
