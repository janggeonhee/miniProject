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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class OfferFrame {
	JFrame selectF;
	ImageIcon panelIcon;
	
	public JFrame offerFrame(int num){
		selectF = new JFrame();
		selectF.setUndecorated(true);
		selectF.setResizable(false);
		selectF.setBounds(700, 500, 540, 80);
		switch(num){
		case 1 :
			//문제가 있는 경우 라벨
			JLabel haveL = new JLabel(new ImageIcon("offer/have.png"));
			haveL.setBounds(0, 0, 540,80);
			selectF.add(haveL);
			break;
		case 2 :
			//아무것도 없을 경우 라벨
			JLabel noHaveL = new JLabel(new ImageIcon("offer/noHave.png"));
			noHaveL.setBounds(0, 0, 540,80);
			selectF.add(noHaveL);
			break;
		case 3 :
			//아이템이 있을 경우 라벨
			JLabel whatL = new JLabel(new ImageIcon("offer/what.png"));
			whatL.setBounds(0, 0, 540,80);
			selectF.add(whatL);
			break;
		}
		return selectF;
		
	}
	
	public JPanel panelTest(String answer, int x ,int y , int width, int height){
		Font f1 = new Font("양재블럭체", Font.CENTER_BASELINE, 15);
		
		//패털 배경 설정
		panelIcon = new ImageIcon("panelImage.jpg");
		JPanel panel = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(panelIcon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		panel.setBounds(x, y, width, height);
		panel.setLayout(null);
		// 정답 라벨		
		JLabel answer1 = new JLabel("정답 ");
		answer1.setBounds(85, 10, 100, 100);
		answer1.setForeground(Color.white);
		answer1.setFont(f1);
		// 정답 입력 받을 textfild
		JTextField answerTF = new JTextField(30);
		answerTF.setBounds(140, 45 ,200 ,30);
		panel.add(answer1);
		panel.add(answerTF);

				
		answerTF.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				if (answerTF.getText().equals(answer)) {
					// 정답시 새로운 창
					 	JOptionPane.showMessageDialog(null, "정답입니다.");
					 	
					} else {
					// 틀릴시 새로운 창
						JOptionPane.showMessageDialog(null, "틀렸습니다.");
					}
							// 답 입력 후 삭제
					answerTF.setText("");
					}
				});
		return panel;
	}
	 
}


