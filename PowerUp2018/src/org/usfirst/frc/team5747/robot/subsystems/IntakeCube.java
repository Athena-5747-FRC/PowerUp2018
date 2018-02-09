package org.usfirst.frc.team5747.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class IntakeCube extends LimitedSubsystem {
	public final double INTAKE = 0.7;
	public final double OUTTAKE = -0.7;
	private SpeedController motor;
	public IntakeCube (SpeedController motor)
	{
		this.motor = motor;
		
	}
	public void initDefaultCommand() {
    	//None.
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

