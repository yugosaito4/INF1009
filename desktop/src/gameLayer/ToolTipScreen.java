package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;

public class ToolTipScreen extends Scene{
	private BitmapFont font; // Add a BitmapFont member variable to hold the font
	private String toolTipText;
	private String targetNextScene;

	public ToolTipScreen(SceneManager game, String toolTipText, String targetNextScene) {
		super(game, "bg1.jpg");
		font = new BitmapFont();
		this.toolTipText = toolTipText;
		this.targetNextScene = targetNextScene;
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
		font.draw(batch, "Press O to play!", 250, 50);
		batch.end();
		
		if(Gdx.input.isKeyPressed(Input.Keys.O)) {
			game.setScene(targetNextScene);
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
