package game.logic;

import javax.swing.JPanel;

public class TilesHandler implements Runnable {

	private Handler handler;
	private ClickTile[] clickTiles;
	private JPanel panelTiles;
	private TextHandler textHandler;
	private int activeTiles = 0;
	private int turn;
	private boolean win = false;
	
	public TilesHandler(Handler handler)	{
		this.handler = handler;
		this.textHandler = new TextHandler();
		this.turn = 1;
	}
	
	@Override
	public void run() {
		initializeComponents();
		checkForChanges();
	}
	
	public void initializeComponents()	{
		clickTiles = handler.getGame().getPanelGame().getClickTiles();
		panelTiles = handler.getGame().getPanelGame().getPanelTiles();
		textHandler.readFileCharacters(Game.PATH_PATTERNSDEFAULT);
		
		for(int x = 0; x<9; x++)	{
			clickTiles[x] = new ClickTile(handler);
			panelTiles.add(clickTiles[x]);
		}
	}
	
	private void checkForChanges()	{
		while(true)	{
			activeTiles = 0;
			for(int x = 0; x<9; x++)	{
				if(clickTiles[x].getState() > 0 && clickTiles[x].getState() < 3)	{
					activeTiles++;
					if(activeTiles >= 9)	{
						resetClickTiles();
						win = false;
					} else if (turn == 1 && win)	{
						handler.getGame().getPanelGame().incrementScoreRed();
						resetClickTiles();
						win = false;
					} else if(turn == 2 && win)	{
						handler.getGame().getPanelGame().incrementScoreBlue();
						resetClickTiles();
						win = false;
					}
				}
			}
			String currentGamePattern = textHandler.convertToPattern(clickTiles);
			if(textHandler.hasPatternMatched(currentGamePattern))	{
				win = true;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void resetClickTiles()	{
		for(int x = 0; x<9; x++)	{
			clickTiles[x].setState(0);
		}
	}
	
	public int getTurn()	{
		return turn;
	}
	
	public void setTurn(int turn)	{
		this.turn = turn;
	}

}
