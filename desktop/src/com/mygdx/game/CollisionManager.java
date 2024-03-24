package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;


public class CollisionManager {
    private SceneManager sceneManager;

    public CollisionManager(SceneManager sceneManager){
        this.sceneManager = sceneManager;
    }
    
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

    public void checkCollisionList(List<?> players, List<?> entities) {
        List<iCollider> collidables = new ArrayList<>();
        // Combine players and entities into one list of iCollider objects
        for (Object player : players) {
            if (player instanceof iCollider) {
                collidables.add((iCollider) player);
            }
        }
        for (Object entity : entities) {
            if (entity instanceof iCollider) {
                collidables.add((iCollider) entity);
            }
        }
        
        // Now check collisions in the combined list
        checkCollisions(collidables);
    }
	

    private boolean overlaps(Rectangle r1, Rectangle r2) {
        return r1.x < r2.x + r2.width && r1.x + r1.width > r2.x && r1.y < r2.y + r2.height && r1.y + r1.height > r2.y;
    }
}