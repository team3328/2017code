package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Comms {

	NetworkTable table;
	double x = 0, y = 0;
	
	public Comms(){
		table = NetworkTable.getTable("numTable");
	}
	
	public void update(){
		table.putNumber("num", x++);
		table.putNumber("Y", y++);
	}
	
	
}
