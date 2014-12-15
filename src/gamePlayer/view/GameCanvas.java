package gamePlayer.view;

import javafx.scene.Group;
import javafx.scene.Node;

public class GameCanvas implements ViewController{
	
	private Group myCanvas;
	
	public GameCanvas() {
		myCanvas = new Group();
	}
	
	@Override
	public Group getNode() {
		return (Group)myCanvas;
	}
		
	public void addToGroup(Node node){
		myCanvas.getChildren().add(node);
	}
	
	public void clear(){
		myCanvas.getChildren().clear();
	}
	
}
