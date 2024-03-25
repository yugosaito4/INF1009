package gameLayer;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Player;
import com.mygdx.game.SceneManager;
import com.mygdx.game.iCollider;

public class playerOne extends Player {
	
private boolean isMouthOpen = false; // New attribute to track the mouth state
private float animationTimer = 0; // Timer to control animation state change
private float animationInterval = 0.25f; // Interval in seconds to change mouth state
private Texture upOpen, downOpen, leftOpen, rightOpen; // Open mouth Textures for the player
private Texture closedMouthTexture;
private SceneManager sceneManager;
private Sound soundManager;
	
	public playerOne(String baseTexturePath, String closedMouthPath, float x, float y, float s , int hp, SceneManager sceneManager)
	{
		super(closedMouthPath, x, y, s , hp);
	    this.closedMouthTexture = this.getTex(); //initial texture is closed mouth
	    
	    //load directional textures
	    this.upOpen = new Texture(baseTexturePath+ "Up.png");
	    this.downOpen = new Texture(baseTexturePath + "Down.png");
        this.leftOpen = new Texture(baseTexturePath + "Left.png");
        this.rightOpen = new Texture(baseTexturePath + "Open.png");
        this.sceneManager = sceneManager;
        soundManager = new Sound();
	}
	

	public void UserEntityMovement() {
        handleInput(); // Handle direction changes based on input
        moveBasedOnDirection();
    }
	
    
   
	@Override
    public void update(float deltaTime) {
        animationTimer += deltaTime;

        if(animationTimer >= animationInterval) {
            isMouthOpen = !isMouthOpen;
            animationTimer = 0;
            updateTexture();
        }
    }

    private void updateTexture() {
        Texture newTexture;
        if (isMouthOpen) {
            // Select the correct open texture based on direction
            switch (getCurrentDirection()) { //get the current direction from sueperclass
                case Keys.UP:
                    newTexture = upOpen;
                    break;
                case Keys.DOWN:
                    newTexture = downOpen;
                    break;
                case Keys.LEFT:
                    newTexture = leftOpen;
                    break;
                case Keys.RIGHT:
                    newTexture = rightOpen;
                    break;
                default:
                    newTexture = closedMouthTexture;
                    break;
            }
        } else {
            // Use the single closed-mouth texture
            newTexture = closedMouthTexture;
        }
        this.setTex(newTexture);
    }
    
    //collide with unhealthy food
    public void checkCollision(iCollider other) {
        String currentScene = sceneManager.getCurrentSceneName();

        if (other instanceof UnhealthyFood) {
            this.setHealth(this.getHealth() - 1);
            soundManager.setFile(2); 
            soundManager.play();
        } 
        else if (other instanceof AIEnemy) {
            this.setHealth(this.getHealth() - 3);
            soundManager.setFile(2); 
            soundManager.play();
        } 
        else if ("gameScene1".equals(currentScene) && other instanceof Protein){        	
            this.setScore(this.getScore() + 1);
            soundManager.setFile(1); 
            soundManager.play();
        }
        else if ("gameScene2".equals(currentScene) && other instanceof Vegetable){
            this.setScore(this.getScore() + 1);
            soundManager.setFile(1); 
            soundManager.play();
        }
        else if ("gameScene3".equals(currentScene) && other instanceof Fruits){
            this.setScore(this.getScore() + 1);
            soundManager.setFile(1); 
            soundManager.play();
        }
        else if ("gameScene4".equals(currentScene) && other instanceof Fruits || other instanceof Vegetable || other instanceof Protein){
            this.setScore(this.getScore() + 1);
            soundManager.setFile(1); 
            soundManager.play();
        }
    }
}
