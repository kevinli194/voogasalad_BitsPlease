package engine.actions.render;

import java.util.List;

import engine.GameManager;
import engine.actions.Action;
import engine.actions.Initializable;
import engine.gameObject.GameObject;
import engine.level.Level;
import engine.render.Renderer;

/**
 * Does rendering for all Sprites.
 * @author Will
 *
 */

public abstract class RenderAction implements Action, Initializable {

    protected transient List<GameObject> myGameObjects;
    protected transient Renderer myRenderer;
    protected transient Level myLevel;
    
    /**
     * 
     * @param objects
     */
    //potentially just give it the ID of the objects??
    //or just give it an iterator?
    public RenderAction (List<GameObject> objects, Renderer renderer, Level level) {
        myGameObjects = objects;
        myRenderer = renderer;
        myLevel = level;
    }

    @Override
    public void execute () {
        applyRender();
    }
    
    @Override
    public void initialize(GameManager gameManager){
    	
    }
    
    protected abstract void applyRender ();
    
    

}
