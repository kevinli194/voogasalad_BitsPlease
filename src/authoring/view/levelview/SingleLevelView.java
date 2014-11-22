package authoring.view.levelview;

import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import engine.gameObject.GameObject;
import engine.level.Level;
import authoring.eventhandlers.GameHandler;
import authoring.eventhandlers.GameObjectClickHandler;
import authoring.eventhandlers.GraphicsDragHandler;
import authoring.view.graphicsview.Graphic;
import authoring.view.spritesview.GameObjectGraphic;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Class that contains the visualization data of a single level.
 * 
 * @author Kevin Li
 *
 */
public class SingleLevelView extends Pane implements Observer {
	private Background myDefaultBackground = new Background(new BackgroundFill(
			Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
	private static final double VIEW_HEIGHT_RATIO = .85;
	private static final double VIEW_WIDTH_RATIO = 0.6;
	private GameHandler[] myEvents;
	
	public SingleLevelView(double width, double height,GameHandler ... events) {
		this.setBackground(myDefaultBackground);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		myEvents = events;
	}

	private void setView(double width, double height) {
		setPrefSize(width, height);
		setMinSize(width, height);
		setMaxSize(width, height);
	}

	@Override
	public void update(Observable o, Object arg) {
			Level level = ((Level) arg);
			for (GameObject g: level.getGameObjectsCollection()){
				addGameObjectToView(g,300, 300, myEvents);
			}
	}

	public void addGameObjectToView(GameObject gameObject, double x, double y,
			GameHandler ... handler) {
		GameObjectGraphic g = new GameObjectGraphic(gameObject,handler);
		g.makeGraphic();
		g.setLayoutX(x - 230);
		g.setLayoutY(y - 100);
		this.getChildren().add(g);
		
	}

	public void moveSpriteOnLevel(Graphic g, double x, double y) {
		g.setLayoutX(x - 230);
		g.setLayoutY(y - 100);
	}
	
}
