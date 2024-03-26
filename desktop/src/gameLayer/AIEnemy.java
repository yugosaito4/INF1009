package gameLayer;
import java.util.Random;
import com.mygdx.game.*;


public class AIEnemy extends Entity implements AIMovable,iCollider {
    private enum Direction {
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
		if (random.nextInt(100) > 98) { //probability of changing direction
            currentDirection = (currentDirection == Direction.HORIZONTAL) ? Direction.VERTICAL : Direction.HORIZONTAL;
        }
		
		
		if (currentDirection == Direction.HORIZONTAL) {
            if (getX() <= 0 || getX() >= Screenwidth) {
                setSpeed(-getSpeed()); // Reverse direction when hitting a boundary
            }
            setX(getX() + getSpeed());
        } else {
            // Vertical movement logic
            if (getY() <= 0 || getY() >= Screenheight) {
            	setSpeed(-getSpeed()); // Reverse vertical direction when hitting a boundary
            }
            setY(getY() + getSpeed());
        }


		
	}

}
