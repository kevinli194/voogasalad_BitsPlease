// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;

import java.util.List;

import engine.gameObject.Identifier;

/**
 * 
 * @author Will
 * @author Shreyas
 */

public class TranslateXID extends IDAction {

	private TranslateXImpl myTranslateXImpl;
	
    public TranslateXID (List<Identifier> iDs, Double value) {
        super(iDs);
        myTranslateXImpl = new TranslateXImpl(value);
    }

    
	@Override
	public void execute() {
		myTranslateXImpl.translateX(myGameObjects);
		
	}
    
}
