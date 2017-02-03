package org.usfirst.frc.team3328.robot.subsystems;

import org.usfirst.frc.team3328.robot.utilities.Controller;

import edu.wpi.first.wpilibj.SpeedController;

public class SteamWorksClimber implements Climber {
	
	Controller con;
	SpeedController talon;
	boolean active = false;
	
	public SteamWorksClimber(SpeedController speedController, Controller controller){
		talon = speedController;
		con = controller;
	}
	
	private void up(double speed){
		talon.set(speed / 5);
	}
	
	private void down(double speed){
		talon.set(-speed / 5);
	}
	
	private void stop(){
		talon.set(0);
	}
	
	private boolean isActive(){
		if (con.getButtonRelease(1)){
			active = !active;
			System.out.println("Climber: " + active);
		}
		return active;
	}
	
	/* (non-Javadoc)
	 * @see org.usfirst.frc.team3328.robot.Climber#driverControl()
	 */
	@Override
	public void driverControl(){
		if (isActive()){
			if (con.getX() > 0){
				up(con.getX());
			}else{
				down(con.getY());
			}
		}else{
			stop();
		}
	}
	
}
