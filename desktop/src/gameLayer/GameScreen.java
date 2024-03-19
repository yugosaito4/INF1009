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
		entityManager.addEntity(); //add the entities into the simulation
		
		playerManager = new PlayerManager();
		playerManager.addPlayers();
		
		
		
		collisionManager = new CollisionManager(); 
		
		ioManager = new IOManagement(); //initialize IO manager
	}
	
	@Override
	public void render(float delta ) {
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "This is the game scene", 100, 200);
		batch.end();
		
		playerManager.drawPlayers(batch);
		entityManager.drawEntity(batch); //draw entities 
		entityManager.movement(); //move movable entities (AI)
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
