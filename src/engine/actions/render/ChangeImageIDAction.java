// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions.render;

import java.util.List;

import engine.GameManager;
import engine.actions.IDAction;
import engine.gameObject.Identifier;

public class ChangeImageIDAction extends IDAction{

	private ChangeImageImpl myChangeImageImpl;
	
	public ChangeImageIDAction(List<Identifier> ids, String pathName){
		super(ids);
		myChangeImageImpl = new ChangeImageImpl(pathName); 
		
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
