//This entire file is part of my masterpiece.
//CHRIS BERNT
package authoring.view.icons;

import javafx.event.Event;
import authoring.eventhandlers.AddActionHandler;
import authoring.eventhandlers.GameHandler;
import authoring.view.propertiesview.ConditionProperties;
import authoring.view.propertiesview.Properties;
import engine.conditions.Condition;

/**
 * @author Kevin Li
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Arjun Jain
 * 
 * The icon that represents conditions. It is a text string, so
 * it extends TextIcon, and implements IPropertiesMaker
 * so it can construct its own properties to display
 * to the user.
 */
public class ConditionIcon extends TextIcon implements IPropertiesMaker {

	private Condition myCondition;

	@SafeVarargs
	public ConditionIcon(String name, Condition condition,
			GameHandler<Event>... handlers) {
		super(name, handlers);
		myCondition = condition;
	}

	public Condition getCondition() {
		return myCondition;
	}

	@Override
	public Properties makeProperties() {
		return new ConditionProperties(this, new AddActionHandler());
	}
}
