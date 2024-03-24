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
	        player.update(delta);
	    }
	}
	
	public int getHealth(int index)
	{
		if (!playerList.isEmpty()) {
            return playerList.get(index).getHealth();
        } else {
            return 0; // Or some other default value indicating no players are available
        }
	}

	public int getScore(int index)
	{
		if (!playerList.isEmpty()) {
            return playerList.get(index).getScore();
        } else {
            return 0; // Or some other default value indicating no players are available
        }
	}
	
	public void setScore(int index)
	{
		if (!playerList.isEmpty()) {
            playerList.get(0).setScore(0);
		}
	}
	


}
