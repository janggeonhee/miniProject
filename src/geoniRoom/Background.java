package geoniRoom;

import javax.swing.*;
import javax.swing.plaf.synth.SynthStyle;

import geoniRoom.function.ButtonManagement;
import geoniRoom.function.HintEvent;
import geoniRoom.function.OfferFrame;
import geoniRoom.function.ProblemManagement;

import java.awt.event.*;
import java.awt.*;

public class Background extends JFrame{
	
	JScrollPane scrollPane;
	ImageIcon icon;
	Image mouseImg;
	Image buttonMI;
	Cursor mouse;
	Cursor mouseOn;
	
	JTextArea temp;
	JFrame frame;
	JFrame offerF;
	Toolkit tk1;
	Toolkit tk2;
		
	ButtonManagement bm = new ButtonManagement();
	ProblemManagement pm = new ProblemManagement();
	HintEvent he = new HintEvent();
	OfferFrame offer = new OfferFrame();
	
	JButton clockB = new JButton();
	JButton frameB = new JButton();
	JButton lightB = new JButton();
	JButton vaseB = new JButton();
	JButton hintVisualize = new JButton();
	JButton hintButton = new JButton();
	JButton exitDoorButton = new JButton();
	JFrame mainFrame = new JFrame();
	JFrame endFrame = new JFrame();
	JPanel background;
	
	private int count1 ;
	private int count2 ;
	private int count3 ;
	private int count4 ;
	private int count5 ;
	private int count6;
	private int count7 ;
	
