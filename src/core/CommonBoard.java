/**
 * @author mike802
 * 
 * product of - ???
 * 2017
 */
package core;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import highscores.IBoardOutline;

public class CommonBoard extends ConfigBoard{
	
	protected IBoardOutline board = null;
	protected JFrame boardPage = null;
	protected Properties properties;
	protected JDesktopPane desktopPane;
	protected ConcurrentHashMap<Integer, JButton> lookupTable2 = new ConcurrentHashMap<Integer, JButton>();
	protected boolean difficult = true;
	
	protected JMenuBar menuBar;
	protected JMenu fileMenu, options, difficulty, help;
	protected JMenuItem exit, rules, about;
	protected JCheckBoxMenuItem normal, hard, harder, randomHard, randomHarder;
	protected JCheckBoxMenuItem randomNormal;
	
	protected JButton left = null;
	protected JButton right = null;
	protected JButton top1 = null;
	protected JButton top2 = null;
	protected JButton bottom1 = null;
	protected JButton bottom2 = null;
	protected JButton middle = null;

	protected ConcurrentHashMap<JButton, Integer> lookupTable = new ConcurrentHashMap<JButton, Integer>();
	protected ArrayList<Integer> order = new ArrayList<Integer>();
	protected int count = 0;
	protected boolean showOrder = false;
	protected boolean initialized = false;
	
	protected boolean animateButton = false;
	protected int buttonCounter = 0;
	protected int selected = -1;
	
	protected boolean normalFlag = true;
	protected boolean hardFlag = false;
	protected boolean harderFlag = false;
	protected boolean randomizeFlag = false;
	
	// brand-aware lib files
	protected final String PRODUCT_NAME = "memory_game";
	
}
