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
        entityManager.addEntity(new UnhealthyFood("Unhealthy/Burger.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/Cookie.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/Cupcake.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/Fries.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/Hotdog.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/IceCream.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/Pizza.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/Popsicle.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new UnhealthyFood("Unhealthy/Sundae.png",  rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/Apple.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/Banana.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/Grapes.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/Kiwi.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/Lemon.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/Orange.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/Watermelon.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Fruits("Fruits/Strawberry.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
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
        entityManager.addEntity(new Protein("Proteins/Ribs.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Protein("Proteins/Steak.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        entityManager.addEntity(new Protein("Proteins/Shrimp.png", rand.nextFloat() * (maxX - minX) + minX, rand.nextFloat() * (maxY - minY) + minY, 50));
        
    }

	
	public void spawnAndDespawn(SpriteBatch batch) {
//		spawnRandom(entityManager.getEntityList());
		despawn();
		spawnEntityList();
		spawn(batch, getSpawnedEntityList());	
	}
	
	public void spawnEntityList(){
        List<Entity> entityList = entityManager.getEntityList();
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float minX = 0; // Minimum X coordinate
        float maxX = screenWidth; // Maximum X coordinate
        float minY = 0; // Minimum Y coordinate
        float maxY = screenHeight; // Maximum Y coordinate

        // Adjust the range to prevent entities from appearing near the edges
        minX += 25; // Leave some margin on the left    
        maxX -= 25; // Leave some margin on the right
        minY += 25; // Leave some margin at the bottom
        maxY -= 25; // Leave some margin at the top

        // Add Popsicle entity to the spawnList
        for (Entity entity: entityList) {
			if (entity instanceof AIEnemy) {
				spawnList.add(entity);
				break;
			}       
		}

        while (spawnList.size() < maxEntity) {
            int randIndex = rand.nextInt(entityList.size());
            Entity randEntity = entityList.get(randIndex);
            if (!spawnList.contains(randEntity)) {
                spawnList.add(randEntity);
            }
        }
        
        // If entity x y same, randomize again
        for (int i = 0; i < spawnList.size() - 1; i++) {
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
		System.out.println(spawnList.size());
		batch.begin();
		for (Entity entity : spawnList) {
			entity.draw(batch); // Draw each spawned entity
		}
		
		batch.end();
	}

	public void removeEatenFood() {
		spawnList.removeIf(Entity::ToRemove); //remove entity
	}
	

	private void despawn() {
		// Remove all entities from the list
		spawnList.removeAll(spawnList);
	}
}
