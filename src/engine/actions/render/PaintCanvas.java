package engine.actions.render;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.level.Level;
import engine.render.Renderer;

public class PaintCanvas extends RenderAction {

    public PaintCanvas (List<GameObject> objects, Renderer renderer, Level level) {
        super(objects, renderer, level);
    }

    @Override
    protected void applyRender () {
        for(GameObject object : myGameObjects) {
            myRenderer.createAndAssignRenderedNode(object);
            //TODO myLevel.add(object);
        }
    }

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub
		
	}

}
