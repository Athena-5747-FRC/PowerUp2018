package org.usfirst.frc.team5747.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class IntakeCube extends LimitedSubsystem {
	public static final double INTAKE = 0.7;
	public static final double OUTTAKE = -0.7;
	private SpeedController motorLeft;
	private SpeedController motorRight;
	public IntakeCube (SpeedController motorLeft,SpeedController motorRight)
	{
		this.motorLeft = motorLeft;
		this.motorRight = motorRight;
		motorRight.setInverted(true);
		
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
		motorRight.set(speed);
		motorLeft.set(speed);
	}
}

