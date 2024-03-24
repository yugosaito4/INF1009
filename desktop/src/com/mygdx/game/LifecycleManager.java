package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import gameLayer.SpawnManager;

public class LifecycleManager extends ApplicationAdapter {
	
	private SpriteBatch batch;
	private SceneManager sceneManager;
	
	private EntityManager entityManager;
	private PlayerManager playerManager;
	private CollisionManager collisionManager;
	private IOManagement ioManager;
	private SpawnManager spawnManager;
	
	
	public void create()
	{	
		batch = new SpriteBatch(); 
		
		sceneManager = new SceneManager();
	    entityManager = new EntityManager();
	    playerManager = new PlayerManager();
	    collisionManager = new CollisionManager();
	    ioManager = new IOManagement();
	    spawnManager = new SpawnManager(entityManager);
		
		sceneManager.createScene(entityManager, playerManager, sceneManager, spawnManager, collisionManager, ioManager); //create scenes for the simulation

	}
	

	public void render()
	{
		ScreenUtils.clear(0,0,0.2f,1);
		sceneManager.render(); //render the scene texture

	}
	
	
	public void dispose()
	{
		
		if (batch != null) {
            batch.dispose();
        }
		
		sceneManager.dispose();
		
	}
	
}
