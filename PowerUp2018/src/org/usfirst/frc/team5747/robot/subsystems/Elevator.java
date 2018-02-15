package org.usfirst.frc.team5747.robot.subsystems;

import org.usfirst.frc.team5747.robot.Robot;

import com.spikes2212.genericsubsystems.LimitedSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Elevator extends LimitedSubsystem {
	public static final double ELEVATOR_SPEED =-0.1;
    private SpeedController motor;
    private DigitalInput min, max;
    private Encoder encoder;
    public Elevator(SpeedController motor,DigitalInput min,DigitalInput max,Encoder encoder)
    {
    	this.motor = motor; //if motor speed is positive - Up (to max) if not, invert the motor.
    	this.min = min; //Make sure that the DIOs are true while held.
    	this.max = max;
    	this.encoder = encoder;
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
		return max.get();
	}

	@Override
	public boolean isMin() {
		return min.get();
	}

	@Override
	protected void move(double speed) {
		motor.set(speed);
		
	}
	
	public int getEncoderValue()
	{
		return encoder.get();
		
	} 
}

