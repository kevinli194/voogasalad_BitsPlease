// This entire file is part of my masterpiece.
// Ben Reisner
package engine.actions;

import java.util.Collection;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;

/**
 * 
 * @author Ben
 *
 */
public abstract class VelocityIDAction extends VectorPhysicsAction {

	public VelocityIDAction(Collection<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected TwoArgInterface determineOperation(
			Collection<GameObject> myObjects, Object value) {
		Vector vector = new Vector();
		return (x, y) -> x.getPhysicsBody().setVelocity(
				determineVector(x, (Double) value, vector));
	}

}
