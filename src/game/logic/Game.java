package game.logic;

import java.awt.CardLayout;
import java.awt.Dimension;

import game.logic.panel.PanelGame;
import game.logic.panel.PanelMenu;

public class Game implements Runnable {
	
	private MainFrame mainFrame;
	private PanelMenu panelMenu;
	private PanelGame panelGame;
	private Handler handler;
	
	public static final Dimension DEFAULT_BUTTONSIZE = new Dimension(200, 100);
	public static final Dimension DEFAULT_CLICKTILESIZE = new Dimension(200, 200);
	public final static String MENUPANEL = "Panel with menu";
	public final static String GAMEPANEL = "Panel with game";
	public final static String PATH_PATTERNSDEFAULT = "res/data/patterns_default.txt";
	
	@Override
	public void run() {
		setup();
		addComponents();
		mainFrame.setVisible(true);
	}
	
	private void setup()	{
		mainFrame = new MainFrame(new Dimension(900, 635), "TicTacToe", new CardLayout());
		mainFrame.init();
		handler = new Handler(this);
		panelMenu = new PanelMenu(handler);
		panelGame = new PanelGame(handler);
		panelMenu.init();
		panelGame.init();
	}
	
	private void addComponents()	{
		mainFrame.getContentPane().add(panelMenu.getContentPanel(), MENUPANEL);
		mainFrame.getContentPane().add(panelGame.getContentPanel(), GAMEPANEL);
	}
	
	public void changeLayout(String card)	{
		mainFrame.getCardLayout().show(mainFrame.getContentPane(), card);
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public PanelMenu getPanelMenu()	{
		return panelMenu;
	}
	
	public PanelGame getPanelGame()	{
		return panelGame;
	}
	
	
}
