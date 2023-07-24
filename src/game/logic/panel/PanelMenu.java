package game.logic.panel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import game.logic.Game;
import game.logic.Handler;
import game.logic.ImageLoader;

public class PanelMenu	{
	
	private Handler handler;
	private JButton button_start;
	private JButton button_close;
	private JPanel contentPanel;
	private JLabel labelPicture;
	private GridBagConstraints gbc;
	private BufferedImage logo;
	
	public PanelMenu(Handler handler)	{
		this.handler = handler;
	}
	
	public void init()	{
		createComponents();
		contentPanel.setLayout(new GridBagLayout());
		arrangeComponents();
		addListeners();
	}
	
	private void createComponents()	{
		button_start = new JButton("Start game");
		button_close = new JButton("Exit");
		contentPanel = new JPanel();
		logo = ImageLoader.loadImage("/gfx/logo.png");
		labelPicture = new JLabel(new ImageIcon(logo));
		gbc = new GridBagConstraints();
		
	}
	
	private void arrangeComponents()	{
		button_start.setPreferredSize(Game.DEFAULT_BUTTONSIZE);
		button_close.setPreferredSize(Game.DEFAULT_BUTTONSIZE);
		gbc.fill = GridBagConstraints.CENTER;
		gbc.insets = new Insets(10, 0, 10, 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		contentPanel.add(labelPicture, gbc);
		gbc.gridy = 1;
		contentPanel.add(button_start, gbc);
		gbc.gridy = 2;
		contentPanel.add(button_close, gbc);
		handler.getGame().getMainFrame().getContentPane().add(contentPanel);
	}
	
	private void addListeners()	{
		button_start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				handler.getGame().changeLayout(Game.GAMEPANEL);
			}
		});
		
		button_close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public Component getContentPanel() {
		return contentPanel;
	}
}
