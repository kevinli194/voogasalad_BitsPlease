// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.level.Level;

public abstract class TypeAction implements Action, Initializable{

	protected transient Level myCurrentLevel; 
	protected transient GameObjectsCollection myGameObjects;
	protected String myType; 
	
	public TypeAction(String type){
		myType = type; 
	}
	
	@Override
	public void initialize(GameManager manager) {
		myCurrentLevel = manager.getLevelManager().getCurrentLevel();
		for (GameObject object: myCurrentLevel.getGameObjectsCollection()){
			if (object.getIdentifier().getType().equals(myType)){
				myGameObjects.add(object);
			}
		}
		
	}



}
