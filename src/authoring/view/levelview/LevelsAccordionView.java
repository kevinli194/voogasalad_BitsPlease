package authoring.view.levelview;

import java.util.ResourceBundle;

import javafx.scene.layout.VBox;
import authoring.eventhandlers.GameHandler;
import authoring.model.collections.LevelsCollection;
import authoring.view.baseclasses.CollectionView;
import authoring.view.icons.LevelIcon;
import data.Observable;
import data.Observer;
import engine.level.Level;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class LevelsAccordionView extends CollectionView implements Observer {
	private static final double VIEW_HEIGHT_RATIO = .70;
	private static final double VIEW_WIDTH_RATIO = 0.2;
	private VBox myVbox = new VBox();
	private GameHandler[] myEvents;
	private GameHandler[] levelEvents;
	private String myName;

	public LevelsAccordionView(ResourceBundle language, double width,
			double height) {
		super(language, width, height);
		setView(width * VIEW_WIDTH_RATIO, height * VIEW_HEIGHT_RATIO);
		this.setContent(myVbox);
	}

	@Override
	public void update(Observable o, Object arg) {
		addLevel((LevelsCollection) arg);

	}

	public void setIconEvents(GameHandler... gameHandlers) {
		myEvents = gameHandlers;
	}

	public void setLevelEvents(GameHandler... gameHandlers) {
		levelEvents = gameHandlers;
	}

	public void addLevel(LevelsCollection levels) {
		myVbox.getChildren().clear();
		for (Level l : levels) {
			myName = l.getIdentifier().getUniqueId();
			LevelIcon newLevel = new LevelIcon(myName, myEvents, l, levelEvents);

			myVbox.getChildren().add(newLevel);
		}
	}

	public String getMyName() {
		return myName;
	}
}
