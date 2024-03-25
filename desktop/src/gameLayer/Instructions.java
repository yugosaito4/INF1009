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
import com.mygdx.game.Scene;
import com.mygdx.game.SceneManager;

public class Instructions extends Scene{
	private Stage stage;
	private Button backButton;
    private float screenWidth = Gdx.graphics.getWidth();
    private float screenHeight = Gdx.graphics.getHeight();
    private static final int buttonWidth = 300;
    private static final int buttonHeight = 50;
    private Sound sound;

	public Instructions(SceneManager game) {
		super(game, "instruction.jpg");

		stage = new Stage(new ScreenViewport()); // Use the current screen size
        Gdx.input.setInputProcessor(stage); // Set input processor
        
        sound = new Sound();
        

        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        // Create and set up button
        backButton = new TextButton("Back to Menu", skin);
        backButton.setPosition(100, 50);
        backButton.setSize(buttonWidth, buttonHeight); 

        // Add the button to the stage
        stage.addActor(backButton);

        // Button click listener
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle button click
                game.setScene("startScene");
            }
        });
		
	}
	
	@Override
	public void render(float delta ) {
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, screenWidth, screenHeight);

		batch.end();
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
	}

	@Override
	public void show() {
		// Set the stage as the input processor
        Gdx.input.setInputProcessor(stage);
        sound.setFile(1);
        sound.play();
		
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
		sound.clip.stop();
		super.dispose();		
	}
}

