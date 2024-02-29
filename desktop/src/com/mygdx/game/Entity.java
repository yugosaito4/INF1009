package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Entity implements iCollider {
	
	private float x;
	private float y;
	private Texture tex;
	private float speed;
	
	public Entity()
	{
		
		
	}
	
	public Entity(String texturepath, float x, float y, float speed)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		tex = new Texture(texturepath);
	}
	

	
	//getter and setters
	public float getX()
	{
		return x;
	}
	
	
	public void setX(float x) {
		
		this.x = x;
	}
	
	
	public float getY()
	{
		
		return y;
	}
	
	
	public void setY(float y) {
		
		this.y = y;
	}
	
	
	public float getSpeed()
	{
		
		return speed;
	}
	
	
	public void setSpeed(float speed)
	{
		
		this.speed = speed;
	}
	
	public Texture getTex()
	{
		return tex;
	}
	
	public void setTex(Texture tex)
	{
		this.tex = tex;
	}
	
	
	
	public abstract void update();
	
	//movement logic
	void movementX(int leftKey, int rightKey) {
		if (Gdx.input.isKeyPressed(leftKey)) setX(getX() - 200 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(rightKey)) setX(getX() + 200 * Gdx.graphics.getDeltaTime());
		
	    // get the width of the texture img
		float objectWidth = tex.getWidth();

	    float maxX = Gdx.graphics.getWidth() - objectWidth;
	    if (getX() < 0) {
	    	setX(0);
	    } else if (getX() > maxX) {
	    	setX(maxX);
	    }
	}
	void movementY(int upKey, int downKey) {
		if (Gdx.input.isKeyPressed(upKey)) setY(getY() + 200 * Gdx.graphics.getDeltaTime());
		if (Gdx.input.isKeyPressed(downKey)) setY(getY() - 200 * Gdx.graphics.getDeltaTime());
		
		float objectHeight = tex.getHeight();
		
		float maxY = Gdx.graphics.getHeight() - objectHeight;
		if (getY() < 0) {
			setY(0);
		} else if (getY() > maxY) {
			setY(maxY);
		}
	}

	//collision logic
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,tex.getWidth(),tex.getHeight());
	}
	
	public void checkCollision(iCollider other) {
	    System.out.println(this.getClass().getSimpleName() + " collided with " + other.getClass().getSimpleName());
	}

	
	//draw
	public void draw(SpriteBatch batch)
	{
		batch.begin();
			batch.draw(tex, x, y);
		batch.end();
	}
}
