package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerManager {
	
	private List<Player> playerList;

	public PlayerManager()
	{
		playerList = new ArrayList<Player>();
	}
	
	public void addPlayers()
	{
		playerList.add(new TextureObject("droplet.png", 100, 200, 50));
	}
	
	public void drawPlayers(SpriteBatch batch)
	{
		for (Player player : playerList)
		{
			player.draw(batch);
		}
	}
	
	public List<Player> getPlayerList() {
        return playerList;
    }

}