	public Background(){
		intro();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {			
			e1.printStackTrace();
		}
		
		//Room2 이미지 가지고오기 
		icon = new ImageIcon("Room2.jpg");
		
		//Room2 이미지 프레임 사이즈에 맞추기
		Image room2 = icon.getImage();
		Image roomBg = room2.getScaledInstance(1280, 800, java.awt.Image.SCALE_SMOOTH);
		ImageIcon sizeIcon = new ImageIcon(roomBg);
		background = new JPanel(){
			public void paintComponent(Graphics g){
				
				g.drawImage(sizeIcon.getImage(),0, 0, null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		
		//기본 마우스 커서 이미지 씌우기
		tk1 = Toolkit.getDefaultToolkit();
		mouseImg = new ImageIcon("cursorImage/basicCursor.png").getImage();
		Point point = new Point(0, 0);
		mouse = tk1.createCustomCursor(mouseImg, point, "name");
		background.setCursor(mouse);
		
		
		tk2 = Toolkit.getDefaultToolkit();
		buttonMI = new ImageIcon("cursorImage/buttonCusor.png").getImage();
		Point point2 = new Point(0, 0);
		mouseOn = tk2.createCustomCursor(buttonMI, point, "");
		
		
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
		background.setLayout(null);//null 레이 아웃으로 설정
		
		//시계 버튼 및 이미지
		clockB = bm.clockButton();
		clockB.setCursor(mouseOn);
		background.add(clockB);
		clockB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pm.clockProblem();
				
			}
		});
		// 액자 버튼 및 이미지
		frameB = bm.frameButton();
		background.add(frameB);
		frameB.setCursor(mouseOn);
		frameB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pm.frameProblem();
			}
		});
		//전등 버튼 및 이미지
		lightB = bm.lightButton();
		background.add(lightB);
		lightB.setCursor(mouseOn);
		lightB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pm.lightProblem();
			}
		});
		//꽃병 버튼 및 이미지
		vaseB = bm.vaseButton();
		background.add(vaseB);
		vaseB.setCursor(mouseOn);
		vaseB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pm.vaseProblem();
				
			}
		});
		
		//힌트 발견 버튼 및 힌트 버튼 발생
		hintVisualize = bm.hintVisualize();
		hintVisualize.setCursor(mouseOn);
		hintButton = bm.hintButton();
		hintButton.setCursor(mouseOn);
		background.add(hintVisualize);
		
		hintVisualize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				temp = he.messageTest();			
				background.add(temp);
				he.hintVisualize();
				background.add(hintButton);
				background.remove(hintVisualize);
			}
		});
		hintButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				he.eventFremaOpen();
			}
		});
		
		exitDoorButton = bm.exitDoor();
		exitDoorButton.setCursor(mouseOn);
		background.add(exitDoorButton);
		exitDoorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				count1=0;
				count2=0;
				count3=0;
				count4=0;
				count5=0;
				count6=0;
				count7=0;
				
				finishProblem();
			}
		});
		
		
		JTextArea timeBox = new JTextArea();
		Font commonFont = new Font("맑은 고딕", Font.BOLD, 15);
		timeBox.setBounds(0, 0, 70, 20);
		timeBox.setFont(commonFont);
		background.add(timeBox);
		
		
		mainFrame.setTitle("건희방");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(300, 100, 1280, 800);
		mainFrame.getContentPane().removeAll();
		mainFrame.add(background);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);

		
	}
	
		public void finishProblem(){
		
			
		frame = new JFrame(); // 탈출 문제 프레임
		frame.setUndecorated(true); // 타이틀바 제거
		frame.setLayout(null);
		frame.setBounds(800, 300, 500, 400);
		frame.setResizable(false);  // 프레임 고정
		
		Image finishIm = new ImageIcon("finish/finishFrame.jpg").getImage();
		JPanel backP = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(finishIm, 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		JScrollPane scrollPane = new JScrollPane(backP);
		
		backP.setBounds(0, 0, 500, 400);
		setContentPane(scrollPane);
		backP.setLayout(null);
		
		JLabel numKey1 = pm.keyNum(1);
		JLabel numKey2 = pm.keyNum(2);
		JLabel numKey3 = pm.keyNum(3);
		JLabel numKey4 = pm.keyNum(4);
		JLabel numKey5 = pm.keyNum(5);
		JLabel numKey6 = pm.keyNum(6);
		JLabel numKey7 = pm.keyNum(7);
		JButton countBt1 = bm.countUpButton();
		JButton countBt2 = bm.countUpButton();
		JButton countBt3 = bm.countUpButton();
		JButton countBt4 = bm.countUpButton();
		JButton countBt5 = bm.countUpButton();
		JButton countBt6 = bm.countUpButton();
		JButton countBt7 = bm.countUpButton();
		
		JButton exitButton = bm.exitButton();
		JButton pExitButton = bm.finishExitButton();
		
		countBt1.setBounds(15, 320, 55, 55);
		countBt2.setBounds(85, 320, 55, 55);
		countBt3.setBounds(155, 320, 55, 55);
		countBt4.setBounds(225, 320, 55, 55);
		countBt5.setBounds(295, 320, 55, 55);
		countBt6.setBounds(365, 320, 55, 55);
		countBt7.setBounds(435, 320, 55, 55);
		
			
		backP.add(numKey1);
		backP.add(numKey2);
		backP.add(numKey3);
		backP.add(numKey4);
		backP.add(numKey5);
		backP.add(numKey6);
		backP.add(numKey7);
		backP.add(countBt1);
		backP.add(countBt2);
		backP.add(countBt3);
		backP.add(countBt4);
		backP.add(countBt5);
		backP.add(countBt6);
		backP.add(countBt7);
		backP.add(pExitButton);
		
		
		
		pExitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
		
		countBt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count1 ==10){
					count1 = 0;
				}
				Image countIM = new ImageIcon("finish/key/" + String.valueOf(count1 = ++count1== 10 ? 0 : count1) + ".png").getImage().getScaledInstance(55,150, 0);
				numKey1.setIcon(new ImageIcon(countIM));
				exitRoom(count1 , count2,count3,count4,count5,count6,count7);
			}
		});
		
		countBt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count2 ==10){
					count2 = 0;
				}
				Image countIM = new ImageIcon("finish/key/" + String.valueOf(count2 = ++count2== 10 ? 0 : count2) + ".png").getImage().getScaledInstance(55,150, 0);
				numKey2.setIcon(new ImageIcon(countIM));
				exitRoom(count1 , count2,count3,count4,count5,count6,count7);
			}
		});
		
			countBt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count3 ==10){
					count3 = 0;
				}
				Image countIM = new ImageIcon("finish/key/" + String.valueOf(count3 = ++count3== 10 ? 0 : count3) + ".png").getImage().getScaledInstance(55,150, 0);
				numKey3.setIcon(new ImageIcon(countIM));
				exitRoom(count1 , count2,count3,count4,count5,count6,count7);
			}
		});
			countBt4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(count4 ==10){
						count4 = 0;
					}
					Image countIM = new ImageIcon("finish/key/" + String.valueOf(count4 = ++count4== 10 ? 0 : count4) + ".png").getImage().getScaledInstance(55,150, 0);
					numKey4.setIcon(new ImageIcon(countIM));
					exitRoom(count1 , count2,count3,count4,count5,count6,count7);
				}
			});
			countBt5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(count5 ==10){
						count5 = 0;
					}
					Image countIM = new ImageIcon("finish/key/" + String.valueOf(count5 = ++count5== 10 ? 0 : count5) + ".png").getImage().getScaledInstance(55,150, 0);
					numKey5.setIcon(new ImageIcon(countIM));
					exitRoom(count1 , count2,count3,count4,count5,count6,count7);
				}
			});
		
			countBt6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(count6 ==10){
						count6 = 0;
					}
					Image countIM = new ImageIcon("finish/key/" + String.valueOf(count6 = ++count6== 10 ? 0 : count6) + ".png").getImage().getScaledInstance(55,150, 0);
					numKey6.setIcon(new ImageIcon(countIM));
					exitRoom(count1 , count2,count3,count4,count5,count6,count7);
				}
			});
			countBt7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(count7 ==10){
						count7 = 0;
					}
					Image countIM = new ImageIcon("finish/key/" + String.valueOf(count7 = ++count7== 10 ? 0 : count7) + ".png").getImage().getScaledInstance(55,150, 0);
					numKey7.setIcon(new ImageIcon(countIM));
					exitRoom(count1 , count2,count3,count4,count5,count6,count7);
				}
			});
			
		offerF = offer.offerFrame(1);
		frame.add(backP);
		
		frame.setVisible(true);
		
			
	}
		
		public void exitRoom(int count1, int count2, int count3, int count4, int count5, int count6, int count7){
			int check = 0;
			if(count1 == 7 && count2 == 1 && count3 == 7 && count4 == 3 && count5 == 1 &&
					count6 == 0 &&count7 == 2 ){
				check++;
			}
			if(check==1){
			
		
					frame.dispose();
					mainFrame.dispose();
					endFrame();
					new endThread().start();
			
		}
		
		}
		
		public void intro(){
			Image img;
			Toolkit tk = Toolkit.getDefaultToolkit();
			img = tk.getImage("introRoom.gif");
			
			background = new JPanel(){
				@Override
				public void paint(Graphics g) {
					if(img == null){
						return;
					}
					g.drawImage(img, 0, 0, this);
					setOpaque(false);
					super.paint(g);
				}
			};
			
			mainFrame.add(background);
			scrollPane = new JScrollPane(background);
			mainFrame.add(scrollPane);
			
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setSize(1280, 800);

			mainFrame.setLocationRelativeTo(null);
			mainFrame.setResizable(false);
			mainFrame.setVisible(true);
		}
		
		public void endFrame(){
			Image img;
			Toolkit tk = Toolkit.getDefaultToolkit();
			img = tk.getImage("EndRoom.gif");
			
			background = new JPanel(){
				@Override
				public void paint(Graphics g) {
					if(img == null){
						return;
					}
					g.drawImage(img, 0, 0, this);
					setOpaque(false);
					super.paint(g);
				}
			};
			endFrame.add(background);
			scrollPane = new JScrollPane(background);
			endFrame.add(scrollPane);

			endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			endFrame.setSize(1280, 800);
			
			endFrame.setLocationRelativeTo(null);
			endFrame.setResizable(false);
			endFrame.setVisible(true);
			
		}
		
		
		
		class endThread extends Thread {

			public void run() {
				try {

					Thread.sleep(6000);
					endFrame.dispose();
					

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
