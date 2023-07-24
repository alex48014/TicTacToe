package game.logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ClickTile extends JLabel	{
	
	private static final long serialVersionUID = 1L;
	private int state;
	private BufferedImage image_stateX = ImageLoader.loadImage("/gfx/xo_xbord.png");
	private BufferedImage image_stateO = ImageLoader.loadImage("/gfx/xo_obord.png");
	private BufferedImage image_stateEmpty = ImageLoader.loadImage("/gfx/xo_empty.png");
	private Handler handler;
	private TilesHandler tilesHandler;
	
	public ClickTile(Handler handler)	{
		this.handler = handler;
		init();
		
	}
	
	private void init()	{
		this.setPreferredSize(Game.DEFAULT_CLICKTILESIZE);
		this.tilesHandler = handler.getGame().getPanelGame().getTilesHandler();
		checkState();
		addListeners();
	}
	
	public void checkState()	{
		switch(state)	{
		case 0: 
			this.setIcon(new ImageIcon(image_stateEmpty));
			break;
		case 1:
			this.setIcon(new ImageIcon(image_stateO));
			break;
		case 2:
			this.setIcon(new ImageIcon(image_stateX));
			break;
		default: System.out.println("WARNING : State not default value");
				 break;
		}
	}
	
	public void setState(int state)	{
		this.state = state;
		checkState();
	}
	
	private void addListeners()	{
		
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tilesHandler.getTurn() == 1 && state == 0)	{
					setState(1);
					tilesHandler.setTurn(2);
				} else if (tilesHandler.getTurn() == 2 && state == 0)	{
					setState(2);
					tilesHandler.setTurn(1);
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		
		});
	}
	
	public int getState()	{
		return state;
	}

	

}
