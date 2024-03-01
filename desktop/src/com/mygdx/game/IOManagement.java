package com.mygdx.game;
import java.util.List;

public class IOManagement 
{
	public void handleInput(List<Player> playerList) {
        for (Player p : playerList) {
			((iMovable) p).UserEntityMovement();	
        }
    }
}
