package org.usfirst.frc.team5747.robot.subsystems;

import org.usfirst.frc.team5747.robot.Robot;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Drivetrain extends TankDrivetrain {
	private SpeedController right,left;
	
	public Drivetrain(SpeedController left, SpeedController right) {
		this.right = right;
		this.left = left;
		left.setInverted(true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade(Robot.drivetrain, Robot.oi::getForwardDriver, Robot.oi::getRotationDriver));
	}

	@Override
	public PIDSource getLeftPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PIDSource getRightPIDSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLeft(double speed) {
		left.set(speed);
		
	}

	@Override
	public void setRight(double speed) {
		right.set(speed);
		
	}

}
