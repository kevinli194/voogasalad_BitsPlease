package engine.level;

import java.util.Iterator;

import authoring.model.collections.ConditionIDsCollection;
import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;

/**
 * A Level of the game. Contains all GameObjects and Actions and coordinates
 * their interactions for linear progression through the game.
 * 
 * @author Will Chang
 * @author Abhishek Balakrishnan
 */

public class Level {

	private String myLevelID;
	private GameObjectsCollection myGameObjects;
	private ConditionIDsCollection myConditionIDs;

	/**
	 * Constructor
	 * @param Game Objects Collection
	 */
	public Level(GameObjectsCollection gameObjects) {
		myGameObjects = gameObjects;
	}
	
	/**
	 * Updates all GameObjects.
	 */
	public void update() {
		for (GameObject sprite : myGameObjects) {
			sprite.update();
		}
	}

	/**
	 * SET INITIAL VALUES FOR THE MAIN CHARACTER
	 */
	public void updateMainCharacter() {
		
	}

	/**
	 * @return Iterator for GameObjectCollection
	 */
	public Iterator<GameObject> getGameObjectIterator() {
		return myGameObjects.iterator();
	}
	
	/**
	 * @return Iterator for the ConditionIDsCollection
	 */
	public Iterator<String> getConditionIDsIterator() {
		return myConditionIDs.iterator();
	}

}
