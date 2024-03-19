package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;

public class EndGameScreen extends Scene{
	private BitmapFont font; // Add a BitmapFont member variable to hold the font

	public EndGameScreen(SceneManager game) {
		super(game, "bg1.jpg");
		font = new BitmapFont();
	}
	
	@Override
	public void render(float delta ) {
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "This is the End Game scene", 250, 450);
		font.draw(batch, "Thank you for playing our game!", 250, 300);
		font.draw(batch, "Hopefully you have learned about healthy eating habits through our game!", 100, 280);
		font.draw(batch, "Press the Esc key to return to the start screen.", 250, 50);
		batch.end();
		
		if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			game.setScene("startScene");
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
