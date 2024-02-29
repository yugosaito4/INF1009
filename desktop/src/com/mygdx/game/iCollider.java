package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;

public interface iCollider {
	
    Rectangle getBounds();
    public void checkCollision(iCollider other);
}
