package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Controller {
	
	Joystick joy;
	Joystick xbox;
	
	boolean joystick;
	
	
	public Controller(boolean type){
		if(type){
			joystick = true;
			joy = new Joystick(0);
		}else{
			joystick = false;
			xbox = new Joystick(0);
		}
	}
	
	public double getX(){
		if (joystick)
			return joy.getX();
		return xbox.getRawAxis(2);
	}
	
	public double getY(){
		if (joystick)
			return joy.getY();
		return xbox.getRawAxis(1);
	}
	
	public boolean getB1(){
		if(joystick)
			return joy.getRawButton(0);
		return xbox.getRawButton(0);
	}
	
}
