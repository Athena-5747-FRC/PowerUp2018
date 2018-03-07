package org.usfirst.frc.team5747.robot.subsystems;

import org.usfirst.frc.team5747.robot.Robot;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Drivetrain extends TankDrivetrain {
	private SpeedController right,left;
	private Encoder rightEncoder,leftEncoder;
	
	public Drivetrain(SpeedController left, SpeedController right, Encoder rightEncoder, Encoder leftEncoder) {
		this.right = right;
		this.left = left;
		left.setInverted(true);
		this.rightEncoder = rightEncoder;
		this.leftEncoder = leftEncoder;
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade(Robot.drivetrain, Robot.oi::getForwardDriver, Robot.oi::getRotationDriver));
	}

	@Override
	public PIDSource getLeftPIDSource() {
		return leftEncoder;
	}

	@Override
	public PIDSource getRightPIDSource() {
		return rightEncoder;
	}

	@Override
	public void setLeft(double speed) {
		left.set(speed);
		
	}

	@Override
	public void setRight(double speed) {
		right.set(speed);
		
	}
	public int getEncodersValue()
	{
		
		return (rightEncoder.get()+leftEncoder.get())/2;
		
	}

}
