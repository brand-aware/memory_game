/**
 * @author mike802
 * 
 * ??? - 2013
 */
package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import highscores.HighScores;
import highscores.IBoardOutline;
import highscores.hsProperties;

public class Board extends UtilsBoardActions implements IBoardOutline{
	
	private ButtonHandler handler;
	private MenuHandler menuHandler;
		
	public Board(Properties p) {
		board = this;
		properties = p;
		
		handler = new ButtonHandler();
		menuHandler = new MenuHandler();
	}
	
	private void createGUI(){
		boardPage = new JFrame(HEADER);
		boardPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		boardPage.setResizable(false);
		boardPage.setLocation(150, 50);
		String imageDir = properties.getImageDir();
		Image icon = Toolkit.getDefaultToolkit().getImage(imageDir + File.separator + "company.png");
		boardPage.setIconImage(icon);
		boardPage.setPreferredSize(new Dimension(833, 539 + 166 + 28));
		
		int titlex = 674;
		int titley = 136;
		JLabel title = new JLabel();
		ImageIcon titleImage = new ImageIcon(imageDir + File.separator + "logo.png");
		title.setIcon(titleImage);
		int titlexoffset = (833 / 2) - (674 / 2); 
		title.setBounds(titlexoffset, 15, titlex, titley);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 833, 510 + 166 + 28);
		JLabel background = new JLabel();
		ImageIcon backgroundImage = new ImageIcon(properties.getImageDir() + File.separator + "background.png");
		background.setIcon(backgroundImage);
		background.setBounds(0, 0, 833, 510 + 166 + 28);
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("file");
		options = new JMenu("options");
		difficulty = new JMenu("difficulty");
		help = new JMenu("help");
		
		exit = new JMenuItem("exit");
		exit.addActionListener(menuHandler);
		normal = new JCheckBoxMenuItem("normal");
		normal.addActionListener(menuHandler);
		normal.setSelected(true);
		hard = new JCheckBoxMenuItem("hard");
		hard.addActionListener(menuHandler);
		harder = new JCheckBoxMenuItem("harder");
		harder.addActionListener(menuHandler);
		randomNormal = new JCheckBoxMenuItem("random normal");
		randomNormal.addActionListener(menuHandler);
		randomHard = new JCheckBoxMenuItem("random hard");
		randomHard.addActionListener(menuHandler);
		randomHarder = new JCheckBoxMenuItem("random harder");
		randomHarder.addActionListener(menuHandler);
		rules = new JMenuItem("rules");
		rules.addActionListener(menuHandler);
		about = new JMenuItem("about");
		about.addActionListener(menuHandler);
		
		fileMenu.add(exit);
		options.add(difficulty);
		difficulty.add(normal);
		difficulty.add(hard);
		difficulty.add(harder);
		difficulty.add(randomNormal);
		difficulty.add(randomHard);
		difficulty.add(randomHarder);
		help.add(rules);
		help.add(about);
		menuBar.add(fileMenu);
		menuBar.add(options);
		menuBar.add(help);
		boardPage.setJMenuBar(menuBar);		
		
		left = new JButton(LEFT_LABEL);
		left.setBounds(5, 105 + 166, LEFT_WIDTH, LEFT_HEIGHT);	
		left.addActionListener(handler);
		left.setBackground(Color.LIGHT_GRAY);
		
		right = new JButton(RIGHT_LABEL);
		int rightXcoord = LEFT_WIDTH + 5 + MIDDLE_WIDTH + 5 + 5;
		right.setBounds(rightXcoord, 105 + 166, RIGHT_WIDTH, RIGHT_HEIGHT);
		right.addActionListener(handler);
		right.setBackground(Color.LIGHT_GRAY);
		
		middle = new JButton(CENTER_AREA);
		middle.setBounds(105 + 5, 105 + 166, MIDDLE_WIDTH, MIDDLE_HEIGHT);
		middle.addActionListener(handler);
		middle.setBackground(Color.LIGHT_GRAY);
				
		top1 = new JButton(TOP1_LABEL);
		top1.setBounds(105 + 5, 166, TOP1_WIDTH, TOP1_HEIGHT);
		top1.addActionListener(handler);
		top1.setBackground(Color.LIGHT_GRAY);
		
		top2 = new JButton(TOP2_LABEL);
		top2.setBounds(105 + TOP1_WIDTH + 5 + 5, 166, TOP2_WIDTH, TOP1_HEIGHT);
		top2.addActionListener(handler);
		top2.setBackground(Color.LIGHT_GRAY);		
		
