/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5747.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public interface CAN
	{
		public static final int DRIVE_LEFT_1 = 6;
		public static final int DRIVE_LEFT_2 = 1;
		public static final int DRIVE_LEFT_3 = 4;
		public static final int DRIVE_RIGHT_1 = 0;
		public static final int DRIVE_RIGHT_2 = 9;
		public static final int DRIVE_RIGHT_3 = 8;
		public static final int ELEVATOR = 7;
		public static final int INTAKE_RIGHT= 5;
		public static final int INTAKE_LEFT = 3;
		public static final int FLIP = 2;
	}
	public interface DIO
	{
		public static final int ELEVATOR_MIN = 3;
		public static final int ELEVATOR_MAX = 4;
		public static final int ELEVATOR_ENCODER_A = 5;
		public static final int ELEVATOR_ENCODER_B = 6;
	}
}
