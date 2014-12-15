// This entire file is part of my masterpiece. 
// Will Chang 
package engine.render;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * The JavaFX Component of the Game Object. 
 * Contains The Image, CollisionBody, Label, and general functionality for JavaFX GUI
 * @author Will Chang
 *
 */

public class RenderedNode extends Group {
    private ImageView myImageView;
    private Node myCollisionBody;
    private Label myLabel;

    /**
     * Sets the CollisionBody
     * @param body
     */
    public void setCollisionBody (Node body) {
        if(body != null) {
            myCollisionBody = body;
            this.getChildren().add(myCollisionBody);
        }
    }
    
    /**
     * Sets the Label
     */
    public void setLabel (Label label) {
        if(label != null) {
            myLabel = label;
            this.getChildren().add(myLabel);
        }
    }
    
    
    /**
     * Sets the ImageView
     * @param view
     */
    public void setImageView(ImageView view) {
        if(view != null) {
            myImageView = view;
            this.getChildren().add(myImageView);
        }
    }
    
    /**
     * Gets the ImageView
     * @return
     */
    public ImageView getImageView() {
        return myImageView;
    }
    
    /**
     * Gets the Label
     */
    public Label getLabel () {
        return myLabel;
    }

    /**
     * Gets the CollisionBody
     * @return
     */
    public Node getCollisionBody () {
        return myCollisionBody;
    }

    @Override
    public boolean intersects (Bounds localBounds) {
        return (myCollisionBody != null) ? myCollisionBody.intersects(localBounds): false;
    }
}
