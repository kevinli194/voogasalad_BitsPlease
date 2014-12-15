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
public class MakeNewRandomObjectAction extends MakeNewObjectAction{

	protected Double myLowerXBound;
	protected Double myUpperXBound;
	protected Double myLowerYBound;
	protected Double myUpperYBound; 
	
	public MakeNewRandomObjectAction(String type, Double lowerXBound, Double upperXBound, Double lowerYBound, Double upperYBound){
		super(type); 
		myLowerXBound = lowerXBound;
		myLowerYBound = lowerYBound;
		myUpperXBound = upperXBound;
		myUpperYBound = upperYBound;

	}

	
	@Override
        public void initialize(GameManager gameManager){
                super.initialize(gameManager);
              
                super.myMakeNewObject.setX((myUpperXBound-myLowerXBound) * r.nextFloat() + myLowerXBound);
                super.myMakeNewObject.setY((myUpperYBound-myLowerYBound) * r.nextFloat() + myLowerYBound);   
              
        }
	
	
}
