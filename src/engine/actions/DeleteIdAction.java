// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;

import java.util.List;

import engine.GameManager;
import engine.gameObject.Identifier;

public class DeleteIdAction extends IDAction{

	private DeleteImpl myDeleteImpl;
	
	public DeleteIdAction(List<Identifier> ids){
		super(ids);
		myDeleteImpl = new DeleteImpl();
	}
	
	
	@Override
	public void initialize(GameManager manager) {
		super.initialize(manager);
		myDeleteImpl.setRenderer(manager.getRenderer());
	}

	@Override
	public void execute() {
		myDeleteImpl.delete(myGameObjects);
		
	}

	
	
}
