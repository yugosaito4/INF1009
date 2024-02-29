package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainScene extends Scene{

	public MainScene(SceneManager game) {
        super(game, "bg3.jpg" );
    }

	@Override
	public void render(float delta) {
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		
		if (Gdx.input.isTouched()) {
			game.setScene("gameScene");
		}
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}



}
