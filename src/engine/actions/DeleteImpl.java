// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;

import java.util.Iterator;

import engine.gameObject.GameObject;
import engine.render.GameObjectRenderer;
import authoring.model.collections.GameObjectsCollection;

public class DeleteImpl implements Delete{

	private GameObjectRenderer myRenderer;



	protected void setRenderer(GameObjectRenderer renderer){
		myRenderer = renderer;
	}

	@Override
	public void delete(GameObjectsCollection objects) {
		for (Iterator<GameObject> it = objects.iterator(); it.hasNext();){
			GameObject object = it.next();
			myRenderer.removeRenderedNode(object.getIdentifier());
			it.remove();
		}
	}
}
