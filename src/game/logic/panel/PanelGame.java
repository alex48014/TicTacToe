package game.logic.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.logic.ClickTile;
import game.logic.Game;
import game.logic.Handler;
import game.logic.TilesHandler;

public class PanelGame	{

	private Handler handler;
	private JPanel contentPanel;
	private JPanel panelTiles;
	private JPanel panelButtons;
	private JPanel panelScore;
	private JLabel labelPointsRed;
	private JLabel labelPointsBlue;
	private GridBagConstraints gbc;
	private JButton buttonClose;
	private JTextField fieldScore;
	private ClickTile[] clickTiles;
	private TilesHandler tilesHandler;
	private int scoreRed = 0;
	private int scoreBlue = 0;
	
	public PanelGame(Handler handler)	{
		this.handler = handler;
	}	

	public void init()	{
		createComponents();
		createTilesPanel();
		createButtonsPanel();
		contentPanel.setLayout(new BorderLayout());
		buttonClose.setPreferredSize(new Dimension(Game.DEFAULT_BUTTONSIZE));
		fieldScore.setPreferredSize(Game.DEFAULT_BUTTONSIZE);
		arrangeComponents();
		addListeners();
		manageTilesPanel();
	}
	
	private void createComponents()	{
		contentPanel = new JPanel();
		gbc = new GridBagConstraints();
		buttonClose = new JButton("Return");
		fieldScore = new JTextField("Red   :" + scoreRed + " \nBlue : " + scoreBlue);
		tilesHandler = new TilesHandler(handler);
	}
	
	private void arrangeComponents()	{
		fieldScore.setBackground(Color.LIGHT_GRAY);
		fieldScore.setHorizontalAlignment(JTextField.CENTER);
		fieldScore.setEditable(false);
		contentPanel.add(panelTiles, BorderLayout.WEST);
		contentPanel.add(panelButtons, BorderLayout.EAST);
		handler.getGame().getMainFrame().getContentPane().add(contentPanel);
	}
	
	private void createTilesPanel()	{
		panelTiles = new JPanel();
		panelTiles.setLayout(new GridLayout(3, 3));
		panelTiles.setPreferredSize(new Dimension(600, 600));
		panelTiles.setBackground(Color.LIGHT_GRAY);
		clickTiles = new ClickTile[9];
	}
	
	private void manageTilesPanel()	{
		Thread thread = new Thread(tilesHandler);
		thread.start();
	}
	
	private void createButtonsPanel()	{
		panelScore = new JPanel();
		panelButtons = new JPanel();
		panelButtons.setPreferredSize(new Dimension(300, 600));
		panelButtons.setLayout(new GridBagLayout());
		gbc.insets = new Insets(100, 5, 5, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelButtons.add(buttonClose, gbc);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridy = 1;
		labelPointsBlue = new JLabel("Blue : " + scoreBlue);
		labelPointsBlue.setFont(new Font("Arial", Font.BOLD, 40));
		labelPointsRed = new JLabel("Red : " + scoreRed);
		labelPointsRed.setFont(new Font("Arial", Font.BOLD, 40));
		panelScore.setLayout(new BorderLayout());
		panelScore.add(labelPointsBlue, BorderLayout.NORTH);
		panelScore.add(labelPointsRed, BorderLayout.SOUTH);
		panelButtons.add(panelScore, gbc);
		
	}
	
	private void addListeners()	{
		buttonClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.getGame().changeLayout(Game.MENUPANEL);
				handler.getGame().getPanelGame().getTilesHandler().resetClickTiles();
				resetScore();
			}
		});
	}
	
	public void resetScore()	{
		this.scoreBlue = 0;
		this.scoreRed = 0;
		this.labelPointsBlue.setText("Blue : " + scoreBlue);
		this.labelPointsRed.setText("Red : " + scoreRed);
	}
	
	public TilesHandler getTilesHandler()	{
		return tilesHandler;
	}
	
	public JPanel getContentPanel()	{
		return contentPanel;
	}
	
	public ClickTile[] getClickTiles()	{
		return clickTiles;
	}
	
	public JPanel getPanelTiles()	{
		return panelTiles;
	}
	
	public int getScoreRed() {
		return scoreRed;
	}

	public void incrementScoreRed() {
		this.scoreRed ++;
		this.labelPointsRed.setText("Red : " + scoreRed);
	}

	public int getScoreBlue() {
		return scoreBlue;
	}

	public void incrementScoreBlue() {
		this.scoreBlue ++;
		this.labelPointsBlue.setText("Blue : " + scoreBlue);
	}




}
