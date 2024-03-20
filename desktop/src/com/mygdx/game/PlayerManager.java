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
	
	public void addPlayers(Player p)
	{
		playerList.add(p);
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
	
	public void update(float delta) {
	    for (Player player : playerList) {
	        player.update();
	    }
	}

}
