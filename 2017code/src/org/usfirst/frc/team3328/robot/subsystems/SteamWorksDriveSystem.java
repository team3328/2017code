package org.usfirst.frc.team3328.robot.subsystems;

import org.usfirst.frc.team3328.robot.utilities.Controller;
import org.usfirst.frc.team3328.robot.utilities.DriveEncoders;
import org.usfirst.frc.team3328.robot.utilities.DriveTalons;

import edu.wpi.first.wpilibj.SpeedController;

public class SteamWorksDriveSystem implements DriveSystem {
	
	Controller con;
	private DriveTalons talons;
	private DriveEncoders encoders;
	private double restraint = 1;
	private double factor = 1.1;
	private double displacement;
	private double speed;
	private boolean active = true;
	
	//instantiates talons assigns controller to "con"
	public SteamWorksDriveSystem(DriveEncoders driveEncoders, DriveTalons driveTalons, Controller controller){
		encoders = driveEncoders;
		talons = driveTalons;
		con = controller;
	}
	
	@Override
	public double getSpeed(){
		speed = ((con.getX() + con.getY()) / restraint) * 10;
		speed = (speed * speed) / 100;
		return speed;
	}
	
	@Override
	//moves the robot
	public void move(double left, double right){
		talons.right(right);
		talons.left(left);
	}
	
	//formats and prints the value that the speed controllers are receiving.
	@Override
	public void printSpeed(){
		System.out.printf("%.2f || %.2f\n",talons.getfl(), talons.getfr());
	}
	
	
	//Dynamic updating for strength of angle correction during auto
	private void updateFactor(){
		if (con.getButtonRelease(1) && factor > 1){
			factor -= .1;
		}
		if (con.getButtonRelease(2) && factor < 10){
			factor += .1;
		}
	}
	
	//the speed during teleop is divided by "restraint"
	//the left and right bumpers lower and raise "restraint" respectively
	//"restraint" is confined between 10 & 1
	private void restrain(){
		if (con.getButtonRelease(5) && restraint > 1){
			restraint -= 1;
		}
		if (con.getButtonRelease(6) && restraint < 10){
			restraint += 1;
		}
	}
	
	//toggles drive off and the climb system on because they share controlls
	private boolean driveActive(){
		if (con.getButtonRelease(1)){
			active = !active;
			System.out.println("driveMode: " + active);
		}
		return active;
	}
	
	//gets displacement between the desired angle and the current angle
	//normalizes displacement so it's between 0 - 1
	//rounds displacement off to 2 decimal places
	//all values above 0 and below .05 are set to .05
	@Override
	public double updateDisplacement(double desired, double current){
		displacement = (current - desired) / 360;
		if (displacement > 0 && displacement < .05){
			displacement = .05;
		}
		return displacement;
	}
	
	//Uses the gyro to turn until it reaches a desired angle.
	//should work while moving and while stopped
	//the speed of each side is separately adjusted using the displacement
	@Override
	public void autoAngle(double speed, double current, double desired){
		updateFactor();
		System.out.println(factor);
		updateDisplacement(desired, current);
		talons.right((speed + displacement) * factor);
		talons.left((speed - displacement) * factor);
	}
	
	//takes a pixel offset to aim the robot
	//turns until it's within a 4 pixel range of target
	//turns at .2 if >50, .1 if < 50
	@Override
	public void track(double pixel){
		double sp = .08;
		if (pixel > 350){
			move(sp, -sp);
		}else if (pixel < 290){
			move(-sp, sp);
		}else{
			talons.stop();
		}
	}
	
	
	//updates the value of "restraint"
	//sets each motor to the appropriate speed adjusted by the restraint
	@Override
	public void controlledMove(){
		if (driveActive()){
			restrain();
			move((con.getX() + con.getY()) / restraint, 
				(con.getX() - con.getY()) / restraint);
		}else{
			talons.stop();
		}
	}
	
}