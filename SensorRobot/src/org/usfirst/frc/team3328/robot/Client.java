package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Client {
	
	NetworkTable table;
	
	public Client(){
		//NetworkTable.setClientMode();
		NetworkTable.setIPAddress("172.22.11.2");
		table = NetworkTable.getTable("numTable");
	}
	
	public void run(){
		
		//for(;;){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
			
			double num = table.getNumber("num", 0.0);
			System.out.println(num);
		//}
	}
}
