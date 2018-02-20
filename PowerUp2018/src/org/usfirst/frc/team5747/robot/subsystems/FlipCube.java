package org.usfirst.frc.team5747.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class FlipCube extends LimitedSubsystem {
	public static final double FLIP_SPEED = -0.8;
	public static final double HOLD_FLIP = -0.1;
    private SpeedController motor;
    
    public FlipCube (SpeedController motor)
    {
    	this.motor = motor;
    }
    public void initDefaultCommand() {
    }

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMax() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void move(double speed) {
		motor.set(speed);
	}
}

