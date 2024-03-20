package gameLayer;

import com.badlogic.gdx.Gdx;
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

public class EndLevelScreen extends Scene{
	private BitmapFont font; // Add a BitmapFont member variable to hold the font
	private String endLevelText;
	private Stage stage;
	private Button nextButton;

	public EndLevelScreen(SceneManager game, String endLevelText, String nextTargetScene) {
		super(game, "bg1.jpg");
		font = new BitmapFont();
		this.endLevelText = endLevelText;
		stage = new Stage(new ScreenViewport()); // Use the current screen size
        Gdx.input.setInputProcessor(stage); // Set input processor
        
        // Initialize the skin (You need to have a skin, uiskin.json file in your assets)
        Skin skin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        // Create and set up the start game button
        nextButton = new TextButton("Next", skin);
        nextButton.setPosition(270, 100); // Adjust position to match your needs
        nextButton.setSize(200, 50); // Adjust size to match your needs

        // Add the button to the stage
        stage.addActor(nextButton);

        // Button click listener
        nextButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Handle button click
                game.setScene(nextTargetScene);
            }
        });
	}
	
	@Override
	public void render(float delta ) {
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "This is the end level scene", 270, 450);
		font.draw(batch, endLevelText, 270, 300);
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