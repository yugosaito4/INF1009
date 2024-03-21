package com.mygdx.game;

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
	public abstract boolean ToRemove();


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
		batch.draw(tex, x, y);
	}
}
