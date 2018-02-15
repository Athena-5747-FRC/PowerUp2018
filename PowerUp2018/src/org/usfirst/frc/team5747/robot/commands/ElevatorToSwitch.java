package org.usfirst.frc.team5747.robot.commands;

import org.usfirst.frc.team5747.robot.subsystems.Elevator;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

/**
 *
 */
public class ElevatorToSwitch extends MoveLimitedSubsystem {
	public static final int ENCODER_VALUE = 2000;
	private Elevator subsystem;
    public ElevatorToSwitch(Elevator subsystem, double speed) {
        super(subsystem,speed);
        this.subsystem = subsystem;
    }

    protected boolean isFinished() {
    	if (subsystem.getEncoderValue() < ENCODER_VALUE)
    	{
    		return true;
    	}
        return false;
    }

}
