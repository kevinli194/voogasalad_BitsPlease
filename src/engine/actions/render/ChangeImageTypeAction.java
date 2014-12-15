// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions.render;

import engine.GameManager;
import engine.actions.TypeAction;


public class ChangeImageTypeAction extends TypeAction{

	private ChangeImageImpl myChangeImageImpl;


	public ChangeImageTypeAction(String type, String pathname){
		super(type);
		myChangeImageImpl = new ChangeImageImpl(pathname); 
	}

	@Override
	public void initialize(GameManager manager){
		super.initialize(manager);
		myChangeImageImpl.setRenderer(manager.getRenderer());
	}


	@Override
	public void execute() {
		myChangeImageImpl.changeImage(myGameObjects);
	}




}
