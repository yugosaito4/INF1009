package gameLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.Entity;
import com.mygdx.game.EntityManager;

public class SpawnManager {
	private int maxEntity = 6;
	private EntityManager entityManager;
	private List<Entity> spawnList;
	private float screenWidth = 0;
	private float screenHeight = 0;
	Random rand = new Random();
	Timer time = new Timer();

	public SpawnManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		spawnList = new ArrayList<>();
	}

	public List<Entity> getSpawnedEntityList() {
		return spawnList;
	}

	public void loadEntity() {
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		float minX = 0; 
		float maxX = screenWidth - 150; 
		float minY = 0; 
		float maxY = screenHeight - 300; 

		// Add entities with random positions within the adjusted range
		entityManager.addEntity(new UnhealthyFood("Unhealthy/Burger.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new UnhealthyFood("Unhealthy/Cookie.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new UnhealthyFood("Unhealthy/Cupcake.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new UnhealthyFood("Unhealthy/Fries.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new UnhealthyFood("Unhealthy/Hotdog.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new UnhealthyFood("Unhealthy/IceCream.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new UnhealthyFood("Unhealthy/Pizza.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new UnhealthyFood("Unhealthy/Popsicle.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new UnhealthyFood("Unhealthy/Sundae.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Fruits("Fruits/Apple.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Fruits("Fruits/Banana.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Fruits("Fruits/Grapes.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Fruits("Fruits/Kiwi.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Fruits("Fruits/Lemon.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Fruits("Fruits/Orange.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Fruits("Fruits/Watermelon.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Fruits("Fruits/Strawberry.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Vegetable("Vegetables/bok_choy.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Vegetable("Vegetables/broccoli.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Vegetable("Vegetables/cabbage.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Vegetable("Vegetables/carrot.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Vegetable("Vegetables/eggplant.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Protein("Proteins/Cheese.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Protein("Proteins/Eggs.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Protein("Proteins/Fish.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Protein("Proteins/Steak.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Protein("Proteins/FishSteak.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Protein("Proteins/Ribs.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Protein("Proteins/Steak.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new Protein("Proteins/Shrimp.png", rand.nextFloat() * (maxX - minX) + minX,
				rand.nextFloat() * (maxY - minY) + minY, 50));
		entityManager.addEntity(new AIEnemy("AI.png", 200, 600, 5));
	}

	public void spawnAndDespawn(SpriteBatch batch) {
		despawn();
		spawnEntityList();
		spawn(batch, getSpawnedEntityList());
	}

	public void spawnEntityList() {
		List<Entity> entityList = entityManager.getEntityList();

		float maxX = screenWidth - 150;
		float maxY = screenHeight - 300;
		float minY = 0;
		float minX = 0;

		// Add AIEnemy entity to the spawnList
		for (Entity entity : entityList) {
			if (entity instanceof AIEnemy) {
				spawnList.add(entity);
				break;
			}
		}

		Random rand = new Random();
		while (spawnList.size() < maxEntity) {
			Entity randEntity = entityList.get(rand.nextInt(entityList.size()));
//			spawnList.add(randEntity);
			
			 // Check if the entity is not already in the spawnList and is not an AIMovable
	        if (!spawnList.contains(randEntity)) {
	            spawnList.add(randEntity); // Add spawned entities to the list
	        }      
		}

		// check distance and reset if too close
		for (int i = 0; i < spawnList.size(); i++) {
		    for (int j = i + 1; j < spawnList.size(); j++) {
		        float diffX = spawnList.get(i).getX() - spawnList.get(j).getX();
		        float diffY = spawnList.get(i).getY() - spawnList.get(j).getY();
		        double distance = Math.sqrt(diffX * diffX + diffY * diffY);
		        if (distance <= 500) {
		            spawnList.get(i).setX((float) Math.random() * (maxX - minX) + minX);
		            spawnList.get(i).setY((float) Math.random() * (maxY - minY) + minY);
		        }
		    }
		}
		
		 // If entity x y same, randomize again
        for (int i = 0; i < spawnList.size(); i++) {
            for (int j = i + 1; j < spawnList.size(); j++) {
                if (spawnList.get(i).getX() == spawnList.get(j).getX() && 
                    spawnList.get(i).getY() == spawnList.get(j).getY()) {
                    spawnList.get(i).setX(rand.nextFloat() * (maxX - minX) + minX);
                    spawnList.get(i).setY(rand.nextFloat() * (maxY - minY) + minY);
                }
            }
        }
        

	}

	public void spawn(SpriteBatch batch, List<Entity> spawnList) {
		batch.begin();
		for (Entity entity : spawnList) {
			entity.draw(batch); // Draw each spawned entity
		}

		batch.end();
	}

	public void removeEatenFood() {
		spawnList.removeIf(Entity::ToRemove); // remove entity
	}

	public void despawn() {
		// Remove all entities from the list
		spawnList.removeAll(spawnList);
	}
}
