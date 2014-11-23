package engine.physics;

import java.util.HashMap;
import java.util.Map;

/**
 * class for force, extends vector, super for all forces
 * 
 * @author Ben
 *
 */
public abstract class Force extends Vector {
	protected double myForceValue;
	protected Map<String, Double> myValues;

	public Force(double x, double y, Scalar... scalar) {
		super(x, y);
		myValues = new HashMap<String, Double>();
		initializeMap(scalar);
		setDefaultValues();
		calculateForce();
	}

	/**
	 * other constructor, used to solve a problem we had
	 */
	public Force(Scalar... scalar) {
		this(0, 0, scalar);
	}

	public void addOrChangeValue(Scalar cur) {
		myValues.put(cur.toString(), cur.getValue());
		calculateForce();
		calculateMagnitude();
	}

	protected void initializeMap(Scalar[] scalar) {
		for (Scalar cur : scalar) {
			myValues.put(cur.toString(), cur.getValue());
		}
	}

	// following two methods are to add a direction to the force. for example,
	// if you want to make gravity in both x and y when it's only in y, just
	// pass through 1 to x
	public void setX(double x) {
		myXComponent = x * myForceValue;
		calculateMagnitude();
	}

	public void setY(double y) {
		myYComponent = y * myForceValue;
		calculateMagnitude();
	}

	/**
	 * abstract method that is used in force subclasses to calculate force based
	 * on instance variables
	 * 
	 * @return value of force
	 */
	protected abstract void calculateForce();

	protected abstract void setDefaultValues();
}
