package com.mygdx.game;
import java.util.List;

public class IOManagement 
{
	public void handleInput(List<Entity> entityList) {
        for (Entity e : entityList) {
        	if(e instanceof iMovable)
			{
				((iMovable) e).UserEntityMovement();
			}		
        }
    }
}
