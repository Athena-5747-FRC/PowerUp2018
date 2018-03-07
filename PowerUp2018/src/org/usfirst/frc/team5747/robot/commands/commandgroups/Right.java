package org.usfirst.frc.team5747.robot.commands.commandgroups;

import org.usfirst.frc.team5747.robot.Robot;
import org.usfirst.frc.team5747.robot.subsystems.Elevator;
import org.usfirst.frc.team5747.robot.subsystems.FlipCube;
import org.usfirst.frc.team5747.robot.subsystems.IntakeCube;

import com.spikes2212.genericsubsystems.commands.MoveLimitedSubsystem;
import com.spikes2212.genericsubsystems.drivetrains.commands.DriveArcade;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Right extends CommandGroup {
	public static final double FORWARD_SPEED = 0.5;
	public static final double ELEVATOR_SPEED = 0.5;
	public static final double HOLDINTHEAIR = 0.1;
    public Right() {
   
    	if (Robot.gameData.length() > 0 && Robot.gameData.charAt(0) == 'L' && Robot.gameData.charAt(1) == 'R')
        {
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.MINUS_FLIP),0.5);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 3.9);
         	addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.ELEVATOR_SPEED), 2.5);
            addParallel(new MoveLimitedSubsystem(Robot.elevator, Elevator.ELEVATOR_MINUS ));
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 0.5);
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),0.4);
            addSequential(new DriveArcade(Robot.drivetrain, 0 , FORWARD_SPEED), 0.5);
            addSequential(new MoveLimitedSubsystem(Robot.elevator, -Elevator.ELEVATOR_SPEED), 1.5);
            addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.2);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 0.8);
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.MINUS_FLIP),0.7);
            addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 1.35);
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.INTAKE),1);
            addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.23);
            addSequential(new DriveArcade(Robot.drivetrain, 0, -FORWARD_SPEED), 0.7);
        }
        else if (Robot.gameData.length() > 0 && Robot.gameData.charAt(0) == 'R' && Robot.gameData.charAt(1) == 'L')
        {
            addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.MINUS_FLIP),0.4);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 3.5);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 0.55);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 0.55);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 0.65);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 0.35);
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),1);
        	addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.5);
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.MINUS_FLIP),0.7);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 0.5);
        	addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.INTAKE),2);
        	addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.2);
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.FLIP_SPEED),1.6);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 0.15);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),1.5);
        }
        else if (Robot.gameData.length() > 0 && Robot.gameData.charAt(0) == 'R' && Robot.gameData.charAt(1) == 'R')
        {
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.MINUS_FLIP),0.5);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 3.9);
         	addSequential(new MoveLimitedSubsystem(Robot.elevator, Elevator.ELEVATOR_SPEED), 2.5);
            addParallel(new MoveLimitedSubsystem(Robot.elevator, Elevator.ELEVATOR_MINUS ));
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , FORWARD_SPEED), 0.5);
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),0.4);
            addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 0.5);
            addSequential(new MoveLimitedSubsystem(Robot.elevator, -Elevator.ELEVATOR_SPEED), 1.5);
            addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.2);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , FORWARD_SPEED), 0.8);
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.MINUS_FLIP),0.7);
            addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 1.35);
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.INTAKE),1);
            addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.23);
            addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.FLIP_SPEED),0.8);
            addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
            addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.2);  
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),1);	
        }
        else if (Robot.gameData.length() > 0 && Robot.gameData.charAt(0) == 'L' && Robot.gameData.charAt(1) == 'L')
        {
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.MINUS_FLIP),0.4);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 3.5);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , -FORWARD_SPEED), 0.55);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 5.25);
        	addSequential(new DriveArcade(Robot.drivetrain, 0 , FORWARD_SPEED), 0.65);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 0.35);
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),1);
        	addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.5);
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.MINUS_FLIP),0.7);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 0.5);
        	addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.INTAKE),2);
        	addSequential(new DriveArcade(Robot.drivetrain, -FORWARD_SPEED ,0 ), 0.2);
        	addSequential(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.FLIP_SPEED),1.6);
        	addSequential(new DriveArcade(Robot.drivetrain, FORWARD_SPEED ,0 ), 0.15);
        	addParallel(new MoveLimitedSubsystem(Robot.flipcube, FlipCube.HOLD_FLIP));
            addSequential(new MoveLimitedSubsystem(Robot.intakecube, IntakeCube.OUTTAKE),1.5);
        }
    }
        
    }

