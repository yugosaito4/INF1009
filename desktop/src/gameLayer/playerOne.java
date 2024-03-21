package gameLayer;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Player;

public class playerOne extends Player {
	
private int health;
private boolean isMouthOpen = false; // New attribute to track the mouth state
private float animationTimer = 0; // Timer to control animation state change
private float animationInterval = 0.25f; // Interval in seconds to change mouth state
private Texture openMouthTexture;
private Texture closedMouthTexture;
	
	public playerOne(String openMouthPath, String closedMouthPath, float x, float y, float s , int hp)
	{
		super(closedMouthPath, x, y, s);
		this.setHealth(hp);
		this.openMouthTexture = new Texture(openMouthPath);
	    // The closed mouth texture is already loaded by the super constructor.
	    this.closedMouthTexture = this.getTex(); // Assuming getTex() returns the current texture.
	}
	

	public void UserEntityMovement() {
        handleInput(); // Handle direction changes based on input
        moveBasedOnDirection();
    }
	
    
   
    @Override
    public void update(float deltaTime) {
        // Update the animation timer
        animationTimer += deltaTime;
        
        // Check if it's time to toggle the mouth state
        if(animationTimer >= animationInterval) {
            isMouthOpen = !isMouthOpen;
            animationTimer = 0; // Reset the timer
            
            // Update the image based on the mouth state
            if(isMouthOpen) {
                // Set the sprite or texture to the open mouth image
                this.setTex(openMouthTexture);
            } else {
                // Set the sprite or texture to the closed mouth image
                this.setTex(closedMouthTexture);
            }
        }
    }
    
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}




}
