package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.Talon;

public class Climber {
	
	Controller con;
	Talon talon;
	boolean active = false;
	
	public Climber(Controller controller){
		talon = new Talon(5);
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
		if (con.getButton(1)){
			active = !active;
			System.out.println("Climber: " + active);
		}
		return active;
	}
	
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
