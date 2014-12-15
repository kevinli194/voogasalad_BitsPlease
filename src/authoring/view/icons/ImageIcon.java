//This entire file is part of my masterpiece.
//CHRIS BERNT
package authoring.view.icons;

import java.io.File;

import javafx.event.Event;
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
 * 
 * Icon that represents an image. Comprised of an image with its 
 * label (file name) underneath. Extends ImageBasedIcon as it contains
 * an image, and implements IPropertiesMaker so it can construct
 * its properties.
 */

public class ImageIcon extends ImageBasedIcon implements IPropertiesMaker {

	@SafeVarargs
	public ImageIcon(String name, File location, GameHandler<Event>... handlers) {
		super(name, location, handlers);
		scaleDimensions();
		this.addLabel();
	}

	@Override
	public Properties makeProperties() {
		return new FileProperties(this);
	}

}
