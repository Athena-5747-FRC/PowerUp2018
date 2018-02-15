package org.usfirst.frc.team5747.robot.commands;

import org.usfirst.frc.team5747.robot.subsystems.Drivetrain;

import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

/**
 *
 */
public class DriveToSwitch extends DriveArcade {
	
	public static final int ENCODER_VALUE = 4000; 
	private Drivetrain drivetrain;
    public DriveToSwitch(Drivetrain drivetrain, double moveValue, double rotateValue) {
        super(drivetrain,moveValue, rotateValue);
        this.drivetrain = drivetrain;
    }
    
    protected boolean isFinished() {
    	if (drivetrain.getEncodersValue() > ENCODER_VALUE)
    	{
    		return true;
    	}
        return false;
    }
}
