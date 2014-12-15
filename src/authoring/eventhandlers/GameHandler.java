//This entire file is part of my masterpiece.
//WESLEY VALENTINE
package authoring.eventhandlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;

/**
 * This is the superclass for the custom event handler hierarchy used in
 * Authoring. Usage of event handlers allow us to cut down and inclose
 * interaction between view components and view/model interactions. GameHandlers
 * are instantiated and assigned to view components in the AuthoringController's
 * initializeGameHandlers method.
 * 
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 */
public interface GameHandler<T extends Event> extends EventHandler<T> {
	/**
	 * This method is executed when the handler is triggered.
	 */
	@Override
	public void handle(T arg0);

	/**
	 * Specify the type of event that can trigger this handler.
	 * 
	 * @return
	 */
	public EventType<T> getEventType();

}
