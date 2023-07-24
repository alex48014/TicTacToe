package game.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextHandler {
	
	
	private String patternsString;
	private String[] patternsDefault;
	
	public void readFileCharacters(String path)	{
		readWholeText(path);
		cutText();
	}
	
	private void readWholeText(String path)	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while (line != null)	{
				sb.append(line);
				line = br.readLine();
			}
			br.close();
			patternsString = sb.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void cutText()	{
		patternsDefault = patternsString.split(" +");
	}
	
	public String convertToPattern(ClickTile[] clickTiles)	{
		String currentGamePattern = "";
		
		for (int i = 0; i<clickTiles.length; i++)	{
			if (clickTiles[i].getState() == 0)	{
				currentGamePattern += "0";
			} else if (clickTiles[i].getState() == 1)	{
				currentGamePattern += "1";
			} else if (clickTiles[i].getState() == 2)	{
				currentGamePattern += "2";
			}
		}
		return currentGamePattern;
	}
	
	public boolean hasPatternMatched(String currentGamePattern)	{
		return compareCurrentPatternWithPatterns(currentGamePattern);
	}
	
	private boolean compareCurrentPatternWithPatterns(String currentGamePattern)	{	
		for (int i = 0; i<patternsDefault.length; i++)	{
			
			if (currentGamePattern.matches(patternsDefault[i].toString()))	{
				return true;
			} 
		}
		return false;
	}

	public String getPatternsString() {
		return patternsString;
	}

	public String[] getPatternsDefault() {
		return patternsDefault;
	}
}