		bottom1 = new JButton(BOTTOM1_LABEL);
		bottom1.setBounds(105 + 5, TOP1_HEIGHT + MIDDLE_HEIGHT + 10 + 166, BOTTOM1_WIDTH, BOTTOM1_HEIGHT);
		bottom1.addActionListener(handler);
		bottom1.setBackground(Color.LIGHT_GRAY);
		
		bottom2 = new JButton(BOTTOM2_LABEL);
		bottom2.setBounds(105 + BOTTOM1_WIDTH + 5 + 5, TOP1_HEIGHT + MIDDLE_HEIGHT + 10 + 166, BOTTOM2_WIDTH, BOTTOM2_HEIGHT);
		bottom2.addActionListener(handler);
		bottom2.setBackground(Color.LIGHT_GRAY);
		
		desktopPane.add(background);
		desktopPane.add(title);
		desktopPane.add(top1);
		desktopPane.add(top2);
		desktopPane.add(right);
		desktopPane.add(middle);
		desktopPane.add(left);
		desktopPane.add(bottom1);
		desktopPane.add(bottom2);
		
		desktopPane.moveToFront(title);
		desktopPane.moveToFront(top1);
		desktopPane.moveToFront(top2);
		desktopPane.moveToFront(right);
		desktopPane.moveToFront(middle);
		desktopPane.moveToFront(left);
		desktopPane.moveToFront(bottom1);
		desktopPane.moveToFront(bottom2);
		
		// initialize promoted difficulty for roll-out
		normal.setSelected(false);
		hard.setSelected(false);
		harder.setSelected(false);
		randomNormal.setSelected(true);
		randomHard.setSelected(false);
		randomHarder.setSelected(false);
		normalFlag = true;
		hardFlag = false;
		harderFlag = false;
		randomizeFlag = true;
		
