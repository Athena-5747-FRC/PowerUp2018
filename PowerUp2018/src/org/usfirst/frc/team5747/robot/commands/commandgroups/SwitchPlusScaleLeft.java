package org.usfirst.frc.team5747.robot.commands.commandgroups;

import org.usfirst.frc.team5747.robot.Robot;
import org.usfirst.frc.team5747.robot.subsystems.FlipCube;
import org.usfirst.frc.team5747.robot.subsystems.IntakeCube;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SwitchPlusScaleLeft extends CommandGroup {
	public static final double FORWARD_SPEED = 0.5;
	public static final double ELEVATOR_SPEED = 0.5;
	public static final double HOLDINTHEAIR = 0.1;
    public SwitchPlusScaleLeft() {
        if (Robot.gameData.length() > 0 && Robot.gameData.charAt(0) == 'L' && Robot.gameData.charAt(1) == 'R')
        {
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 3);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 2);
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.FLIP_SPEED),2.5);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),0.5);
        }
        else if (Robot.gameData.length() > 0 && Robot.gameData.charAt(0) == 'R' && Robot.gameData.charAt(1) == 'L')
        {
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , FORWARD_SPEED), 2);
        	addSequential(new MoveLimitedSubsystem(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new MoveLimitedSubsystem(Robot.elevator, HOLDINTHEAIR ));
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.FLIP_SPEED),2.5);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),0.5);
        }
        else if (Robot.gameData.length() > 0 && Robot.gameData.charAt(0) == 'L' && Robot.gameData.charAt(1) == 'L')
        {
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 2);
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.FLIP_SPEED),2.5);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),0.5);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , FORWARD_SPEED), 2);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 2);
        	addSequential(new MoveLimitedSubsystem(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new MoveLimitedSubsystem(Robot.elevator, HOLDINTHEAIR ));
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.FLIP_SPEED),2.5);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),0.5);
        }
        else
        {
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	
        }
        
    }
}
