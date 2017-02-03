package org.usfirst.frc.team3328.robot.subsystems;

import org.usfirst.frc.team3328.robot.utilities.Controller;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

public class SteamWorksShooter implements Shooter {

	Encoder coder;
	SpeedController t1;
	SpeedController t2;
	Controller con;
	boolean active = false;
	
	public SteamWorksShooter(Encoder encoder, SpeedController talonController1, SpeedController talonController2, Controller controller){
		coder = encoder;
		t1 = talonController1;
		t2 = talonController2;
		con = controller; 
	}
	
	@Override
	public double getSpeed(){
		return coder.getRate();
	}
	
	private void maxSpeed(){
		t1.set(1);
		t2.set(2);
	}

	private void stop(){
		t1.set(0);
		t2.set(0);
	}

	// Method to check whether the button
	// is pressed and sets the talons to
	// max speed whether or not.
	@Override
	public void shooterControl(){
		if (con.getButtonRelease(3)){
			if (active){
				stop();
			}else{
				maxSpeed();
			}
			active = !active;
		}
	}
	
	
	
}
