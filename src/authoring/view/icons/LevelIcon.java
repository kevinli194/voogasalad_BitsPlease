package authoring.view.icons;

import javafx.event.Event;
import authoring.eventhandlers.AddConditionIDHandler;
import authoring.eventhandlers.DeleteConditionFromLevelHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.LevelProperties;
import authoring.view.propertiesview.Properties;
import engine.level.Level;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 */
public class LevelIcon extends TextIcon implements IPropertiesMaker {

	public static final int DEFAULT_FONT_SIZE = 20;
	private Level myLevel;
	private GameHandler<Event>[] myLevelEvents;

	public LevelIcon(String s, GameHandler<Event>[] events, Level l,
			GameHandler<Event>... levelEvents) {
		super(s, events);
		myLevel = l;
		myLevelEvents = levelEvents;
	}

	public Level getLevel() {
		return myLevel;
	}

	public GameHandler<Event>[] getLevelEvents() {
		return myLevelEvents;
	}

	@Override
	public Properties makeProperties() {
		return new LevelProperties(
				this, 
				new AddConditionIDHandler(this.getLevel()),
				new DeleteConditionFromLevelHandler(this.getLevel()));
	}

}
