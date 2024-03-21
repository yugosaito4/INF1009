package gameLayer;

import com.mygdx.game.*;


public class AIEnemy extends Entity implements AIMovable,iCollider {
	
	public AIEnemy(String imagePath, float x, float y, float s) {
		super(imagePath, x, y, s);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ToRemove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void AIEntityMovement() {
		if (getX() <= 0 || getX() >= 400) {
	        setSpeed(-getSpeed()); // Reverse direction when hitting a boundary
	    }
	    setX(getX() + getSpeed()); // Update position based on speed
		
	}

}
