package org.usfirst.frc.team3328.robot.utilities;

import edu.wpi.first.wpilibj.Joystick;

public class SteamWorksJoystick implements Controller {
	
	Joystick joy;

	//array to store previous value of buttons
	boolean[] button = new boolean[10];
	
	//instantiates the joystick
	public SteamWorksJoystick(boolean type){
		joy = new Joystick(0);
	}
	
	//returns the x axis value for the joystick
	@Override
	public double getX(){
		return joy.getX();
	}
	
	//returns the y axis for the joystick
	@Override
	public double getY(){
		return joy.getY();
	}
	
	//returns true when the button with the index "num" has been released
	@Override
	public boolean getButtonRelease(int num){
		if (joy.getRawButton(num) &&  !button[num]){
			button[num] = joy.getRawButton(num);
			return true;
		}
		button[num] = joy.getRawButton(num);
		return false;
	}
	
	//return true when button "num" 
	@Override
	public boolean getButtonPress(int num){
		return joy.getRawButton(num);
	}

	
}