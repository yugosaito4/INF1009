package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;



public class GameScreen extends Scene {

	private BitmapFont font; // Add a BitmapFont member variable to hold the font
	private String nextTargetScene;
	private String loseScene;
	private EntityManager entityManager;
	private PlayerManager playerManager;
	private CollisionManager collisionManager;
	private IOManagement ioManager;
	private SpawnManager spawnManager;
	private float timer = 0;
 
	private int maxScore = 3; //can be adjusted

	private static final float SPAWN_INTERVAL = 5f; // Interval in seconds
	
	private Sound sound;

	public GameScreen(SceneManager game, String nextTargetScene, String loseScene,EntityManager em , PlayerManager pm , SpawnManager spawner , CollisionManager cm, IOManagement im) {
		super(game, "GameworldBG.jpg");
		font = new BitmapFont();
		this.loseScene = loseScene;
		this.nextTargetScene = nextTargetScene;
        this.entityManager = em;
        this.playerManager = pm;
        this.spawnManager = spawner;
        this.collisionManager = cm;
        this.ioManager = im;
		this.playerManager.addPlayers(new playerOne("playerSkin/", "playerSkin/Close.png", 100, 200, 200, 3, 0, game));
		this.spawnManager.loadEntity();
		this.spawnManager.spawnEntityList();

		sound = new Sound();

	}

	@Override
	public void render(float delta) {

		// drawing logic
		ScreenUtils.clear(0, 0, 0.2f, 1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		playerOne player = (playerOne) playerManager.getPlayerList().get(0);
		player.drawHearts(batch, 10, Gdx.graphics.getHeight() -  100); //draw player health
		font.getData().setScale(2, 2);
		font.draw(batch, "Score: " + playerManager.getScore(0) + "/" + maxScore, 350, Gdx.graphics.getHeight() - 40); // getting score for first player
		playerManager.drawPlayers(batch); // draw player
		
	
		
		
		
		batch.end();

		// player update logic
		playerManager.update(delta);
		if (playerManager.getHealth(0) <= 0) {
			playerManager.reset(0); //reset stats
			game.setLastGameLevel(game.getCurrentSceneName()); //store level name before dispalying game over
			game.setScene(loseScene); 
		}

		if (playerManager.getScore(0) >= 3) {
			playerManager.reset(0); //reset stats
			game.setScene(nextTargetScene); 
		}

		// entity update logic
		entityManager.movement(); // move movable entities (AI)
		spawnManager.removeEatenFood();
		
		// spawn logic
		spawnManager.spawn(batch, spawnManager.getSpawnedEntityList());

		// IO and collision logic
		ioManager.handleInput(playerManager.getPlayerList()); // handle the IO
		collisionManager.checkCollisionList(playerManager.getPlayerList(), spawnManager.getSpawnedEntityList());// handle the collision

		timer += delta;

		// Check if it's time to spawn and despawn entities
		if (timer >= SPAWN_INTERVAL) {
			spawnManager.spawnAndDespawn(batch);
			timer = 0; // Reset the timer
		}
		

		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			game.setScene(nextTargetScene);
		}

	}

	@Override
	public void show() {
		sound.setFile(3);
		sound.loop();

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
		sound.stop();

	}

	public void dispose() {
		font.dispose();
		sound.clip.close();
		super.dispose();
	}
}