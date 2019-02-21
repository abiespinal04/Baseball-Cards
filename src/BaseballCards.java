import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class BaseballCards extends JPanel {

	private final int WIDTH =600;
	private final int HEIGHT = 400;
	private final String TITLE = "Baseball Cards";
	
	private JButton printPlayers, insertPlayers,clear;
	private JTextField playerInput,teamInput,ageInput,numberInput;
	private JTextArea addingPlayers,playersInfo;
	private JLabel playerName,teamName,age,number,empty,playersCounter, playersOutput;
	
	private EmptyBorder border,border1,border2,border3,border4,border5,border6;

	private BufferedImage img = null;
	private TextAreaOutputStream outputStream;
	
	private BaseballPlayers baseballPlayer;
	public Team team;
			

		
		public BaseballCards() {
			
			baseballPlayer = new BaseballPlayers();
			baseballPlayer.checkNumber();
			team = new Team();
			team.addTeamPlayer(baseballPlayer);
			baseballPlayer.setTeam(team);
			//EmptyBorders
			border = new EmptyBorder(5, 6, 5, 20);
			border1 = new EmptyBorder(5, 6, 5, 8);
			border2 = new EmptyBorder(5, 6, 5, 8);
			border3 = new EmptyBorder(80,5, 5, 8);
			border4 = new EmptyBorder(5, 178, 5, 8);
			border5 = new EmptyBorder(0, 90, 0, 0);
			border6 = new EmptyBorder(0, 55, 0, 0);
			
			//JPanel setup
			JPanel jPanel2 = new JPanel();
			jPanel2.setBackground(Color.BLACK);
			jPanel2.setLayout(new BoxLayout(jPanel2,  BoxLayout.PAGE_AXIS));
			jPanel2.setOpaque(false);
			jPanel2.setBorder(border3);
			
			JPanel jPanel3 = new JPanel();
			jPanel3.setBackground(Color.BLACK);
			jPanel3.setLayout(new BoxLayout(jPanel3,  BoxLayout.PAGE_AXIS));
			jPanel3.setOpaque(false);
			jPanel3.setBorder(border3);
		
		
			//Initializing the jframe
			JFrame window= new JFrame();
			
			//loading the image
			loadImage("baseball.jpg");
			
			//The JPanel and components setup
			setLayout(new FlowLayout(FlowLayout.LEFT));
			setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			
			
			//Initializing JTextArea
			addingPlayers = new JTextArea(10,21);
			addingPlayers.setLineWrap(true);
			addingPlayers.setWrapStyleWord(true);
			addingPlayers.setEditable(false);

			
			playersInfo = new JTextArea(10,21);
			playersInfo.setLineWrap(true);
			playersInfo.setWrapStyleWord(true);
			playersInfo.setEditable(false);

			
			//JLabels
			playerName = new JLabel("Player's name: ");
			playerName.setForeground(Color.WHITE);
			teamName = new JLabel("Team's name: ");
			teamName.setBorder(border);
			teamName.setForeground(Color.WHITE);
			age = new JLabel("Player's age: ");
			age.setForeground(Color.WHITE);
			empty = new JLabel();
			empty.setForeground(Color.BLACK);
			number = new JLabel("Player's number ");
			number.setForeground(Color.WHITE);
			playersCounter = new JLabel("Players");
			playersCounter.setForeground(Color.WHITE);
			playersCounter.setOpaque(false);
			playersOutput = new JLabel("Player's Info");
			playersOutput.setForeground(Color.WHITE);
//			playersOutput.setFont(Font.CENTER_BASELINE);
			playersOutput.setBackground(Color.BLACK);
//			playersOutput.setOpaque(true);
			
			//JTextFiels
			playerInput = new JTextField(10);
			teamInput = new JTextField(10);
			ageInput = new JTextField(10);
			numberInput = new JTextField(10);
			
//			//Container
//			container = new Container();
//			container.add(playersCounter,addingPlayers);
//			container.setVisible(true);
			
			//JButtons
			printPlayers = new JButton("Print Players");
			printPlayers.setBorder(border3);
			printPlayers.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Color.WHITE),BorderFactory.createEmptyBorder(5, 5, 10, 10)));
			printPlayers.setForeground(Color.WHITE);
			printPlayers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					playersInfo.setText("");
					playersInfo.append(team.getTeamPlayers());
				}
			});
			
			insertPlayers = new JButton("Insert Players");
			insertPlayers.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Color.WHITE),BorderFactory.createEmptyBorder(5, 5, 10, 10)));
			insertPlayers.setForeground(Color.WHITE);
			insertPlayers.addActionListener(new ActionListener() {
				//TODO separate logic from graphics
				public void actionPerformed(ActionEvent ae) {
					try {
					baseballPlayer.addPlayer(playerInput.getText(), teamInput.getText(),
									Integer.parseInt(numberInput.getText()), 
									Integer.parseInt(ageInput.getText()));
					addingPlayers.append(team.playersCounter());
					baseballPlayer.checkNumber();
					playerInput.setText("");
					teamInput.setText("");
					numberInput.setText("");
					ageInput.setText("");
				}
				catch(Exception E) {
					
					JOptionPane.showMessageDialog(null, "Try filling up all the boxes", "Missing boxes",JOptionPane.ERROR_MESSAGE);
					
					
				}
				}
			});
			
			clear = new JButton("Clear");
			clear.setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createLineBorder(Color.WHITE),BorderFactory.createEmptyBorder(5, 5, 10, 10)));
			clear.setForeground(Color.WHITE);
			clear.addActionListener(new ActionListener() {
				//TODO separate logic from graphics
				public void actionPerformed(ActionEvent ae) {
					try {
					
						addingPlayers.setText(null);
						playersInfo.setText(null);
				}
				catch(Exception E) {
					
					E.printStackTrace();
					
					
				}
				}
			});
			
			add(playerName);
			playerName.setBorder(border1);
			add(playerInput);
			add(teamName);
			teamName.setBorder(border2);
			add(teamInput);
			add(age);
			age.setBorder(border);
			add(ageInput);
			add(number);
			add(numberInput);
			add(empty);
			empty.setBorder(border4);
			add(insertPlayers);
			add(printPlayers);
			add(clear);

			
			jPanel2.add(playersCounter);
			playersCounter.setBorder(border5);
			jPanel2.add(new JScrollPane(addingPlayers,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),addingPlayers);
			jPanel3.add(playersOutput);
			playersOutput.setBorder(border6);
			jPanel3.add(new JScrollPane(playersInfo,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),playersInfo);
			add(jPanel2);
			add(jPanel3);
			//the JFrame setup
			window.setSize(WIDTH,HEIGHT);
			window.setBackground(Color.BLACK);
			window.setTitle(TITLE);
			window.getContentPane().add(this,BorderLayout.CENTER);
	
//			window.add(jPanel2);
		
			
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			pack();
			window.setResizable(false);
			window.setLocationRelativeTo(null);
			window.requestFocus();

			window.setVisible(true);
	}
		
	private void loadImage(String path) {
		try {
			img = ImageIO.read(BaseballCards.class.getResource(path));
		}catch(IOException e) {
			System.out.println("Image didnt load");
		}
	}
	
	protected void paintComponent(Graphics g) {

		    super.paintComponents(g);
		    
		       g.fillRect(0, 0, this.getWidth(), this.getHeight());
		       g.drawImage(img, 0, 0, 600, 400, this);
		      
		}
	public static void main(String[] args) {
		
		BaseballCards baseballCards = new BaseballCards();
	
	}
}
