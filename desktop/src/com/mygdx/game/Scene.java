package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Scene implements Screen{
    protected final SceneManager game;
    protected SpriteBatch batch;
    protected Texture tex;

    public Scene(SceneManager game, String texturePath) {
        this.game = game;
        tex = new Texture(texturePath);
        batch = new SpriteBatch();
    }

    public abstract void render(float delta);

    public void dispose() {
        batch.dispose();
        tex.dispose();
    }
    
    public SpriteBatch getBatch() {
    	return batch;
    }
    
    public Texture getTex() {
    	return tex;
    }

}