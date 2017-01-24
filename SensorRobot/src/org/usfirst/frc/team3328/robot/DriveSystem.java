package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.Talon;

public class DriveSystem {
	
	Talon fl, fr, bl, br;
	Controller con;
	double restraint = 1;
	
	//instantiates talons and controller
	//sets controller to boolean to choose between joystick(true) or xbox(false)
	public void init(){
		fl = new Talon(0);
		fr = new Talon(1);
		bl = new Talon(2);
		br = new Talon(3);
		
		con = new Controller(false);
	}
	
	//sets the right set of talons to the same value
	//the right side is inverted because of how it was wired
	public void right(double speed){
		speed = -speed;
		fr.set(speed);
		br.set(speed);
	}
	//sets the left set of talons to the same value
	public void left(double speed){
		fl.set(speed);
		bl.set(speed);
	}
	
	//formats and prints the value that the speed controllers are receiving.
	public void printSpeed(){
		System.out.printf("%.2f || %.2f\n",fl.get(), fr.get());
	}
	
	//Uses the gyro to turn until it reaches a desired angle.
	//should work while moving and while stopped
	//the speed of each side is separately adjusted using the displacement after it's been normalized to a value between 0 - 1
	public void autoAngle(double speed, double current, double desired){
		double displacement = (current - desired);
		right(speed - (displacement / 360));
		left(speed + (displacement / 360));
	}
	
	public void autoMove(double distance){
		//accelerates and decelerates smoothly and quickly across a given distance, PID
	}
	
	//the speed during teleop is divided by "restraint"
	//the left and right bumpers lower and raise "restraint" respectively
	//"restraint" is confined between 10 & 1
	public void restrain(){
		if (con.getButton(5) && restraint > 1){
			restraint -= 1;
		}
		if (con.getButton(6) && restraint < 10){
			restraint += 1;
		}
	}
	
	//updates the value of "restraint"
	//sets each motor to the appropriate speed adjusted by the restraint
	public void controlledMove(){
		restrain();
		right((con.getX() - con.getY()) / restraint);
		left((con.getX() + con.getY()) / restraint);
	}
	
}
