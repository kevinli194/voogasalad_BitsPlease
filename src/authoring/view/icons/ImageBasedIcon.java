// This entire file is part of my masterpiece.
// Kevin Li
package authoring.view.icons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;

import authoring.eventhandlers.GameHandler;
import errorsAndExceptions.ErrorPopUp;

/**
 * @author Chris Bernt
 * @author Kevin Li
 * @author Arjun Jain
 * @author Wesley Valentine
 *
 */
public abstract class ImageBasedIcon extends FileIcon {

	private static final int DEFAULT_ROTATION = 0;
	private static final int DEFAULT_IMAGE_HEIGHT = 50;
	private static final int DEFAULT_IMAGE_WIDTH = 50;
	protected ImageView myImageView;
	protected double myWidth;
	protected double myHeight;
	protected double myRotation;

	public ImageBasedIcon(String name, File location, GameHandler... event) {
		super(location, name, event);
		myWidth = DEFAULT_IMAGE_WIDTH;
		myHeight = DEFAULT_IMAGE_HEIGHT;
		myRotation = DEFAULT_ROTATION;
		makeIcon();

	}

	@Override
	protected void makeIcon() {
		File file = new File(myGameLocation.getPath() + "/images/" + myLabel);
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);

			myImageView = new ImageView(image);

			myImageView.setFitHeight(myHeight);
			myImageView.setFitWidth(myWidth);
			myImageView.setRotate(myRotation);

			this.getChildren().add(myImageView);

			for (GameHandler g : myOnClick) {
				this.addEventFilter(g.getEventType(), g);
			}

		} catch (IOException e) {
			ErrorPopUp epu = new ErrorPopUp(e);
			epu.display("Couldn't use path", false);
		}
	}

	/**
	 * Sets the dimensions of the icon based on parameters.
	 * 
	 * @param width
	 *            Width of ImageView.
	 * @param height
	 *            Height of ImageView
	 * @param rotation
	 *            Rotation of ImageView
	 */

	public void setDimensions(double width, double height, double rotation) {
		myWidth = width;
		myHeight = height;
		myRotation = rotation;
		myImageView.setFitHeight(myHeight);
		myImageView.setFitWidth(myWidth);
		myImageView.setRotate(myRotation);
	}

	/**
	 * Method that scales the dimensions of the image uploaded so that it
	 * preserves its dimensions.
	 */
	public void scaleDimensions() {
		myImageView.setPreserveRatio(true);
		myImageView.setFitWidth(myWidth);
		myHeight = myImageView.getFitHeight();
		myImageView.setRotate(0);
	}

}
