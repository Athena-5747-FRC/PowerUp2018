package org.usfirst.frc.team5747.robot.commands.commandgroups;

import org.usfirst.frc.team5747.robot.Robot;
import org.usfirst.frc.team5747.robot.commands.DriveToSwitch;
import org.usfirst.frc.team5747.robot.commands.ElevatorToSwitch;
import org.usfirst.frc.team5747.robot.subsystems.IntakeCube;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScaleLeft extends CommandGroup {
	String gameData = DriverStation.getInstance().getGameSpecificMessage();
	public static final double FORWARD_SPEED = 0.5;
	public static final double ELEVATOR_SPEED = 0.5;
	public static final double HOLDINTHEAIR = 0.1;
    public ScaleLeft() {
        if (gameData.length() > 0 && gameData.charAt(0) == 'L' && gameData.charAt(1) == 'R')
        {
        	addSequential(new DriveToSwitch(Robot.drivetrain, 0 , FORWARD_SPEED), 3);
        	addSequential(new ElevatorToSwitch(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new ElevatorToSwitch(Robot.elevator, HOLDINTHEAIR ));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
        }
        else if (gameData.length() > 0 && gameData.charAt(0) == 'R' && gameData.charAt(1) == 'L')
        {
        	addSequential(new DriveToSwitch(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	addSequential(new DriveToSwitch(Robot.drivetrain, 0 , FORWARD_SPEED), 2);
        	addSequential(new ElevatorToSwitch(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new ElevatorToSwitch(Robot.elevator, HOLDINTHEAIR ));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
        }
        else if (gameData.length() > 0 && gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L')
        {
        	addSequential(new DriveToSwitch(Robot.drivetrain, 0 , FORWARD_SPEED), 3);
        	addSequential(new ElevatorToSwitch(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new ElevatorToSwitch(Robot.elevator, HOLDINTHEAIR ));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
        }
        else
        {
        	addSequential(new DriveToSwitch(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	addSequential(new DriveToSwitch(Robot.drivetrain, 0 , FORWARD_SPEED), 2);
        	addSequential(new ElevatorToSwitch(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new ElevatorToSwitch(Robot.elevator, HOLDINTHEAIR ));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
        }
        
    }
}
