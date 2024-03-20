package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Player implements iMovable , iCollider{
	private float x;
	private float y;
	private Texture tex;
	private float speed;
	private int currentDirection = Keys.RIGHT;

	
	public Player()
	{
		
		
	}
	
	public Player(String texturepath, float x, float y, float speed)
	{
		this.x = x;
		this.y = y;
		this.speed = speed;
		tex = new Texture(texturepath);
	}
	
	
	

    // Input handling and movement logic
    public void handleInput() {
        if (Gdx.input.isKeyPressed(Keys.LEFT) ) {
            currentDirection = Keys.LEFT;
        } else if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            currentDirection = Keys.RIGHT;
        } else if (Gdx.input.isKeyPressed(Keys.UP)) {
            currentDirection = Keys.UP;
        } else if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            currentDirection = Keys.DOWN;
        }
    }

    public void moveBasedOnDirection() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        switch (currentDirection) {
            case Keys.LEFT:
                this.x -= this.speed * deltaTime;
                break;
            case Keys.RIGHT:
                this.x += this.speed * deltaTime;
                break;
            case Keys.UP:
                this.y += this.speed * deltaTime;
                break;
            case Keys.DOWN:
                this.y -= this.speed * deltaTime;
                break;
        }
        
        float objectWidth = tex.getWidth();
        float objectHeight = tex.getHeight();

	    float maxX = Gdx.graphics.getWidth() - objectWidth;
	    if (getX() < 0) {
	    	setX(0);
	    } else if (getX() > maxX) {
	    	setX(maxX);
	    }
	    
	    float maxY = Gdx.graphics.getHeight() - objectHeight;
		if (getY() < 0) {
			setY(0);
		} else if (getY() > maxY) {
			setY(maxY);
		}
    }

	public abstract void update();
    public abstract void UserEntityMovement();
	

	
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
