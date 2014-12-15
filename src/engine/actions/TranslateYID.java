// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Will
 *
 */

public class TranslateYID extends IDAction {

	private TranslateYImpl myTranslateYImpl;
	
    public TranslateYID (List<Identifier> iDs, Double value) {
        super(iDs);
        myTranslateYImpl = new TranslateYImpl(value);
    }

	@Override
	public void execute() {
		myTranslateYImpl.translateY(myGameObjects);
	}

}
