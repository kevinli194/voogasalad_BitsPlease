// This entire file is part of my masterpiece.
// Shreyas Bharadwaj
package engine.actions;


import engine.GameManager;



public class DeleteTypeAction extends TypeAction{

	private DeleteImpl myDeleteImpl;

	public DeleteTypeAction(String type){
		super(type);
		myDeleteImpl = new DeleteImpl();

	}

	@Override
	public void initialize(GameManager manager){
		super.initialize(manager);
		myDeleteImpl.setRenderer(manager.getRenderer());;
	}


	@Override
	public void execute() {
		
		myDeleteImpl.delete(myGameObjects);
		
	}

}






