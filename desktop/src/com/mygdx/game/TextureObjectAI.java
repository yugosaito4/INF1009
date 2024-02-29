package com.mygdx.game;

public class TextureObjectAI extends Entity implements AIMovable{
	
	public TextureObjectAI(String imagePath, float x, float y, float s) {
		super(imagePath, x, y, s);
	}


	@Override
	public void AIEntityMovement() {
		if (getX() <= 0 || getX() >= 400) {
	        setSpeed(-getSpeed()); // Reverse direction when hitting a boundary
	    }
	    setX(getX() + getSpeed()); // Update position based on speed
		
	}

	@Override
	public void update() {
	}

}
