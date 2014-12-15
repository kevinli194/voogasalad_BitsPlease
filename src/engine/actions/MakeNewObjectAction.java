package engine.actions;

import java.util.Iterator;
import java.util.Random;
import authoring.model.collections.GameObjectsCollection;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.gameObject.components.PhysicsBody;
import engine.level.Level;
import engine.render.GameObjectRenderer;

/**
 * This is my masterpiece
 * @author ArihantJain
 *
 */
public abstract class MakeNewObjectAction implements Action, Initializable {

	protected transient Level myCurrentLevel; 
	protected transient GameObjectsCollection myMasterList;
	protected transient GameObjectRenderer myRenderer; 
	protected String myType; 
	protected transient Random r;
	protected Double myX;
	protected Double myY;
	protected Double myOrientation;
	protected makeNewObject myMakeNewObject;

	
	public MakeNewObjectAction(String type){
		myType = type; 
	}
	
	
	
	@Override
	public void initialize(GameManager manager) {
	        
	        myRenderer = manager.getRenderer();
	        myMakeNewObject.setRenderer(myRenderer);
		r = new Random();
		//will be template list
		myMasterList = manager.getLevelManager().getTemplates(); 
		myCurrentLevel = manager.getLevelManager().getCurrentLevel();
		
		
	}
	
	public void execute(){
	    
	    for ( Iterator<GameObject> it = myMasterList.iterator(); it.hasNext();){
	        GameObject object = it.next();
                //System.out.println(object.getIdentifier().getHash());
                    //TODO: will be template list
                    if (object.getIdentifier().getType().equals(myType)){
                            myMakeNewObject.makeNewObject(object);
                    }
            }
	
	    
        }
	
	
	
	


}
