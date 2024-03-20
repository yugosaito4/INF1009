package gameLayer;

import com.mygdx.game.Player;

public class Snake extends Player{
	
	private int health;
	
	public Snake(String imagePath, float x, float y, float s , int hp)
	{
		super(imagePath, x, y, s);
		this.setHealth(hp);
	}
	

	public void UserEntityMovement() {
        handleInput(); // Handle direction changes based on input
        moveBasedOnDirection();
    }
	
    
   
    @Override
    public void update() {

    }
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}



}

