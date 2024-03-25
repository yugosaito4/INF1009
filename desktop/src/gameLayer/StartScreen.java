package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.*;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;



public class StartScreen extends Scene{
	
	
    private float screenWidth = Gdx.graphics.getWidth();
    private float screenHeight = Gdx.graphics.getHeight();
    private static final int buttonWidth = 300;
    private static final int buttonHeight = 50;
    
    private float start_button_x = (screenWidth - buttonWidth)/2;
    private float start_button_y = ((screenHeight - buttonHeight)/2) - 300;
    
    private float instruction_button_x = (screenWidth - buttonWidth)/2;
    private float instruction_button_y = ((screenHeight - buttonHeight)/2) - 380;
	
    private Stage stage;
    private Button startButton;
    private Button instructionsButton;
    private Sound sound;

	public StartScreen(SceneManager game) {
		super(game, "MainMenu.jpg");
		stage = new Stage(new ScreenViewport()); // Use the current screen size
        Gdx.input.setInputProcessor(stage); // Set input processor
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));
        sound = new Sound();

        // Create and set up the start game button
        startButton = new TextButton("Start Game", skin);
        startButton.setPosition(start_button_x, start_button_y); 
        startButton.setSize(buttonWidth, buttonHeight); 

        // Add the button to the stage
        stage.addActor(startButton);

        // Button click listener
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScene("toolTip1");
            }
        });
        
        // Instructions button
        instructionsButton = new TextButton("Instructions", skin);
        instructionsButton.setPosition(instruction_button_x, instruction_button_y); 
        instructionsButton.setSize(buttonWidth, buttonHeight);
        stage.addActor(instructionsButton);
        instructionsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScene("instructions");
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
        sound.setFile(0);
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
		stage.dispose();
		sound.clip.close();
		super.dispose();
	}
}