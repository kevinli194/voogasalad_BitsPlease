package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;

/**
 * This is my masterpiece
 * @author ArihantJain
 *
 */
public class MakeNewObjectFromLocationAction extends MakeNewObjectAction{

	
	
	public MakeNewObjectFromLocationAction(String type, Double x, Double y) {
		super(type);
		super.myMakeNewObject.setX(x); 
		super.myMakeNewObject.setY(y);
		
	}

	


}
