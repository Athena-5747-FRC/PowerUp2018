package org.usfirst.frc.team5747.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XboXUID extends Joystick {

	static final int X_RIGHT = 4;
	static final int X_LEFT = 0;
	static final int Y_RIGHT = 5; 
	static final int Y_LEFT = 1; 
	static final int FLIP_LEFT = 2;
	static final int FLIP_RIGHT = 3;
	

	public XboXUID(int port) {
		super(port);
	}

	public Button getGreenButton() {
		return new JoystickButton(this, 1);
	}

	public Button getBlueButton() {
		return new JoystickButton(this, 3);
	}
	

	public Button getRedButton() {
		return new JoystickButton(this, 2);
	}

	public Button getYellowButton() {
		return new JoystickButton(this, 4);
	}

	public Button getRtButton() {
		return new JoystickButton(this, 8);
	}

	public Button getRbButton() {
		return new JoystickButton(this, 6);
	}

	public Button getLtButton() {
		return new JoystickButton(this, 7);
	}

	public Button getLbButton() {
		return new JoystickButton(this, 5);
	}

	public double getRightX() {
		return getRawAxis(X_RIGHT);
	}

	public double getRightY() {
		return getRawAxis(Y_RIGHT);
	}
	public double getRightFlip() {
		return getRawAxis(FLIP_RIGHT);
	}

	public double getLeftX() {
		return getRawAxis(X_LEFT);
	}
	
	public double getLeftY() {
		return getY(); // Don't change this, for some reason it works
	}
	public double getLeftFlip() {
		return getRawAxis(FLIP_LEFT);
	}
	

	public Button getUpButton() {
		return new Button() {
			@Override
			public boolean get() {
				return getPOV() == 0;
			}
		};
	}

	public Button getDownButton() {
		return new Button() {
			@Override
			public boolean get() {
				return getPOV() == 180;
			}
		};
	}

	public Button getLeftButton() {
		return new Button() {
			@Override
			public boolean get() {
				return getPOV() == 270;
			}
		};
	}

	public Button getRightButton() {
		return new Button() {
			@Override
			public boolean get() {
				return getPOV() == 90;
			}
		};
	}
}