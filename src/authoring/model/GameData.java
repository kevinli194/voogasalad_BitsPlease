package authoring.model;

import java.util.HashMap;
import java.util.Map;

import authoring.model.collections.ConditionsCollection;
import authoring.model.collections.GameObjectsCollection;
import authoring.model.collections.GeneralCollection;
import authoring.model.collections.ImagesCollection;
import authoring.model.collections.LevelsCollection;
import authoring.model.collections.SoundsCollection;

/**
 * Passive data object that holds onto all of the data that represents an
 * authored game.
 * 
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 * @author Kevin Li
 *
 */
public class GameData {

	private Map<String, GeneralCollection> myCollections;
	private LevelsCollection myLevels;
	private ConditionsCollection myConditions;
	private GameObjectsCollection myGameObjects;
	private ImagesCollection myImages;
	private SoundsCollection mySounds;

	public GameData() {
		myLevels = new LevelsCollection();
		myConditions = new ConditionsCollection();
		myGameObjects = new GameObjectsCollection();
		myImages = new ImagesCollection();
		mySounds = new SoundsCollection();
		myCollections = new HashMap<String, GeneralCollection>();
		// addAllToMyCollections(new LevelsCollection(),
		// new GameObjectsCollection(), new ConditionsCollection(),
		// new ImagesCollection(), new SoundsCollection());
	}

	// Will refactor this later.
	public GameData(LevelsCollection levels, ConditionsCollection conditions,
			GameObjectsCollection gameObjects) {
		myLevels = levels;
		myConditions = conditions;
		myGameObjects = gameObjects;
		myImages = new ImagesCollection();
		mySounds = new SoundsCollection();
		myCollections = new HashMap<String, GeneralCollection>();
		addAllToMyCollections(new LevelsCollection(),
				new GameObjectsCollection(), new ConditionsCollection(),
				new ImagesCollection(), new SoundsCollection());

	}

	/**
	 * Changing collections to be a map, so that the get method duplication is
	 * removed.
	 * 
	 * @param collection
	 */
	private void addAllToMyCollections(GeneralCollection... collection) {
		for (GeneralCollection c : collection) {
			String classKey = c.getClass().getSimpleName();
			classKey = classKey.toLowerCase();
			myCollections.put(classKey, c);
		}
	}

	public LevelsCollection getLevels() {
		return myLevels;
	}

	/**
	 * GameObject Methods
	 */

	public GameObjectsCollection getGameObjects() {
		return myGameObjects;
	}

	/**
	 * Condition Methods
	 */

	public ConditionsCollection getConditions() {
		return myConditions;
	}

	/**
	 * Graphic Methods
	 */

	public ImagesCollection getImages() {
		return myImages;
	}

	/**
	 * Sound Methods
	 */

	public SoundsCollection getSounds() {
		return mySounds;
	}

}
