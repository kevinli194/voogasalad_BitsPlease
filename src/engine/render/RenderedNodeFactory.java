// This entire file is part of my masterpiece. 
// Will Chang 
package engine.render;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import engine.FilePathUtility;
import engine.gameObject.GameObject;
import engine.gameObject.components.PhysicsBody;

/**
 * Factory that creates RenderedNodes and their components
 * @author Will Chang
 *
 */

public class RenderedNodeFactory {
    private FilePathUtility myFilePathUtility;
    private static final String IMAGES = "images";

    public RenderedNodeFactory (String relativePath) {
        myFilePathUtility = new FilePathUtility(IMAGES,relativePath);
    }

    public RenderedNode createRenderedNode (GameObject obj) {
        RenderedNode node = new RenderedNode();
        node.setImageView(createImageAndView(obj));
        node.setCollisionBody(createCollisionBody(obj));
        node.setLabel(createLabel(obj));
        node.setLayoutX(0);
        node.setLayoutY(0);
        node.setTranslateX(obj.getX());
        node.setTranslateY(obj.getY());
        node.setId(obj.getID());
        return node;
    }

    /**
     * Creates the Image and ImageView for the RenderedNode if specified
     * @param obj
     * @return
     */
    public ImageView createImageAndView (GameObject obj) {
        String imageName = obj.getCurrentImageName();
        ImageView view = this.createImageAndView(imageName);
        view.setFitHeight(obj.getHeight());
        view.setFitWidth(obj.getWidth());
        return view;
    }
    
    /**
     * Creates the Image and ImageView for any Image specified
     * @param obj
     * @return
     */
    public ImageView createImageAndView(String path) {
            FileInputStream in;
            try {
                in = new FileInputStream(myFilePathUtility.getFilePath()+path);
                Image image = new Image(in);
                ImageView view = new ImageView();
                view.setImage(image);
                view.setPreserveRatio(true);
                view.setSmooth(true);
                view.setCache(true);
                return view;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return null; 
    }

    /**
     * Creates the CollisionBody of the GameObject
     * @param sprite
     * @return
     */
    public Node createCollisionBody (GameObject obj) {
        PhysicsBody body = obj.getPhysicsBody();
        Rectangle hitBox = null;
        if(body!=null) {
            hitBox = new Rectangle(body.getCollisionBodyHeight(),body.getCollisionBodyWidth());
            hitBox.setOpacity(0);
        }
        return hitBox;
    }

    /**
     * Creates the Label for a given RenderedNode
     * @param obj
     * @return
     */
    public Label createLabel (GameObject obj) {
        String l = obj.getLabel();
        Label label = null; 
        if(l != null) {
            label = new Label(l);
            label.setPrefHeight(obj.getHeight());
            label.setPrefWidth(obj.getWidth());
            label.setText(l);
        }
        return label;
    }
}
