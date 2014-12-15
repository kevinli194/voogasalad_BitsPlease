package engine.actions;

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
public class makeNewObject implements IMakeNewObject{

    protected Double myX;
    protected Double myY;
    protected String myType;
    protected Double myOrientation;
    protected GameObjectRenderer myRenderer;

    protected Level myCurrentLevel;

    protected void setX(Double x){
        myX = x;
    }    
    
    protected void setY(Double y){
        myY = y;
    }    

    protected void setType(String type){
        myType = type;
    }    
    protected void setOrientation(Double orientation){
        myOrientation = orientation;
    }    
    
    protected void setRenderer (GameObjectRenderer renderer) {
        // TODO Auto-generated method stub
        myRenderer = renderer;
    }
    public void makeNewObject(GameObject object){
        GameObject newObject = new GameObject(object, myX, myY, myType); 
        newObject.setIdentifier(new Identifier(object.getIdentifier()));
        newObject.setPhysicsBody(new PhysicsBody(object.getPhysicsBody()));
        newObject.setOrientation(myOrientation);
        myRenderer.createAndAssignRenderedNode(newObject);
        myCurrentLevel.getGameObjectsCollection().add(newObject); 
    }

   

}
