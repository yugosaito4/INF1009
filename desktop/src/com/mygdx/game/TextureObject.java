package com.mygdx.game;

import com.badlogic.gdx.Input.Keys;

public class TextureObject extends Entity implements iMovable{
	
	public TextureObject(String imagePath, float x, float y, float s) {
		super(imagePath, x, y, s);
	}

	@Override
	public void update() {
	}
	

	@Override
	public void UserEntityMovement() {
		movementX(Keys.LEFT, Keys.RIGHT);
		movementY(Keys.UP, Keys.DOWN);
	}


}