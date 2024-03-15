package com.mygdx.game;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class EntityManager {
	
	private List<Entity> entityList;

	public EntityManager()
	{
		entityList = new ArrayList<Entity>();
	}
	
	
	
	public void addEntity()
	{
		entityList.add(new TextureObjectStatic("bucket.png",100,300,50));
		entityList.add(new TextureObjectAI("bucket.png",200,300,1));
	}
	
	public void removeEntity(Entity e)
	{
		entityList.remove(e);
	}
	
	public List<Entity> getEntityList() {
        return entityList;
    }
	
	public void drawEntity(SpriteBatch batch)
	{
		for (Entity entity : entityList)
		{
			entity.draw(batch);
		}
	}
	
	public void movement()
	{
		for (Entity entity : entityList)
		{
			if(entity instanceof AIMovable)
			{
				((AIMovable) entity).AIEntityMovement();
			}		
		}
	}
	
	
}
