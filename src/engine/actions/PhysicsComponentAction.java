// This entire file is part of my masterpiece.
// Ben Reisner
package engine.actions;

import java.util.Collection;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Ben
 *
 */
public abstract class PhysicsComponentAction extends PhysicsIDAction {

	public PhysicsComponentAction(Collection<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	public void applyPhysics(Collection<GameObject> myObjects) {
		loopAndExecute(myObjects, determineOperation(myObjects, myValue),
				myValue);
	}

	protected abstract TwoArgInterface determineOperation(
			Collection<GameObject> myObjects, Object value);

}
