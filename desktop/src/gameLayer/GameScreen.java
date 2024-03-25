package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;



public class GameScreen extends Scene {

	private BitmapFont font; // Add a BitmapFont member variable to hold the font
	private String nextTargetScene;
	private EntityManager entityManager;
	private PlayerManager playerManager;
	private CollisionManager collisionManager;
	private IOManagement ioManager;
	private SpawnManager spawnManager;
	private float timer = 0;

	private int maxScore = 3;

	private static final float SPAWN_INTERVAL = 5f; // Interval in seconds

	public GameScreen(SceneManager game, String nextTargetScene ,EntityManager em , PlayerManager pm , SpawnManager spawner , CollisionManager cm, IOManagement im) {
		super(game, "bg2.jpg");
		font = new BitmapFont();
		this.nextTargetScene = nextTargetScene;

        this.entityManager = em;
        this.playerManager = pm;
        this.spawnManager = spawner;
        this.collisionManager = cm;
        this.ioManager = im;
		this.playerManager.addPlayers(new playerOne("playerSkin/", "playerSkin/Close.png", 100, 200, 100, 3, 0, game));
		this.spawnManager.loadEntity();
		this.spawnManager.spawnEntityList();



	}

	@Override
	public void render(float delta) {

		// drawing logic
		ScreenUtils.clear(0, 0, 0.2f, 1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "Health: " + playerManager.getHealth(0), 10, Gdx.graphics.getHeight() - 10); // getting health for first player
		font.draw(batch, "Score: " + playerManager.getScore(0) + "/" + maxScore, 10, Gdx.graphics.getHeight() - 40); // getting score for first player
		playerManager.drawPlayers(batch); // draw player
		batch.end();

		// player update logic
		playerManager.update(delta);
		if (playerManager.getHealth(0) <= 0) {
			game.setScene(nextTargetScene); // change to gameover, with retry
		}

		if (playerManager.getScore(0) >= 3) {
			playerManager.resetScore(0);
			game.setScene(nextTargetScene); // change to gameover, with retry
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