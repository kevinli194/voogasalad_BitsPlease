// This entire file is part of my masterpiece.
// Kevin Li
package authoring.view.icons;

import java.io.File;

import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.FileProperties;
import authoring.view.propertiesview.Properties;

/**
 * Class that is part of the Graphic hierarchy. Graphic that represents images
 * the user uploads.
 * 
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */

public class ImageIcon extends ImageBasedIcon {

	public ImageIcon(String name, File location, GameHandler[] event) {
		super(name, location, event);
		scaleDimensions();
		this.addLabel();
	}
}
