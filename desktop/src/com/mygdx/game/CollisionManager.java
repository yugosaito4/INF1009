package com.mygdx.game;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;


public class CollisionManager {
    
	public void checkCollisions(List<?> objects) {
	    for (int i = 0; i < objects.size(); i++) {
	        Object objA = objects.get(i);
	        if (objA instanceof iCollider) {
	            iCollider collidableA = (iCollider) objA;
	            for (int j = i + 1; j < objects.size(); j++) {
	                Object objB = objects.get(j);
	                if (objB instanceof iCollider) {
	                    iCollider collidableB = (iCollider) objB;
	                    if (overlaps(collidableA.getBounds(), collidableB.getBounds())) {
	                        collidableA.checkCollision(collidableB);
	                        collidableB.checkCollision(collidableA);
	                    }
	                }
	            }
	        }
	    }
	}
	

    private boolean overlaps(Rectangle r1, Rectangle r2) {
        return r1.x < r2.x + r2.width && r1.x + r1.width > r2.x && r1.y < r2.y + r2.height && r1.y + r1.height > r2.y;
    }
}