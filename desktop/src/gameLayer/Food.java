package gameLayer;

import com.mygdx.game.Entity;
import com.mygdx.game.Player;
import com.mygdx.game.iCollider;

public class Food extends Entity {

	private boolean eaten = false;
	protected FoodType foodType;

	public enum FoodType {
		PROTEIN, VEGETABLE, FRUIT, UNHEALTHY
	}

	public Food(String imagePath, float x, float y, float s, FoodType foodType) {
		super(imagePath, x, y, s);
		this.foodType = foodType;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	public void checkCollision(iCollider other) {
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
