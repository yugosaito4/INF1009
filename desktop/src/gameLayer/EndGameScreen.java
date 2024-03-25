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

public class EndGameScreen extends Scene{

	
	
	//set up button sizes
    private float screenWidth = Gdx.graphics.getWidth();
    private float screenHeight = Gdx.graphics.getHeight();
    private static final int buttonWidth = 300;
    private static final int buttonHeight = 50;
    private float return_button_x = (screenWidth - buttonWidth)/2;
    private float return_button_y = ((screenHeight - buttonHeight)/2) - 300;
    
	private Stage stage;
	private Button returnButton;
	
	private Sound sound;

	public EndGameScreen(SceneManager game) {
		super(game, "End.png");
		stage = new Stage(new ScreenViewport()); // Use the current screen size
        Gdx.input.setInputProcessor(stage); 
        
        sound = new Sound();

        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        // Create and set up the return to menu button
        returnButton = new TextButton("Next", skin);
        returnButton.setPosition(return_button_x, return_button_y); 
        returnButton.setSize(buttonWidth, buttonHeight); 
        // Add the button to the stage
        stage.addActor(returnButton);

        // Button click listener
        returnButton.addListener(new ClickListener() {
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
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
	}

	@Override
	public void show() {
		// Set the stage as the input processor
        Gdx.input.setInputProcessor(stage);
        sound.setFile(7);
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
		sound.clip.close();
		super.dispose();
	}
}
