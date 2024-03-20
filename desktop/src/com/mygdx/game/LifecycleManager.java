package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class LifecycleManager extends ApplicationAdapter {
	
	private SpriteBatch batch;
	private SceneManager sceneManager;
	
	
	public void create()
	{	
		batch = new SpriteBatch(); //test comment

		sceneManager = new SceneManager();
		sceneManager.create(); //create scenes for the simulation

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
