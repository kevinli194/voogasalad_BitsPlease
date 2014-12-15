// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions.render;

import engine.gameObject.GameObject;
import engine.render.GameObjectRenderer;
import authoring.model.collections.GameObjectsCollection;

public class ChangeImageImpl implements ChangeImage{

	private String myPathName;
	private GameObjectRenderer myRenderer; 
	
	public ChangeImageImpl(String pathname){
 
		myPathName = pathname;
	}
	
	protected void setRenderer(GameObjectRenderer renderer){
		myRenderer = renderer;
	}
	
	@Override
	public void changeImage(GameObjectsCollection myGameObjects) {
		for (GameObject object: myGameObjects){
			myRenderer.removeRenderedNode(object.getIdentifier());
			object.setCurrentImagePath(myPathName);
			myRenderer.createAndAssignRenderedNode(object);
		}
	}

}
