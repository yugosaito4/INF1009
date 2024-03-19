package gameLayer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.*;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class StartScreen extends Scene{
    private BitmapFont font; // Add a BitmapFont member variable to hold the font

	public StartScreen(SceneManager game) {
		super(game, "bg1.jpg");
		font = new BitmapFont();
	}
	
	@Override
	public void render(float delta ) {
		ScreenUtils.clear(0,0,0.2f,1);
		batch.begin();
		batch.draw(tex, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		font.draw(batch, "This is the start scene", 270, 450);
		font.draw(batch, "Press the P key to start the game!", 270, 50);
		batch.end();
		
		
		if(Gdx.input.isKeyPressed(Input.Keys.P)) {
			game.setScene("toolTip1");
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
