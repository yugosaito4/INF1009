package gameLayer;

import java.util.Random;
import com.mygdx.game.*;

public class AIEnemy extends Entity implements AIMovable, iCollider {
	private enum Direction { //2 different directions for AI to move
		HORIZONTAL, VERTICAL
	}

	private Direction currentDirection;
	private Random random = new Random();

	public AIEnemy(String imagePath, float x, float y, float s) {
		super(imagePath, x, y, s);

		currentDirection = random.nextBoolean() ? Direction.HORIZONTAL : Direction.VERTICAL;
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
	public void AIEntityMovement(float Screenwidth, float Screenheight) {
	    float objectWidth = getTex().getWidth();
	    float objectHeight = getTex().getHeight();
	    float maxX = Screenwidth - objectWidth; // Corrected to use method parameter
	    float maxY = Screenheight - objectHeight - 150; // Corrected to use method parameter

	    if (random.nextInt(100) > 98) { // probability of changing direction
	        currentDirection = (currentDirection == Direction.HORIZONTAL) ? Direction.VERTICAL : Direction.HORIZONTAL;
	    }

	    if (currentDirection == Direction.HORIZONTAL) {
	        if (getX() < 0) {
	            setX(0);
	            setSpeed(-getSpeed()); // Reverse direction when hitting a boundary
	        } else if (getX() > maxX) {
	            setX(maxX);
	            setSpeed(-getSpeed()); // Reverse direction when hitting a boundary
	        } else {
	            setX(getX() + getSpeed());
	        }
	    } else { // Vertical movement
	        if (getY() < 0) {
	            setY(0);
	            setSpeed(-getSpeed()); // Reverse vertical direction when hitting a boundary
	        } else if (getY() > maxY) {
	            setY(maxY);
	            setSpeed(-getSpeed()); // Reverse vertical direction when hitting a boundary
	        } else {
	            setY(getY() + getSpeed());
	        }
	    }
	}


}
