package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class NetworkTablesClientSide {
	
	public static void main(String[] args){
		new NetworkTablesClientSide().run();
	}

	public void run(){
		NetworkTable.setClientMode();
		NetworkTable.setIPAddress("address");
		NetworkTable table = NetworkTable.getTable("numTable");
		
		for(;;){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
			
			double num = table.getNumber("num", 0.0);
			System.out.println(num);
		}
	}
	
}
