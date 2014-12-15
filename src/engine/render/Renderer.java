// This entire file is part of my masterpiece.
// Will Chang
package engine.render;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javafx.scene.Group;
import engine.gameObject.*;
import engine.level.Level;

/**
 * Renders GameObjects on a given Canvas by generating 
 * JavaFX nodes and Images from state information 
 * 
 * @author Will Chang
 * @author Davis
 * 	
 */

public class Renderer {
    private Group myCanvas;
    private Map<Identifier, RenderedNode> myRenderedNodes;
    private Level myCurrentLevel;
    private RenderedNodeFactory myFactory;
    /**
     * Constructor takes in a group as the Canvas of the game 
     * @param canvas
     * @param relativePath 
     */
    public Renderer (Group canvas, String relativePath) {
        myCanvas = canvas;
        myRenderedNodes = new HashMap<>();
        myFactory = new RenderedNodeFactory(relativePath);
    }

    /**
     * Renders all GameObjects within a Level
     * @param level
     */
    public void renderGameObjects (Level level) {
        myCanvas.getChildren().clear();
        myRenderedNodes.clear();
        myCurrentLevel = level;
        setBackGroundImage(level);
        for(Iterator<GameObject> iter = myCurrentLevel.getGameObjectIterator(); iter.hasNext();) {
            GameObject obj = iter.next();
            if (!obj.getIdentifier().getUniqueId().equals("template")){
                createAndAssignRenderedNode(obj);
            }
        }
    }

    /**
     * Generates the JavaFX Node for a GameObject, giving it its image and CollisionBody
     * 
     * @param obj
     */
    public void createAndAssignRenderedNode (GameObject obj) {
        RenderedNode node = myFactory.createRenderedNode(obj);
        myRenderedNodes.put(obj.getIdentifier(), node);
        obj.setRenderedNode(node);
        myCanvas.getChildren().add(node);
    }

    /**
     * Removes a rendered Node from the list of currently rendered Nodes
     * @param nodeID
     */
    public void removeRenderedNode (Identifier nodeID) {
        myCanvas.getChildren().remove(myRenderedNodes.get(nodeID));
        myRenderedNodes.remove(nodeID);
    }

    /**
     * Sets the background of a level
     * @param level
     */
    public void setBackGroundImage(Level level) {   
        myCanvas.getChildren().add(myFactory.createImageAndView(level.getBackgroundImage()));
    }

}
