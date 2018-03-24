package main;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button {
	JButton button;
	
	
	public Button(){}
	
	public JButton startButton(){
		button = new JButton(new ImageIcon("main/startButton.jpg"));
		button.setBorderPainted(false); // 외각선을 없애준다
		button.setContentAreaFilled(false); // 내용영역 채우기 않함
		button.setFocusPainted(false); // 선택 되었을때 생기는 테두리 사용여부
		button.setBounds(580, 635, 160, 51);  // 시계 버튼 사이즈 및 위치
		button.setVisible(true);
		return button;
	}

}
