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
	
	public void addEntity(Entity e)
	{
		entityList.add(e);
	}
	
	public void removeEntity(Entity e)
	{
		entityList.remove(e);
	}
	
	public void removeEatenFood() {
		entityList.removeIf(Entity::ToRemove); //remove entity
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
	
	public void movement(float width, float height)
	{
		for (Entity entity : entityList)
		{
			if(entity instanceof AIMovable)
			{
				((AIMovable) entity).AIEntityMovement(width, height);
			}		
		}
	}
	
	
}
