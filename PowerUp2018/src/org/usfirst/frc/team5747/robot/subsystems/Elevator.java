package org.usfirst.frc.team5747.robot.subsystems;

import org.usfirst.frc.team5747.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Elevator extends LimitedSubsystem {
	public static final double ELEVATOR_MINUS =-0.1;
	public static final double ELEVATOR_SPEED = -1;
    private SpeedController motor;
    public Elevator(SpeedController motor)
    {
    	this.motor = motor; 
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new MoveLimitedSubsystem(Robot.elevator, Robot.oi::getElevator));
    }

	@Override
	public PIDSource getPIDSource() {
		
		return null;
	}

	@Override
	public boolean isMax() {
		return false;
	}

	@Override
	public boolean isMin() {
		return false;
	}

	@Override
	protected void move(double speed) {
		motor.set(speed);
		
	}
	

}

