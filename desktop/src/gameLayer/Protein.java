package gameLayer;

import com.mygdx.game.Entity;
import com.mygdx.game.Player;
import com.mygdx.game.iCollider;

public class Protein extends Food{
	
//private boolean eaten = false;
	
	public Protein(String imagePath, float x, float y, float s) {
		super(imagePath, x, y, s, FoodType.PROTEIN);
	}


}
