package org.usfirst.frc.team5747.robot.subsystems;

import com.spikes2212.genericsubsystems.LimitedSubsystem;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class Elevator extends LimitedSubsystem {

    SpeedController motor;
    DigitalInput min, max;
    Encoder encoder;
    public Elevator(SpeedController motor,DigitalInput min,DigitalInput max,Encoder encoder)
    {
    	this.motor = motor; //if motor speed is positive - Up (to max) if not, invert the motor.
    	this.min = min; //Make sure that the DIOs are true while held.
    	this.max = max;
    	this.encoder = encoder;
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public PIDSource getPIDSource() {
		// TODO Auto-generated method stub
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
}

