// This entire file is part of my masterpiece.
// Kevin Li
package authoring.view.icons;

import java.io.File;

import authoring.eventhandlers.GameHandler;
import engine.gameObject.GameObject;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class GameObjectIcon extends ImageBasedIcon {

	private GameObject myGameObject;

	public GameObjectIcon(GameObject gameObject, File location,
			GameHandler... event) {
		super(gameObject.getCurrentImageName(), location, event);
		myGameObject = gameObject;
	}

	public GameObject getGameObject() {
		return myGameObject;
	}

}
