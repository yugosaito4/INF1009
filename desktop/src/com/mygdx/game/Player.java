package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Player {
	
	private List<Entity> playerList;

	public Player()
	{
		playerList = new ArrayList<Entity>();
	}
	
	
	public void addPlayer()
	{
		playerList.add(new TextureObject("droplet.png", 100, 200, 50));
		playerList.add(new TextureObjectStatic("bucket.png",100,300,50));
		playerList.add(new TextureObjectAI("bucket.png",200,300,1));
	}
	
	public void removePlayer(Entity e)
	{
		
		playerList.remove(e);
	}
	
	public List<Entity> getPlayerList() {
        return playerList;
    }
	
	public void drawPlayer(SpriteBatch batch)
	{
		for (Entity entity : playerList)
		{
			entity.draw(batch);
		}
	}
	
	public void movement()
	{
		for (Entity entity : playerList)
		{
			if(entity instanceof AIMovable)
			{
				((AIMovable) entity).AIEntityMovement();
			}		
		}
	}

}
