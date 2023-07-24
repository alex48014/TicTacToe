package game.logic;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame	{
	
	private static final long serialVersionUID = 1L;
	private CardLayout cardLayout;
	private Dimension size;
	private String title;
	
	public MainFrame(Dimension size, String title, CardLayout cardLayout)	{
		this.size = size;
		this.title = title;
		this.cardLayout = cardLayout;
	}
	
	public void init()	{
		this.setTitle(title);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(size);
		this.setMaximumSize(size);
		this.setMinimumSize(size);
		this.setLayout(cardLayout);
		this.setResizable(false);
	}
	
	public CardLayout getCardLayout()	{
		return cardLayout;
	}

}
