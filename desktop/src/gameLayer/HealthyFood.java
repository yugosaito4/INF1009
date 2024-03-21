package gameLayer;

import com.mygdx.game.Entity;
import com.mygdx.game.Player;
import com.mygdx.game.iCollider;

public class HealthyFood extends Entity{
	
private boolean eaten = false;
	
	public HealthyFood(String imagePath, float x, float y, float s) {
		super(imagePath, x, y, s);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void checkCollision(iCollider other)
	{
		if (other instanceof Player) {
            setEaten(); // Mark this food for removal upon collision with a player
        }
	}

	public boolean isEaten() {
		return eaten;
	}

	public void setEaten() {
		this.eaten = true;
	}

	@Override
	public boolean ToRemove() {
		// TODO Auto-generated method stub
		return isEaten();
	}

}
