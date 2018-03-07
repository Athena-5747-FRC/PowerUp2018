package org.usfirst.frc.team5747.robot.auto;

import org.usfirst.frc.team5747.robot.Robot;

public class routines {
	public static void right_to_right() {
		
	}
	
	public static void straight() {
		double startTime = System.currentTimeMillis();
		double currTime = 0;
		while(currTime < 1000) {
			Robot.drivetrain.setLeft(0.8);
			Robot.drivetrain.setRight(0.8);
			currTime = System.currentTimeMillis() - startTime ;
			System.out.println(currTime);
		}
		Robot.drivetrain.setLeft(0);
		Robot.drivetrain.setRight(0);
	}
	
	public static void left_to_left() {
		double startTime = System.currentTimeMillis();
		double currTime = 0;
		while(currTime < 400) {
			Robot.flipcube.tryMove(Robot.flipcube.MINUS_FLIP);
			currTime = System.currentTimeMillis() - startTime ;
			System.out.println(currTime);
		}
		while (currTime < 165000)
		{
			Robot.flipcube.tryMove(Robot.flipcube.HOLD_FLIP);
		}
		while(currTime < 1400) 
		{
			Robot.drivetrain.setLeft(0.8);
			Robot.drivetrain.setRight(0.8);
			currTime = System.currentTimeMillis() - startTime ;
			System.out.println(currTime);
		}
		while(currTime < 1650) {
			Robot.drivetrain.setLeft(0.8);
			Robot.drivetrain.setRight(0);
			currTime = System.currentTimeMillis() - startTime ;
			System.out.println(currTime);
		}
		while(currTime < 2000) {
			Robot.drivetrain.setLeft(0.8);
			Robot.drivetrain.setRight(0.8);
			currTime = System.currentTimeMillis() - startTime ;
			System.out.println(currTime);
		}
		while(currTime < 2250) {
			Robot.drivetrain.setLeft(0.8);
			Robot.drivetrain.setRight(0);
			currTime = System.currentTimeMillis() - startTime ;
			System.out.println(currTime);
		}
		while(currTime < 3250)
		{
			
		}
	
		Robot.drivetrain.setLeft(0);
		Robot.drivetrain.setRight(0);
		Robot.flipcube.tryMove(0);
		
	}
	
}

