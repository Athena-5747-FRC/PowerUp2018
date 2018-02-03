package org.usfirst.frc.team5747.robot.subsystems;

import org.usfirst.frc.team5747.robot.Robot;

import com.spikes2212.genericsubsystems.drivetrains.TankDrivetrain;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class IntakeCube extends TankDrivetrain {
	
	private SpeedController rightMotor,leftMotor;
	
	public IntakeCube (SpeedController leftMotor, SpeedController rightMotor)
	{
		this.rightMotor = rightMotor;
		this.leftMotor = leftMotor;
		this.leftMotor.setInverted(true);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveArcade(Robot.intakecube, Robot.oi::getIntakeLeft, Robot.oi::getIntakeRight));
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
	public void setLeft(double speedLeft) {
		leftMotor.set(speedLeft);
	}
	@Override
	public void setRight(double speedRight) {
		rightMotor.set(speedRight);
	}
}

