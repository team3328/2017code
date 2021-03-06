package org.usfirst.frc.team3328.robot.utilities;

public interface Controller {

	//returns the x axis value for the joystick
	//returns the right trigger minus the left trigger for the xbox to allow for forwards and reverse
	double getX();

	//returns the y axis for the joystick
	//returns the x axis for the xbox with a deadband of .1
	double getY();

	//returns true when the button with the index "num" has been released
	boolean getButtonRelease(int num);

	boolean getButtonPress(int num);

}