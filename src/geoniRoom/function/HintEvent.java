package geoniRoom.function;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HintEvent {
	OfferFrame offer = new OfferFrame();
	ButtonManagement BM = new ButtonManagement();
	
	JFrame offerF = new JFrame();
	JFrame hintF;
	
	JButton clockHintButton = new JButton();
	JButton frameHintButton = new JButton();
	JButton lightHintButton = new JButton();
	JButton vaseHintButton = new JButton();
	
	JTextArea storyConsol;
	
	//힌트 버튼 클릭시 독백 멘트
	String[] message = {" 	\n             절 잘도 찾아내셨군요.....",
			 				"   \n             저는 힌트 요정입니다......",
			 				"   \n             힌트를 드리겠습니다..."};
	
	
	public HintEvent(){}
	//클릭시 힌트 곰돌이 생성
	public void hintVisualize(){
		offerF = offer.offerFrame(3);
		offerF.setVisible(true);
		new OfferThread().start();
	}
	//힌트 곰돌이 생성전 독백
	public JTextArea messageTest(){
		Image textboxBg = new ImageIcon("stroryConsol.png").getImage();
		Font f1 = new Font("고딕", Font.BOLD, 40);
		//독백 배경화면 
		storyConsol = new JTextArea(){
			@Override
			public void paintComponent(Graphics g) {
			
			g.drawImage(textboxBg, 0, 0,null);
			setOpaque(false);
			super.paintComponent(g);
			}
		};
		storyConsol.setBounds(0, 569, 1280, 200);
		storyConsol.setEditable(false);
		storyConsol.setForeground(Color.white);
		storyConsol.setFont(f1);
		//독백 쓰레드
		new MessageThread().start();
			
		return storyConsol;
		
	}
	
	public void eventFremaOpen(){
		hintF = new JFrame();
		hintF.setUndecorated(true); // 타이틀바 제거
		hintF.setLayout(null);
		hintF.setBounds(800, 300, 400, 200);
		hintF.setResizable(false);  // 프레임 고정
		
		//시계 힌트 버튼 및 이벤트
		clockHintButton = BM.clockHintButton();
		clockHintButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "시간", "Hint" , JOptionPane.PLAIN_MESSAGE);
				hintF.dispose();
			}
		});
		hintF.add(clockHintButton);
		//액자 힌트 버튼 및 이벤트
		frameHintButton = BM.frameHintButton();
		frameHintButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "전자 폰트 ", "Hint" , JOptionPane.PLAIN_MESSAGE);
				hintF.dispose();
			}
		});
		hintF.add(frameHintButton);
		//전등 힌트 버튼 및 이벤트
		lightHintButton = BM.lightHintButton();
		lightHintButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "넘나 쉬움 ", "Hint" , JOptionPane.PLAIN_MESSAGE);
				hintF.dispose();
			}
		});
		hintF.add(lightHintButton);
		//꽃병 힌트 버튼 및 이벤트
		vaseHintButton = BM.vaseHintButton();
		vaseHintButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, " 힌트가 필요없음 ", "Hint" , JOptionPane.PLAIN_MESSAGE);
				hintF.dispose();
			}
		});
		hintF.add(vaseHintButton);
		
		//힌트화면 텍스트
		Image textboxBg = new ImageIcon("finish/textConsol.png").getImage();
		Font f1 = new Font("고딕", Font.BOLD, 20);
		//힌트텍스트 배경화면 
		storyConsol = new JTextArea(){
			@Override
			public void paintComponent(Graphics g) {
			
			g.drawImage(textboxBg, 0, 0,null);
			setOpaque(false);
			super.paintComponent(g);
			}
		};
		storyConsol.setFont(f1);
		storyConsol.setBounds(0,100 , 400, 100);
		storyConsol.setEditable(false);
		storyConsol.setForeground(Color.white);
		storyConsol.setText("\n         모양에 맞는 힌트를 클릭하세요... ");
		
		hintF.add(storyConsol);
		
		hintF.setVisible(true);
		
	}

	
	
	
	
	class OfferThread extends Thread{
		
		public void run(){
			try {
				Thread.sleep(1000);
				offerF.setVisible(false);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	}
	class MessageThread extends Thread{
		String message1= "";
		
		public void run(){
			for(int i =0; i<message.length; i++){
				for(int j =0; j<message[i].length(); j++){
					try {
						Thread.sleep(80);
						message1 += message[i].charAt(j);
						storyConsol.setText(message1);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(800);
					message1 = "";
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
				storyConsol.setVisible(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	}
}


