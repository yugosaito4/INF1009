package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;

public class GameScreen extends Scene{
	
	
	private BitmapFont font; // Add a BitmapFont member variable to hold the font
	private String nextTargetScene;
	private EntityManager entityManager;
	private PlayerManager playerManager;
	private CollisionManager collisionManager;
	private IOManagement ioManager;

	public GameScreen(SceneManager game, String nextTargetScene) {
		super(game, "bg2.jpg");
		font = new BitmapFont();
		this.nextTargetScene = nextTargetScene;
		
				
		entityManager = new EntityManager();
		playerManager = new PlayerManager();
		collisionManager = new CollisionManager(); 
		ioManager = new IOManagement(); //initialize IO manager
		
		
		playerManager.addPlayers(new playerOne("playerSkin/","playerSkin/Close.png", 100, 200, 100 , 3));
		
		entityManager.addEntity(new UnhealthyFood("Unhealthy/hot_dog_01.png",100,300,50)); //add the entities into the simulation
		
			
		
		

	}
	
	@Override
	public void render(float delta ) {
		
		//drawing logic
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "This is the game scene", 100, 200);
		Player player = playerManager.getPlayerList().get(0); // Assuming there's at least one player
        font.draw(batch, "Health: " + player.getHealth(), 10, Gdx.graphics.getHeight() - 10);
		playerManager.drawPlayers(batch); //draw player
		entityManager.drawEntity(batch); //draw entities 
		batch.end();
		
		//player update logic
		playerManager.update(delta);
		
		//entity update logic
		entityManager.movement(); //move movable entities (AI)
		entityManager.removeEatenFood();
		
		ioManager.handleInput(playerManager.getPlayerList()); // handle the IO 
		collisionManager.checkCollisionList(playerManager.getPlayerList(),entityManager.getEntityList());//handle the collision
		
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			game.setScene(nextTargetScene);
		}
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	
	public void dispose() {
		font.dispose();
		super.dispose();
	}
}
