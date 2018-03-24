package geoniRoom.function;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ProblemManagement extends JFrame {
	OfferFrame offer = new OfferFrame();
	JFrame frame;
	JFrame offerF;
	JPanel answerP = new JPanel();
	ButtonManagement bm =new ButtonManagement();
	
	public ProblemManagement(){}
	
	public void clockProblem (){
		
		frame = new JFrame(); // 시계 문제 프레임
		frame.setUndecorated(true); // 타이틀바 제거
		frame.setLayout(null);
		frame.setBounds(800, 300, 400, 500);
		frame.setResizable(false);  // 프레임 고정
		
		JButton problemBI = new JButton(new ImageIcon("problem/clockProblem.png"));
		problemBI.setBounds(0, 0, 400, 400);
		problemBI.setBorderPainted(false); 
		problemBI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});

		answerP = offer.panelTest("7", 0, 400, 400, 100);
		frame.add(problemBI);
		frame.add(answerP);
		
		offerF = offer.offerFrame(1); // offer 팝업창
		offerF.setVisible(true);
		new OfferThread().start();
	}
	
	public void frameProblem(){
		//액자 문제 프레임
		frame = new JFrame();
		frame.setUndecorated(true); // 타이틀바 제거
		frame.setLayout(null);
		frame.setBounds(800, 350, 435, 380);
		frame.setResizable(false);  // 프레임 고정
		//액자 문제 
		JButton problemFI = new JButton(new ImageIcon("problem/frameProblem.png"));
		problemFI.setBounds(0, 0, 435, 284);
		problemFI.setBorderPainted(false);
		problemFI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		answerP = offer.panelTest("102", 0, 284, 435, 100);
		frame.add(problemFI);
		frame.add(answerP);	
		
		offerF = offer.offerFrame(1);
		offerF.setVisible(true);
		new OfferThread().start();
	}
	
	public void lightProblem(){
		frame = new JFrame(); // 전등 문제
		frame.setUndecorated(true); // 타이틀바 제거
		frame.setLayout(null);
		frame.setBounds(600, 350, 530, 380);
		frame.setResizable(false);
		
		JButton problemLI =new JButton(new ImageIcon("problem/lightProblem.jpg"));
		problemLI.setBounds(0, 0, 530, 288);
		problemLI.setBorderPainted(false);
		problemLI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		answerP = offer.panelTest("3", 0, 284,530, 105);
		frame.add(problemLI);
		frame.add(answerP);
		
		offerF = offer.offerFrame(1);
		offerF.setVisible(true);
		new OfferThread().start();
		
	}
	
	public void vaseProblem(){
		frame = new JFrame(); //꽃병 문제
		frame.setUndecorated(true); // 타이틀바 제거
		frame.setLayout(null);
		frame.setBounds(700, 270, 435, 380);
		frame.setResizable(false);  // 프레임 고정
		//액자 문제 
		JButton problemVI = new JButton(new ImageIcon("problem/vaseProblem.jpg"));
		problemVI.setBounds(0, 0, 435, 284);
		problemVI.setBorderPainted(false);
		problemVI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		answerP = offer.panelTest("17", 0, 284, 435, 100);
		frame.add(problemVI);
		frame.add(answerP);
		
		offerF = offer.offerFrame(1);
		offerF.setVisible(true);
		new OfferThread().start();
	}
	
	public JLabel keyNum(int amount){
		
	
		JLabel numLabel = null;
		switch(amount){
		case 1:
			numLabel = new JLabel(new ImageIcon("finish/key/0.png"));
			numLabel.setBounds(15, 160, 55, 150);
			break;
		case 2:
			numLabel = new JLabel(new ImageIcon("finish/key/0.png"));
			numLabel.setBounds(85, 160, 55, 150);
			break;
		case 3:
			numLabel = new JLabel(new ImageIcon("finish/key/0.png"));
			numLabel.setBounds(155, 160, 55, 150);
			break;
		case 4:
			numLabel = new JLabel(new ImageIcon("finish/key/0.png"));
			numLabel.setBounds(225, 160, 55, 150);
			break;
		case 5:
			numLabel = new JLabel(new ImageIcon("finish/key/0.png"));
			numLabel.setBounds(295, 160, 55, 150);
			break;
		case 6:
			numLabel = new JLabel(new ImageIcon("finish/key/0.png"));
			numLabel.setBounds(365, 160, 55, 150);
			break;
		case 7:
			numLabel = new JLabel(new ImageIcon("finish/key/0.png"));
			numLabel.setBounds(435, 160, 55, 150);
			break;
		}
			
		return numLabel;
		
		
	}
	
	
	class OfferThread extends Thread{
		
		public void run(){
			try {
				Thread.sleep(1000);
				offerF.dispose();
				frame.setVisible(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
 }

}
