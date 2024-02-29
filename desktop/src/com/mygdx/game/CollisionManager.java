package com.mygdx.game;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;


public class CollisionManager {
    
	public void checkCollisions(List<Entity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) instanceof iCollider) {
                iCollider collidableA = (iCollider) entities.get(i);
                for (int j = i + 1; j < entities.size(); j++) {
                    if (entities.get(j) instanceof iCollider) {
                        iCollider collidableB = (iCollider) entities.get(j);
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