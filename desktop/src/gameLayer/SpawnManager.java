package gameLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.AIMovable;
import com.mygdx.game.Entity;
import com.mygdx.game.EntityManager;
import com.mygdx.game.Player;

public class SpawnManager {
	private int maxEntity = 6;
	private EntityManager entityManager;
	private List<Entity> spawnList;
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
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float minX = 0; // Minimum X coordinate
        float maxX = screenWidth; // Maximum X coordinate
        float minY = 0; // Minimum Y coordinate
        float maxY = screenHeight; // Maximum Y coordinate

        // Adjust the range to prevent entities from appearing near the edges
        minX += 50; // Leave some margin on the left    
        maxX -= 50; // Leave some margin on the right
        minY += 50; // Leave some margin at the bottom
        maxY -= 50; // Leave some margin at the top
    
        // Add entities with random positions within the adjusted range
        entityManager.addEntity(new UnhealthyFood("Unhealthy/hot_dog_01.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/pizza_01.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/doughnut.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/french_fries.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/cupcake.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/apple.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/banana.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/grapes.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/kiwi.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/lemon.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Vegetable("Vegetables/bok_choy.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Vegetable("Vegetables/broccoli.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Vegetable("Vegetables/cabbage.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Vegetable("Vegetables/carrot.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Vegetable("Vegetables/eggplant.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Protein("Proteins/Cheese.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Protein("Proteins/Eggs.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Protein("Proteins/Fish.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Protein("Proteins/Steak.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Protein("Proteins/FishSteak.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        //entityManager.addEntity(new AIEnemy("Unhealthy/popsicle.png", 200, 300, 5));
    }

	
	public void spawnAndDespawn(SpriteBatch batch) {
		spawnRandom(entityManager.getEntityList());
		despawn();
		spawn(batch);	
	}
	
	public void spawnRandom(List<Entity> entities) {
//	     Keep spawning until spawnList has maxEntity entities
			for (Entity entity: entities) {
				if (entity instanceof AIEnemy) {
					spawnList.add(entity);
					break;
				}       
			}

			
		    while (spawnList.size() < maxEntity) {
		        int randIndex = rand.nextInt(entities.size());
		        spawnList.add(entities.get(randIndex));

		    }
	}


	public void spawn(SpriteBatch batch) {
		batch.begin();
		for (Entity entity : spawnList) {
			entity.draw(batch); // Draw each spawned entity
		}
		
		batch.end();
	}

	private void despawn() {
		// Remove all entities from the list
		spawnList.removeAll(spawnList);
	}
	
	public void removeEatenFood() {
		spawnList.removeIf(Entity::ToRemove); //remove entity
	}
}
