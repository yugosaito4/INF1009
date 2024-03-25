package gameLayer;

import java.util.ArrayList;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Player;
import com.mygdx.game.SceneManager;
import com.mygdx.game.iCollider;

public class playerOne extends Player {

    private boolean isMouthOpen = false; // New attribute to track the mouth state
    private float animationTimer = 0; // Timer to control animation state change
    private float animationInterval = 0.25f; // Interval in seconds to change mouth state
    private Texture upOpen, downOpen, leftOpen, rightOpen; // Open mouth Textures for the player
    
    private Texture fullHeart;
    private Texture emptyHeart;
    
    
    private Texture closedMouthTexture;
    private SceneManager sceneManager;
    ArrayList<Object> eatenFoodType = new ArrayList<Object>();

    public playerOne(String baseTexturePath, String closedMouthPath, float x, float y, float s, int hp, int score, SceneManager sceneManager) {
        super(closedMouthPath, x, y, s, hp, score);
        this.closedMouthTexture = this.getTex(); // initial texture is closed mouth

        // load directional textures
        this.upOpen = new Texture(baseTexturePath + "Up.png");
        this.downOpen = new Texture(baseTexturePath + "Down.png");
        this.leftOpen = new Texture(baseTexturePath + "Left.png");
        this.rightOpen = new Texture(baseTexturePath + "Open.png");
        
        this.fullHeart = new Texture(baseTexturePath + "HPfull.png");
        this.emptyHeart = new Texture(baseTexturePath + "HPempty.png");
        this.sceneManager = sceneManager;
        
    }

    public void UserEntityMovement() {
        handleInput(); // Handle direction changes based on input
        moveBasedOnDirection();
    }
    
    @Override
    public void update(float deltaTime) {
        animationTimer += deltaTime;

        if (animationTimer >= animationInterval) {
            isMouthOpen = !isMouthOpen;
            animationTimer = 0;
            updateTexture();
        }
    }
    
    public void drawHearts(SpriteBatch batch, float startX, float startY)
    {
    	int health = getHealth();
    	
    	for (int i = 0; i < health; i++) {
            Texture heartTexture = (i < health) ? fullHeart : emptyHeart;
            batch.draw(heartTexture, startX + (i * (fullHeart.getWidth() + 10)), startY);
    	}	
    }

    private void updateTexture() {
        Texture newTexture;
        if (isMouthOpen) {
            // Select the correct open texture based on direction
            switch (getCurrentDirection()) { // get the current direction from sueperclass
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

    // collide with food
    public void checkCollision(iCollider other) {
        String currentScene = sceneManager.getCurrentSceneName();

        if (other instanceof UnhealthyFood) {
            this.setHealth(this.getHealth() - 1);
        } else if (other instanceof AIEnemy) {
            this.setHealth(this.getHealth() - 3);
        } else if ("gameScene1".equals(currentScene) && other instanceof Protein) {
            this.setScore(this.getScore() + 1);
        } else if ("gameScene2".equals(currentScene) && other instanceof Vegetable) {
            this.setScore(this.getScore() + 1);
        } else if ("gameScene3".equals(currentScene) && other instanceof Fruits) {
            this.setScore(this.getScore() + 1);
        } else if ("gameScene4".equals(currentScene)) {
            if ((other instanceof Protein && !eatenFoodType.contains(Protein.class)) ||
                (other instanceof Vegetable && !eatenFoodType.contains(Vegetable.class)) ||
                (other instanceof Fruits && !eatenFoodType.contains(Fruits.class))) {
                this.setScore(this.getScore() + 1);
                eatenFoodType.add(other.getClass());
            }
        }
    }
}
