// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;

public class TranslateXImpl implements TranslateX {

	private double myValue;

	public TranslateXImpl(Double value){
		myValue = value;
	}


	@Override
	public void translateX(GameObjectsCollection myGameObjects) {
		for (GameObject object: myGameObjects){
			object.setTranslateX(object.getTranslateX() + myValue);
		}
	}
}


