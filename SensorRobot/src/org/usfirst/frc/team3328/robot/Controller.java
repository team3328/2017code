package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Controller {
	
	Joystick joy;
	XboxController xbox;
	
	//true if you're using a joystick
	boolean joystick;
	//array to store previous value of buttons
	boolean[] button = new boolean[10];
	
	//instantiates a joystick if true an xbox controller if false.
	public Controller(boolean type){
		if(type){
			joystick = true;
			joy = new Joystick(0);
		}else{
			joystick = false;
			xbox = new XboxController(0);
		}
	}
	
	//returns the x axis value for the joystick
	//returns the right trigger minus the left trigger for the xbox to allow for forwards and reverse
	public double getX(){
		if (joystick){
			return joy.getX();
		}
		return xbox.getRawAxis(3) - xbox.getRawAxis(2);
	}
	
	//returns the y axis for the joystick
	//returns the x axis for the xbox with a deadband of .1
	public double getY(){
		if (joystick){
			return joy.getY();
		}
		if (Math.abs(xbox.getRawAxis(0)) > .1){
			return xbox.getRawAxis(0);
		}
		return 0;
	}
	
	//returns true when the button with the index "num" has been released
	public boolean getButton(int num){
		if(joystick){
			return joy.getRawButton(num);
		}
		if (xbox.getRawButton(num) &&  !button[num]){
			button[num] = xbox.getRawButton(num);
			return true;
		}
		button[num] = xbox.getRawButton(num);
		return false;
	}
	
}
