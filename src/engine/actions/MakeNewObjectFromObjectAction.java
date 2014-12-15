package engine.actions;

import java.util.Random;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;

/**
 * This is my masterpiece
 * @author ArihantJain
 *
 */
public class MakeNewObjectFromObjectAction extends MakeNewObjectAction {

	private Identifier objectID; 
	private transient GameObject myObject; 
	
	public MakeNewObjectFromObjectAction(String type, Identifier id) {
		super(type);
		objectID = id; 
	}

	@Override
	public void initialize(GameManager gameManager){
		super.initialize(gameManager);
		myObject = gameManager.objectForIdentifier(objectID);
		
		
		super.myMakeNewObject.setX(myObject.getTranslateX()+.5*myObject.getHeight());
		super.myMakeNewObject.setY(myObject.getTranslateY()+.5*myObject.getHeight());   
		super.myMakeNewObject.setOrientation(myObject.getOrientation());
	}
	

}
