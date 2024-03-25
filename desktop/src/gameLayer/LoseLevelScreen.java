package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.*;

public class LoseLevelScreen extends Scene{
	
    private float screenWidth = Gdx.graphics.getWidth();
    private float screenHeight = Gdx.graphics.getHeight();
	
    private static final int buttonWidth = 300;
    private static final int buttonHeight = 50;
    

    private float playAgain_button_x = (screenWidth - buttonWidth)/2;
    private float playAgain_button_y = ((screenHeight - buttonHeight)/2) - 300;

	private Stage stage;
	private Button nextButton;

	public LoseLevelScreen(SceneManager game) {
		super(game, "Lose.png");
		stage = new Stage(new ScreenViewport()); // Use the current screen size
        Gdx.input.setInputProcessor(stage); // Set input processor
        
        
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        // Create and set up the start game button
        nextButton = new TextButton("Try Again", skin);
        nextButton.setPosition(playAgain_button_x, playAgain_button_y); 
        nextButton.setSize(buttonWidth, buttonHeight); 

        // Add the button to the stage
        stage.addActor(nextButton);

        // Button click listener
        nextButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle button click
            	String lastGameLevel = game.getLastGameLevel();
                game.setScene(lastGameLevel);
            }
        });
	}
	
	@Override
	public void render(float delta) {
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
	
	public void dispose() {;
		stage.dispose();
		super.dispose();
	}
}
