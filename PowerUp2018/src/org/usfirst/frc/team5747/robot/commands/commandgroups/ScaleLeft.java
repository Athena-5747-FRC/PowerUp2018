package org.usfirst.frc.team5747.robot.commands.commandgroups;

import org.usfirst.frc.team5747.robot.Robot;
import org.usfirst.frc.team5747.robot.commands.DriveAuto;
import org.usfirst.frc.team5747.robot.commands.ElevatorAuto;
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
        	addSequential(new DriveAuto(Robot.drivetrain, 0 , FORWARD_SPEED), 3);
        	addSequential(new ElevatorAuto(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new ElevatorAuto(Robot.elevator, HOLDINTHEAIR ));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
        }
        else if (gameData.length() > 0 && gameData.charAt(0) == 'R' && gameData.charAt(1) == 'L')
        {
        	addSequential(new DriveAuto(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	addSequential(new DriveAuto(Robot.drivetrain, 0 , FORWARD_SPEED), 2);
        	addSequential(new ElevatorAuto(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new ElevatorAuto(Robot.elevator, HOLDINTHEAIR ));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
        }
        else if (gameData.length() > 0 && gameData.charAt(0) == 'L' && gameData.charAt(1) == 'L')
        {
        	addSequential(new DriveAuto(Robot.drivetrain, 0 , FORWARD_SPEED), 3);
        	addSequential(new ElevatorAuto(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new ElevatorAuto(Robot.elevator, HOLDINTHEAIR ));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
        }
        else
        {
        	addSequential(new DriveAuto(Robot.drivetrain, FORWARD_SPEED , 0), 3);
        	addSequential(new DriveAuto(Robot.drivetrain, 0 , FORWARD_SPEED), 2);
        	addSequential(new ElevatorAuto(Robot.elevator, ELEVATOR_SPEED), 4);
            addParallel(new ElevatorAuto(Robot.elevator, HOLDINTHEAIR ));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE));
        }
        
    }
}
