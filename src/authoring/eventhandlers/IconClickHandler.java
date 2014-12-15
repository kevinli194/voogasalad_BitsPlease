//This entire file is part of my masterpiece.
//CHRIS BERNT
package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.IPropertiesMaker;
import authoring.view.propertiesview.PropertiesView;

/**
 * @author Kevin Li
 * @author Arjun Jain
 * @author Chris Bernt
 * @author Wesley Valentine
 * @author Safkat Islam
 * 
 * The general properties click handler for icons. Since all normal icons
 * must implement IPropertiesMaker, the parameters to the click 
 * handle will be able to construt their own properties objects to be displayed.
 */
public class IconClickHandler implements GameHandler<MouseEvent> {

	private PropertiesView myPropertiesView;

	public IconClickHandler(PropertiesView props) {
		myPropertiesView = props;
	}

	@Override
	public void handle(MouseEvent event) {
		IPropertiesMaker icon = (IPropertiesMaker) event.getSource();
		myPropertiesView.displayProperties(icon.makeProperties());
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_PRESSED;
	}

}
