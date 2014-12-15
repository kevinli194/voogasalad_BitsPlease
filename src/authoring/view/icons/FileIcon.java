// This entire file is part of my masterpiece.
// Kevin Li
package authoring.view.icons;

import java.io.File;

import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.FileProperties;
import authoring.view.propertiesview.Properties;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public abstract class FileIcon extends BaseIcon {
	protected File myGameLocation;

	public FileIcon(File gameLoc, String label, GameHandler... handler) {
		super(label, handler);
		myGameLocation = gameLoc;
	}

	@Override
	public Properties makeProperties() {
		return new FileProperties(this);
	}

}
