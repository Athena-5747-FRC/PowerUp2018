package org.usfirst.frc.team5747.robot;

import org.usfirst.frc.team5747.util.XboXUID;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.buttons.Button;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private XboXUID driver = new XboXUID(0);
	private XboXUID operator = new XboXUID(1);
	private Button openIntake;
	public OI() {
		openIntake = operator.getYellowButton();
		operatorButtons();
	}
	public void operatorButtons() {
		openIntake.whileHeld(new MoveLimitedSubsystem(Robot.flipcube, Robot.flipcube.FLIP_SPEED));
	}



	public double getForwardDriver() {
		return  Math.pow(driver.getLeftY(), 3);
	}

	public double getRotationDriver() {
		return Math.pow(driver.getRightX(), 3);
	}
	public double getElevator() {
		return  Math.pow(operator.getLeftY(), 3);
	}
	public double getIntakeRight() {
		return -Math.pow(operator.getRightIntake(), 3);
	}

	public double getIntakeLeft() {
		return (Math.pow(operator.getLeftIntake(), 3));
	}
	

}