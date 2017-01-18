package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Controller {
	
	Joystick joy;
	XboxController xbox;
	boolean joystick = true;
	
	public Controller(){
		try{
			joy = new Joystick(0);
		}catch(Exception e){
			joystick = false;
			xbox = new XboxController(0);
		}
	}
	
	public double getX(){
		if (joystick)
			return joy.getX();
		return xbox.getX();
	}
	public double getY(){
		if (joystick)
			return joy.getY();
		return xbox.getY();
	}
	
	
	
}
