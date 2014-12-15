// This entire file is part of my masterpiece.
// Ben Reisner
package engine.actions;

import java.util.ArrayList;
import java.util.Collection;
import engine.GameManager;
import engine.collision.objects.CollisionComposition;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * 
 * @author Ben
 *
 */
public abstract class PhysicsIDAction implements Action, Initializable {

	protected Object myValue;
	protected transient CollisionComposition myCollision;
	protected transient Collection<GameObject> myObjects;
	protected Collection<Identifier> myID;

	public PhysicsIDAction(Collection<Identifier> id, Object value) {
		myID = id;
		myValue = value;
	}

	@Override
	public void execute() {
		applyPhysics(myObjects);
	}

	@Override
	public void initialize(GameManager manager) {
		myCollision = new CollisionComposition();
		myObjects = new ArrayList<GameObject>();
		for (Identifier id : myID) {
			myObjects.add(manager.objectForIdentifier(id));
		}
	}

	protected void loopAndExecute(Collection<GameObject> myObjects,
			TwoArgInterface myOperation, Object value) {
		myObjects.forEach(x->myOperation.operation(x, value));
	}

	public abstract void applyPhysics(Collection<GameObject> myObjects);

	protected interface TwoArgInterface {
		public void operation(GameObject x, Object a);
	}

	// don't know if this was ever used, maybe for collisions
	protected interface ThreeArgInterface {
		public void operation(GameObject x, GameObject y, Object value);
	}
}
