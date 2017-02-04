package org.usfirst.frc.team3328.robot.subsystems;

import org.usfirst.frc.team3328.robot.utilities.Controller;

import edu.wpi.first.wpilibj.SpeedController;

public class SteamWorksFeeder implements Feeder{ 

	SpeedController feeder;
	Controller xbox;
	boolean active = false;

	public SteamWorksFeeder(SpeedController talonController, Controller xboxController){ 
		feeder = talonController;
		xbox = xboxController;	
	}

	//Toggles feeder on and off when A and B is pressed
	@Override
	public void controlFeeder() {
		if (xbox.getButtonRelease(1) || xbox.getButtonRelease(2)){
			if (active) {
				feeder.set(0);
			}else{
				feeder.set(1);
			}
			active = !active;
		}
	}
	
	
	
}
