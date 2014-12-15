// This entire file is part of my masterpiece.
// Ben Reisner
package engine.actions;

import java.util.Collection;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;
import engine.physics.Vector;
import engine.physics.Velocity;

/**
 * 
 * @author Ben
 *
 */

public class XVelocityIDAction extends VelocityIDAction {

	public XVelocityIDAction(Collection<Identifier> id, Double value) {
		super(id, value);
	}

	@Override
	protected Vector determineVector(GameObject object, double value,
			Vector vector) {
		vector = new Velocity(value, object.getPhysicsBody().getVelocity()
				.getY());
		return vector;
	}

}
