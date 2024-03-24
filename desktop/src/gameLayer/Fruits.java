package gameLayer;

import com.mygdx.game.Player;
import com.mygdx.game.iCollider;

public class Fruits extends Food{
	
	private boolean eaten = false;
	
	public Fruits(String imagePath, float x, float y, float s) {
		super(imagePath, x, y, s, FoodType.FRUIT);
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

	public FoodType getFoodType(){
		return foodType;
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
