package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;

public class Client{ //implements ITableListener {
	
	NetworkTable table;
	
	public Client(){
		//NetworkTable.setClientMode();
		NetworkTable.setIPAddress("172.22.11.2");
		table = NetworkTable.getTable("numTable");
		//table.addTableListener(this);
	}
	
	public void run(){
		try{
			Thread.sleep(33);
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
		
		double x = table.getNumber("X", 0.0);
		double y = table.getNumber("Y", 0.0);
		System.out.printf("(%04.2f, %04.2f)\n", x, y);
	}
	
	/*@Override
	public void valueChanged(ITable itable, String string, Object o, boolean bln){
		System.out.println("hello");
		System.out.println("value = " + o + "| bln = " + bln);
	}*/
}