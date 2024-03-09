package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class LifecycleManager extends ApplicationAdapter {
	
	private SpriteBatch batch;
	private EntityManager entityManager;
	private PlayerManager playerManager;
	private CollisionManager collisionManager;
	private SceneManager sceneManager;
	private IOManagement ioManager;
	
	public void create()
	{	
		batch = new SpriteBatch(); //test comment
		
		
		
		entityManager = new EntityManager();
		entityManager.addEntity(); //add the entities into the simulation
		
		playerManager = new PlayerManager();
		playerManager.addPlayers();
		
		sceneManager = new SceneManager();
		sceneManager.create(); //create scenes for the simulation
		
		collisionManager = new CollisionManager(); 
		
		ioManager = new IOManagement(); //initialize IO manager
		
	}
	

	public void render()
	{
		ScreenUtils.clear(0,0,0.2f,1);
		
		sceneManager.render(); //render the scene texture
		playerManager.drawPlayers(batch);
		entityManager.drawEntity(batch); //draw entities 
		entityManager.movement(); //move movable entities (AI)
		ioManager.handleInput(playerManager.getPlayerList()); // handle the IO 
		collisionManager.checkCollisionList(playerManager.getPlayerList(),entityManager.getEntityList());//handle the collision
	}
	
	
	public void dispose()
	{
		
		if (batch != null) {
            batch.dispose();
        }
		
		sceneManager.dispose();
		
	}
	
}
