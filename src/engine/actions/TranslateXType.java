// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;


public class TranslateXType extends TypeAction {
	
	private TranslateXImpl myTranslateXImpl;
	
	public TranslateXType(String type, Double value){
		super(type);
		myTranslateXImpl = new TranslateXImpl(value);
	}

	@Override
	public void execute() {
		myTranslateXImpl.translateX(myGameObjects);
	}

}
