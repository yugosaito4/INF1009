package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;

import gameLayer.Food.FoodType;

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
		entityManager.addEntity(new UnhealthyFood("Unhealthy/pizza_01.png",100,400,50)); //add the entities into the simulation
		entityManager.addEntity(new UnhealthyFood("Unhealthy/cupcake.png",200,400,50)); //add the entities into the simulation
		entityManager.addEntity(new Fruits("Fruits/apple.png",100,100,50)); //add the entities into the simulation
		entityManager.addEntity(new Vegetable("Vegetables/bok_choy.png",200,300,50)); //add the entities into the simulation
		entityManager.addEntity(new AIEnemy("Unhealthy/popsicle.png", 50, 200, 1));
		

	}
	
	@Override
	public void render(float delta ) {
		
		//drawing logic
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        font.draw(batch, "Health: " + playerManager.getHealth(0), 10, Gdx.graphics.getHeight() - 10); //getting health for first player
		playerManager.drawPlayers(batch); //draw player
		entityManager.drawEntity(batch); //draw entities 
		batch.end();
		
		//player update logic
		playerManager.update(delta);
		if(playerManager.getHealth(0) <=0)
		{
			game.setScene(nextTargetScene); //change to gameover, with retry
		}
		
		//entity update logic
		entityManager.movement(); //move movable entities (AI)
		entityManager.removeEatenFood(); //remove entity during run time
		
		
		//IO and collision logic
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
