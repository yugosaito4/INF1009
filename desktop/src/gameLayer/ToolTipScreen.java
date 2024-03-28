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

public class ToolTipScreen extends Scene{
	
    private float screenWidth = Gdx.graphics.getWidth();
    private float screenHeight = Gdx.graphics.getHeight();
    
    private static final int buttonWidth = 300;
    private static final int buttonHeight = 50;
    

    private float start_button_x = (screenWidth - buttonWidth)/2;
    private float start_button_y = ((screenHeight - buttonHeight)/2) - 300;
    
	private Stage stage;
	private Button startGameButton;
	
	private IOManagement ioManager;

	public ToolTipScreen(SceneManager game,String bgImage, String targetNextScene, IOManagement im) {
		super(game, bgImage);
		this.ioManager = im;
		
		stage = new Stage(new ScreenViewport()); // Use the current screen size
        Gdx.input.setInputProcessor(stage); // Set input processor
    
        
        // Initialize the skin (You need to have a skin, uiskin.json file in your assets)
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        // Create and set up the start game button
        startGameButton = new TextButton("Lets Go!", skin);
        startGameButton.setPosition(start_button_x, start_button_y); 
        startGameButton.setSize(buttonWidth, buttonHeight); 

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
				
		batch.end();
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
	}

	@Override
	public void show() {
		// Set the stage as the input processor
        Gdx.input.setInputProcessor(stage);
        ioManager.setFile(2);
        ioManager.play();
		
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
		ioManager.stop();
		
	}
	
	public void dispose() {
		stage.dispose();
		ioManager.getClip().close();
		super.dispose();
	}
}
