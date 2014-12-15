package engine.actions;

import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
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
		super.myX = (x); 
		super.myY = (y);
		
	}
	@Override
        public void initialize(GameManager gameManager){
                super.initialize(gameManager);
              
                super.myMakeNewObject.setX(myX);
                super.myMakeNewObject.setY(myY);   
              
        }

	


}
