package engine.actions;

import engine.GameManager;
import engine.actions.PhysicsAction.TwoArgInterface;
import engine.gameObject.GameObject;
import engine.physics.Impulse;

public class YImpulseAction extends ImpulseAction {

	public YImpulseAction(GameObject sprite, double value) {
		super(sprite, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(GameManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Impulse determineImpulse(double value) {
		return new Impulse(0, value);
	}

}
