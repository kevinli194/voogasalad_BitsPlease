// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;

import engine.gameObject.GameObject;

public class TranslateYType extends TypeAction{

	private TranslateYImpl myTranslateYImpl;
	
	public TranslateYType(String type, Double value) {
		super(type);
		myTranslateYImpl = new TranslateYImpl(value);
	}

	@Override
	public void execute() {
		myTranslateYImpl.translateY(myGameObjects);
	}

	
	
	
	
}
