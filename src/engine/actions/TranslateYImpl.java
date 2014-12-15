// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;

public class TranslateYImpl implements TranslateY{

	private Double myValue;

	public TranslateYImpl(double value){
		myValue = value;
	}

	@Override
	public void translateY(GameObjectsCollection objects) {
		for (GameObject object: objects){
			object.setTranslateY(object.getTranslateY() + myValue); 

		}

	}



}
