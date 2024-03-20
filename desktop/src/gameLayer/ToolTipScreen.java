package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.*;

public class ToolTipScreen extends Scene{
	private BitmapFont font; // Add a BitmapFont member variable to hold the font
	private String toolTipText;
	private Stage stage;
	private Button startGameButton;

	public ToolTipScreen(SceneManager game, String toolTipText, String targetNextScene) {
		super(game, "bg1.jpg");
		font = new BitmapFont();
		this.toolTipText = toolTipText;
		
		stage = new Stage(new ScreenViewport()); // Use the current screen size
        Gdx.input.setInputProcessor(stage); // Set input processor
        
        // Initialize the skin (You need to have a skin, uiskin.json file in your assets)
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        // Create and set up the start game button
        startGameButton = new TextButton("Start Game", skin);
        startGameButton.setPosition(270, 100); // Adjust position to match your needs
        startGameButton.setSize(200, 50); // Adjust size to match your needs

        // Add the button to the stage
        stage.addActor(startGameButton);

        // Button click listener
        startGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle button click
                game.setScene(targetNextScene);
            }
        });
		
	}
	
	@Override
	public void render(float delta ) {
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "Tool Tips!", 270, 450);
		font.draw(batch, "The objective of the game is to control the snake and eat all the "
				+ "healthy food, while avoiding ", 30, 300);
		font.draw(batch, "the unhealthy ones! In each stage, there will"
				+ " be different category of healthy food that you ", 30, 280);
		font.draw(batch,  "would have to eat specifically.", 30, 260);
		font.draw(batch, toolTipText,30, 240);
		
		batch.end();
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
	}

	@Override
	public void show() {
		// Set the stage as the input processor
        Gdx.input.setInputProcessor(stage);
		
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
		stage.dispose();
		super.dispose();
	}
}