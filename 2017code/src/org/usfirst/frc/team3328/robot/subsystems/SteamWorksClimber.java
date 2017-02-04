package org.usfirst.frc.team3328.robot.subsystems;

import org.usfirst.frc.team3328.robot.utilities.Controller;

import edu.wpi.first.wpilibj.SpeedController;

public class SteamWorksClimber implements Climber {
	
	Controller con;
	SpeedController winch;
	boolean active = false;
	double factor = 5;
	
	public SteamWorksClimber(SpeedController speedController, Controller controller){
		winch = speedController;
		con = controller;
	}
	
	private void move(double speed){
		winch.set(speed / factor);
	}
	
	//Sets the climber to the xbox x-axis
	// x-axis = right trigger - left trigger
	@Override
	public void controlClimber(){
			if (con.getX() > 0){
				move(con.getX());
			} 
	}
	
}