		boardPage.add(desktopPane);
		boardPage.pack();
		boardPage.setVisible(true);
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(!showOrder){
				if(event.getSource() == top1){
					try {
						selected = lookupTable.get(top1);
						animateButton = true;
						top1();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else if(event.getSource() == top2){
					try {
						selected = lookupTable.get(top2);
						animateButton = true;
						top2();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else if(event.getSource() == left){
					try {
						selected = lookupTable.get(left);
						animateButton = true;
						left();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else if(event.getSource() == right){
					try {
						selected = lookupTable.get(right);
						animateButton = true;
						right();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else if(event.getSource() == bottom1){
					try {
						selected = lookupTable.get(bottom1);
						animateButton = true;
						bottom1();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else if(event.getSource() == bottom2){
					try {
						selected = lookupTable.get(bottom2);
						animateButton = true;
						bottom2();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}else if(event.getSource() == middle){
					order = new ArrayList<Integer>();
					doMove();
					showOrder = true;
				}
			}
		}
	}
	
	private class MenuHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == exit){
				System.exit(0);
			}else if(event.getSource() == normal){
				normal.setSelected(true);
				hard.setSelected(false);
				harder.setSelected(false);
				randomHard.setSelected(false);
				randomHarder.setSelected(false);
				normalFlag = true;
				hardFlag = false;
				harderFlag = false;
				randomizeFlag = false;
			}else if(event.getSource() == hard){
				normal.setSelected(false);
				hard.setSelected(true);
				harder.setSelected(false);
				randomHard.setSelected(false);
				randomHarder.setSelected(false);
				normalFlag = false;
				hardFlag = true;
				harderFlag = false;
				randomizeFlag = false;
			}else if(event.getSource() == harder){
				normal.setSelected(false);
				hard.setSelected(false);
				harder.setSelected(true);
				randomHard.setSelected(false);
				randomHarder.setSelected(false);
				normalFlag = false;
				hardFlag = false;
				harderFlag = true;
				randomizeFlag = false;
			}else if(event.getSource() == randomNormal){
				normal.setSelected(false);
				hard.setSelected(false);
				harder.setSelected(false);
				randomNormal.setSelected(true);
				randomHard.setSelected(false);
				randomHarder.setSelected(false);
				normalFlag = true;
				hardFlag = false;
				harderFlag = false;
				randomizeFlag = true;
			}else if(event.getSource() == randomHard){
				normal.setSelected(false);
				hard.setSelected(false);
				harder.setSelected(false);
				randomHard.setSelected(true);
				randomHarder.setSelected(false);
				normalFlag = false;
				hardFlag = true;
				harderFlag = false;
				randomizeFlag = true;
			}else if(event.getSource() == randomHarder){
				normal.setSelected(false);
				hard.setSelected(false);
				harder.setSelected(false);
				randomHard.setSelected(false);
				randomHarder.setSelected(true);
				normalFlag = false;
				hardFlag = false;
				harderFlag = true;
				randomizeFlag = true;				
			}else if(event.getSource() == rules){
				JOptionPane.showMessageDialog(null, "game rules:"
						+ "\n\nnormal difficulty - plays one new pattern"
						+ "component at a time"
						+ "\n\nhard difficulty - plays two new pattern components"
						+ "at a time"
						+ "\n\nharder difficulty - changes the first five pattern"
						+ "components every time a player reaches a pattern"
						+ "divisible by 5 (5, 10, 15, 20, etc)", 
						"game rules", 
						JOptionPane.INFORMATION_MESSAGE, 
						new ImageIcon(properties.getImageDir() + File.separator + "company.png"));
			}else if(event.getSource() == about){
				
			}
			
		}
	}
	
	public void move(){
		if(showOrder){
			if(!animateButton){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				playOrder();
				showOrder = false;
			}
		}
		
		if(animateButton){
			if(buttonCounter > 5){
				lookupTable2.get(selected).setBackground(Color.LIGHT_GRAY);
				animateButton = false;
				buttonCounter = 0;
			}else if(buttonCounter > 0 && buttonCounter <= 5){
				buttonCounter++;
			}else if(buttonCounter == 0){
				lookupTable2.get(selected).setBackground(getColor(selected));
				buttonCounter++;
			}
		}
	}
	
	private void playOrder(){
		JButton button;
		if(randomizeFlag){
			if(order.size() > 1 && order.size() % 1 == 0){
				randomizeLookupTable();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		int size = order.size();
		for(int x = 0; x < size; x++){
			int index = order.get(x);
			button = lookupTable2.get(index);
			setColor(button);
			try {
				Thread.sleep(350);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			button.setBackground(Color.LIGHT_GRAY);
			try {
				Thread.sleep(75);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void randomizeLookupTable(){
		Collection<Integer> selectedButtons = new TreeSet<Integer>();
		Map<Integer, JButton> changes = new TreeMap<Integer, JButton>();
		for(int x = 0; x < BUTTONS; x++){
			int index = (int)(Math.random() * ((double) BUTTONS));
			while(selectedButtons.contains(index)){
				index = (int)(Math.random() * ((double) BUTTONS));
			}
			selectedButtons.add(index);
			JButton button = lookupTable2.get(x);
			changes.put(index, button);
		}
		for(int x = 0; x < BUTTONS; x++){
			JButton button = changes.get(x);
			button.setText(getButtonText(x));
			lookupTable.put(button, x);
			lookupTable2.put(x, button);
		}
	}
	
	private void setColor(JButton button){
		if(button.getText().compareTo("blue") == 0){
			button.setBackground(Color.BLUE);
		}else if(button.getText().compareTo("black") == 0){
			button.setBackground(Color.BLACK);
		}else if(button.getText().compareTo("yellow") == 0){
			button.setBackground(Color.YELLOW);
		}else if(button.getText().compareTo("orange") == 0){
			button.setBackground(Color.ORANGE);
		}else if(button.getText().compareTo("red") == 0){
			button.setBackground(Color.RED);
		}else if(button.getText().compareTo("green") == 0){
			button.setBackground(Color.GREEN);
		}
	}
	
	private Color getColor(int buttonIndex){
		if(buttonIndex == 0){
			return Color.BLUE;
		}else if(buttonIndex == 1){
			return Color.BLACK;
		}else if(buttonIndex == 2){
			return Color.GREEN;
		}else if(buttonIndex == 3){
			return Color.YELLOW;
		}else if(buttonIndex == 4){
			return Color.RED;
		}else if(buttonIndex == 5){
			return Color.ORANGE;
		}
		return null;
	}
	
	public void init(){
		if(!initialized){
			createGUI();
			initialized = true;
		}
		createLookupTable();
	}

	@Override
	public void enable() {
		fileMenu.setEnabled(true);
		options.setEnabled(true);
		help.setEnabled(true);
		
		left.setEnabled(true);
		right.setEnabled(true);
		top1.setEnabled(true);
		top2.setEnabled(true);
		bottom1.setEnabled(true);
		bottom2.setEnabled(true);
		middle.setEnabled(true);
	}

	@Override
	public void initHighScores(hsProperties p) {
		HighScores highScores = new HighScores(this);
		try {
			highScores.init(p);
			desktopPane.add(highScores);
			desktopPane.moveToFront(highScores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initHighScores(String name, String rank, int score, hsProperties p) {
		HighScores highScores = new HighScores(this);
		try {
			highScores.init(name, rank, score, p);
			desktopPane.add(highScores);
			desktopPane.moveToFront(highScores);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public int getFrameHeight() {
		return 539 + 166 + 28;
	}

	@Override
	public int getFrameWidth() {
		return 833;
	}
	
	
}
