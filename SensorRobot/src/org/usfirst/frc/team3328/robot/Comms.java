package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Comms {

	NetworkTable table;
	
	public Comms(){
		table = NetworkTable.getTable("numTable");
	}
	
	public void update(double num){
		table.putNumber("num", num);
	}
	
	
}
