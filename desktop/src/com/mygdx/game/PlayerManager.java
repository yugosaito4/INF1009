package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
	
	private List<Entity> playerList;

	public PlayerManager()
	{
		playerList = new ArrayList<Entity>();
	}
	
	public void addPlayers()
	{
		playerList.add(new TextureObject("droplet.png", 100, 200, 50));
	}

}
