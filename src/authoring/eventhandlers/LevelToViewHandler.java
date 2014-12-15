package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.LevelIcon;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;

//This entire file is part of my masterpiece.
//ARJUN JAIN

/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public class LevelToViewHandler implements GameHandler<MouseEvent> {

	private LevelsView myLevels;

	public LevelToViewHandler(LevelsView levels) {
		myLevels = levels;
	}

	@Override
	public void handle(MouseEvent event) {

		LevelIcon l = (LevelIcon) event.getSource();
		String levelID = l.getLevel().getIdentifier().getUniqueId();
		if (!myLevels.levelOpenInTabs(levelID)) {
			SingleLevelView newLevelView = myLevels.addExistingLevel(
					l.getLevel(), l.getLevelEvents());
			newLevelView.setID(levelID);
			l.getLevel().addObserver(newLevelView);
		}

	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_CLICKED;
	}

}
