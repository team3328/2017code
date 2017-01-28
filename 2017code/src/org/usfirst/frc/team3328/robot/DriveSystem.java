package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.Talon;

public class DriveSystem {
	
	Controller con;
	private Talon fl, fr, bl, br;
	private double restraint = 1;
	private double factor = 1.1;
	private double displacement;
	private boolean active = true;
	
	//instantiates talons assigns controller to "con"
	public DriveSystem(Controller controller){
		fl = new Talon(0);
		fr = new Talon(1);
		bl = new Talon(2);
		br = new Talon(3);
		
		con = controller;
	}
	
	//sets the right set of talons to the same value
	//the right side is inverted because of how it was wired
	private void right(double speed){
		speed = -speed;
		fr.set(speed);
		br.set(speed);
	}
	//sets the left set of talons to the same value
	private void left(double speed){
		fl.set(speed);
		bl.set(speed);
	}
	
	//stops motors
	private void stop(){
		fl.set(0);
		bl.set(0);
	}
	
	//formats and prints the value that the speed controllers are receiving.
	public void printSpeed(){
		System.out.printf("%.2f || %.2f\n",fl.get(), fr.get());
	}
	
	
	//Dynamic updating for strength of angle correction during auto
	private void updateFactor(){
		if (con.getButton(1) && factor > 1){
			factor -= .1;
		}
		if (con.getButton(2) && factor < 10){
			factor += .1;
		}
	}
	
	//the speed during teleop is divided by "restraint"
	//the left and right bumpers lower and raise "restraint" respectively
	//"restraint" is confined between 10 & 1
	private void restrain(){
		if (con.getButton(5) && restraint > 1){
			restraint -= 1;
		}
		if (con.getButton(6) && restraint < 10){
			restraint += 1;
		}
	}
	
	//toggles drive off and the climb system on because they share controlls
	private boolean driveActive(){
		if (con.getButton(1)){
			active = !active;
			System.out.println("driveMode: " + active);
		}
		return active;
	}
	
	//gets displacement between the desired angle and the current angle
	//normalizes displacement so it's between 0 - 1
	//rounds displacement off to 2 decimal places
	//all values above 0 and below .05 are set to .05
	public double updateDisplacement(double desired, double current){
		displacement = (current - desired) / 360;
		displacement = Math.round(displacement * 100) / 100;
		if (displacement > 0 && displacement < .05){
			displacement = .05;
		}
		return displacement;
	}
	
	//Uses the gyro to turn until it reaches a desired angle.
	//should work while moving and while stopped
	//the speed of each side is separately adjusted using the displacement
	public void autoAngle(double speed, double current, double desired){
		updateFactor();
		System.out.println(factor);
		updateDisplacement(desired, current);
		right((speed + displacement) * factor);
		left((speed - displacement) * factor);
	}
	
	public void autoMove(double distance){
		//accelerates and decelerates smoothly and quickly across a given distance, PID
	}
	
	
	//updates the value of "restraint"
	//sets each motor to the appropriate speed adjusted by the restraint
	public void controlledMove(){
		if (driveActive()){
			restrain();
			right((con.getX() - con.getY()) / restraint);
			left((con.getX() + con.getY()) / restraint);
		}else{
			stop();
		}
	}
	
}