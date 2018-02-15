/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5747.robot;

import org.usfirst.frc.team5747.robot.commands.commandgroups.CubeToSwitchOrScaleAutoL;
import org.usfirst.frc.team5747.robot.commands.commandgroups.CubeToSwitchOrScaleAutoR;
import org.usfirst.frc.team5747.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5747.robot.subsystems.Elevator;
import org.usfirst.frc.team5747.robot.subsystems.FlipCube;
import org.usfirst.frc.team5747.robot.subsystems.IntakeCube;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.spikes2212.utils.DoubleSpeedcontroller;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static IntakeCube intakecube;
	public static FlipCube flipcube;
	public static Drivetrain drivetrain;
	public static Elevator elevator;
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		drivetrain = new Drivetrain(
				new DoubleSpeedcontroller(new WPI_TalonSRX(RobotMap.CAN.DRIVE_LEFT_1),
						new DoubleSpeedcontroller(new WPI_TalonSRX(RobotMap.CAN.DRIVE_LEFT_2), new WPI_TalonSRX(RobotMap.CAN.DRIVE_LEFT_3))),
				new DoubleSpeedcontroller(new WPI_TalonSRX(RobotMap.CAN.DRIVE_RIGHT_1),
						(new DoubleSpeedcontroller(new WPI_TalonSRX(RobotMap.CAN.DRIVE_RIGHT_2), new WPI_TalonSRX(RobotMap.CAN.DRIVE_RIGHT_3)))), new Encoder(RobotMap.DIO.DRIVETRAIN1_ENCODER_A, RobotMap.DIO.DRIVETRAIN1_ENCODER_B), new Encoder(RobotMap.DIO.DRIVETRAIN2_ENCODER_A, RobotMap.DIO.DRIVETRAIN2_ENCODER_B));
		elevator = new Elevator(
				new WPI_TalonSRX(RobotMap.CAN.ELEVATOR),
				new DigitalInput(RobotMap.DIO.ELEVATOR_MIN), new DigitalInput(RobotMap.DIO.ELEVATOR_MAX),
				new Encoder(RobotMap.DIO.ELEVATOR_ENCODER_A, RobotMap.DIO.ELEVATOR_ENCODER_B));
		flipcube = new FlipCube(new WPI_TalonSRX(RobotMap.CAN.FLIP));
		intakecube = new IntakeCube(new WPI_TalonSRX(RobotMap.CAN.INTAKE_LEFT), new WPI_TalonSRX(RobotMap.CAN.INTAKE_RIGHT));
		oi = new OI();
		chooser.addObject("Switch/Scale Right", new CubeToSwitchOrScaleAutoR());
		chooser.addDefault("Switch/Scale Left", new CubeToSwitchOrScaleAutoL());
		SmartDashboard.putData(chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		
		  String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		  switch(autoSelected) { case "My Auto": autonomousCommand = new
		  CubeToSwitchOrScaleAutoR(); break; case "Default Auto": default: autonomousCommand = new
		  CubeToSwitchOrScaleAutoR(); break; }
		 

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
