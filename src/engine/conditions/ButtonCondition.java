package engine.conditions;

import java.util.ArrayList;
import java.util.List;

import engine.actions.Action;
import javafx.scene.input.KeyCode;

public class ButtonCondition extends Condition {
    
    private ArrayList<KeyCode> myKeyList;
    
    public ButtonCondition (ArrayList<Action> actions, ArrayList<KeyCode> keyList) {
        super(actions);
        myKeyList = keyList;
    }
    
    public String getKeyIdentifier() {
    	return myId.getUniqueId();
    }
    
    public ArrayList<KeyCode> getKeyList()
    {
    	return myKeyList;
    }
    
    public void addKey(KeyCode kc)
    {
    	if(!myKeyList.contains(kc))
    	{
    		myKeyList.add(kc);
    	}    	
    }
    
    public void removeKey(KeyCode kc){
    	myKeyList.remove(kc);
    }
    
    public void setKeyIdentifier(String id)
    {
    	myId.setUniqueId(id);
    }

    @Override
    protected void executeActions () {
    	boolean shouldExecute = false;
    	for (KeyCode myKey : myKeyList){
            if (ButtonConditionManager.getInstance().keyIsActive(myKey)){
                shouldExecute = true;
            }
    	}
    	if (shouldExecute){
    		for (Action a : getActions()){
                a.execute();
            }
    	}
    }
    
    @Override
    public void frameElapsed () {
        executeActions();
    }
}
