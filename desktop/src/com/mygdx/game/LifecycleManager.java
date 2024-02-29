package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class LifecycleManager extends ApplicationAdapter {
	
	private SpriteBatch batch;
	private EntityManager entityManager;
	private CollisionManager collisionManager;
	private SceneManager sceneManager;
	private IOManagement ioManager;
	
	public void create()
	{	
		batch = new SpriteBatch();
		
		entityManager = new EntityManager();
		entityManager.addEntity(); //add the entities into the simulation
		
		sceneManager = new SceneManager();
		sceneManager.create(); //create scenes for the simulation
		
		collisionManager = new CollisionManager(); 
		
		ioManager = new IOManagement(); //initialize IO manager
		
	}
	

	public void render()
	{
		ScreenUtils.clear(0,0,0.2f,1);
		
		sceneManager.render(); //render the scene texture
		entityManager.drawEntity(batch); //draw entities 
		entityManager.movement(); //move movable entities (AI)
		ioManager.handleInput(entityManager.getEntityList()); // handle the IO 
		collisionManager.checkCollisions(entityManager.getEntityList());//handle the collision
	}
	
	
	public void dispose()
	{
		
		if (batch != null) {
            batch.dispose();
        }
		
		sceneManager.dispose();
		
	}
	
}
