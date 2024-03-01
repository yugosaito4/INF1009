package com.mygdx.game;

import com.badlogic.gdx.Input.Keys;

public class TextureObject2 extends Player{
	
	public TextureObject2(String imagePath, float x, float y, float s) {
		super(imagePath, x, y, s);
	}

	@Override
	public void update() {
	}
	

	@Override
	public void UserEntityMovement() {
		movementX(Keys.A, Keys.D);
		movementY(Keys.W, Keys.S);
	}


}