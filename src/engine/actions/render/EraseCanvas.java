package engine.actions.render;

import java.util.List;

import javafx.scene.Group;
import engine.GameManager;
import engine.gameObject.GameObject;
import engine.level.Level;
import engine.render.Renderer;

public class EraseCanvas extends RenderAction {

    public EraseCanvas (List<GameObject> objects, Renderer renderer, Level level) {
        super(objects, renderer, level);
    }
    
    @Override
    protected void applyRender () {
        for(GameObject object : myGameObjects) {
            myRenderer.removeRenderedNode(object.getIdentifier());
            //Should add an action???... separate it into the condition?..
            //TODO myLevel.remove(object);
            
        }
    }

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}
    
}
