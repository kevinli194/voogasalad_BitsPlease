// This entire file is part of my masterpiece.
// Kevin Li
package authoring.view.icons;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public abstract class BaseIcon extends VBox implements IPropertiesMaker {
	protected GameHandler[] myOnClick;
	protected String myLabel;

	public BaseIcon(String label, GameHandler... handler) {
		myLabel = label;
		myOnClick = handler;
	}

	/**
	 * Abstract class that is responsible for making the icon to be displayed.
	 */
	protected abstract void makeIcon();

	/**
	 * Class that adds a text label to the icon.
	 */
	public void addLabel() {
		this.getChildren().add(new Text(myLabel));
	}

	/**
	 * Class that returns the label tag associated with the icon.
	 * 
	 * @return String label associated with the icon
	 */
	public String getLabel() {
		return myLabel;
	}
}
