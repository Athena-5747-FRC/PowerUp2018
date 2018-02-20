package org.usfirst.frc.team5747.robot;

import org.usfirst.frc.team5747.robot.subsystems.Elevator;
import org.usfirst.frc.team5747.robot.subsystems.FlipCube;
import org.usfirst.frc.team5747.robot.subsystems.IntakeCube;
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
	private Button FlipIntake;
	private Button HoldIntake;
	private Button Intake;
	private Button Outtake;
	private Button Holdinair;
	public OI() {
		operatorButtons();
	}
	public void operatorButtons() {
		FlipIntake = driver.getYellowButton();
		HoldIntake = driver.getBlueButton();
		Intake = operator.getRedButton();
		Outtake = operator.getGreenButton();
		Holdinair = operator.getBlueButton();
		FlipIntake.whileHeld(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.FLIP_SPEED));
		HoldIntake.toggleWhenPressed(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
		Intake.whileHeld(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.INTAKE));
		Outtake.whileHeld(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
		Holdinair.toggleWhenPressed(new MoveLimitedSubsystem(Robot.elevator, Elevator.ELEVATOR_SPEED));
	}



	public double getForwardDriver() {
		return  -Math.pow(driver.getLeftY(), 3);
	}

	public double getRotationDriver() {
		return Math.pow(driver.getRightX(), 3);
	}
	public double getElevator() {
		return  Math.pow(operator.getLeftY(), 3);
	}


}