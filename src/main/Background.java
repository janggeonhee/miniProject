package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Background extends JFrame {
	private String name; //입력 받은 이름값
	JPanel background;
	JScrollPane scrollPane;
	
	JButton startButton = new JButton(); //시작 버튼
	Button button = new Button(); //시작 버튼
	
	Monologue fc = new Monologue(); //독백 클래스 객체 생성
	JPanel monologue = new JPanel(); //모놀로그 패널

	JPanel nameInputP; //너의 이름은 패널	
	
	JFrame mainFrame; // 메인 프레임
	JFrame nameField;     // 이름입력 프레임
	JLabel nameLabel;
	Image nameImage;
	
	public Background(){
		// 메인 프레임 이미지 패널 생성
		Image mainBG = new ImageIcon("main/mainImage.jpg").getImage();
		background = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				
				g.drawImage(mainBG, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		scrollPane = new JScrollPane(background);
	
		background.setBounds(0, 0, 1280, 800);
		setContentPane(scrollPane);
		background.setLayout(null);
		
		//메인 프레임 생성
		mainFrame = new JFrame();
		
		mainFrame.setTitle("메인 화면");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(300, 100, 1280, 800);
		mainFrame.setResizable(false);
		mainFrame.add(background);
		mainFrame.add(scrollPane);
		mainFrame.setLocationRelativeTo(null);
		
		
		//너늬 이름은 패널 생성
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("nameInput/nameInput.gif");
		
		nameInputP = new JPanel() {
			@Override
			public void paint(Graphics g) {
				if (img == null) {
					return;
				}
				g.drawImage(img, 0, 0, this);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		nameInputP.setLayout(null);
		nameInputP.setBounds(0, 0, 1280, 800);
		
		
		
		// 너의 이림은 텍스트 필드 담을 프레임 생성
		nameField = new JFrame();
		nameField.setUndecorated(true); // 타이틀바 제거
		nameField.setLayout(null);
		nameField.setBounds(570, 456, 713, 185);
		nameField.setResizable(false); // 프레임 고정
		nameField.setOpacity((float) 0.7);

		
		// 너의 이름은 필드 이미지
		nameImage = new ImageIcon("nameInput/nameField.png").getImage();
		nameLabel = new JLabel(new ImageIcon(nameImage));
		nameLabel.setBounds(0, 0, 713, 185);
		
		Font commonFont = new Font("맑은 고딕", Font.BOLD, 30);

		
		// 너이 의름은 텍스트 필드 생성
		JTextField nameInput = new JTextField("이름을 입력하세요.");
		nameInput.setBounds(200, 118, 300, 50);
		nameInput.setFont(commonFont);
		nameInput.setBackground(Color.BLACK);
		nameInput.setOpaque(isOpaque());
		nameInput.setForeground(Color.white);
		nameInput.setBorder(null);
		nameInput.setHorizontalAlignment(JTextField.CENTER);
		
		nameField.add(nameInput);
		nameField.add(nameLabel);
		// 마우스 클릭시 필드 초기화
		nameInput.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String str=nameInput.getText();
				if(str.equals("이름을 입력하세요.")){
					str="";
					nameInput.setText(str);
				}

			}
		});
		//이름 입력시 이름값 저장 및 모놀로그 실행
		nameInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				monologue = fc.monologue();
				System.out.println(nameInput.getText());	
				name = nameInput.getText();		
				nameField.dispose();
				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(monologue);
				mainFrame.revalidate();
				mainFrame.repaint();
				
			}
		});
		
		
		
		//메인 프레임에 스타트 버튼 삽입
		startButton = button.startButton();
		background.add(startButton);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				mainFrame.getContentPane().removeAll();
				mainFrame.getContentPane().add(nameInputP);
				mainFrame.revalidate();
				mainFrame.repaint();
				nameField.setVisible(true);
				
				
				
				}
		});	
			
		mainFrame.setVisible(true);
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}

