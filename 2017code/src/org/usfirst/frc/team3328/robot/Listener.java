package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Listener implements Runnable {
	
	Thread listener;
	Target target;
	NetworkTable table;
	double angle = 0;
	double distance = 0;
	
	public Listener(){
	}
	
	public Listener(String name, Target object){
		listener = new Thread(this, name);
		target = object;
		//NetworkTable.setClientMode();
		NetworkTable.setIPAddress("172.22.11.2");
		table = NetworkTable.getTable("JetsonData");
		//table.addTableListener(list, false);
		System.out.printf("Created thread %s\n", name);
		listener.start();
	}
	
	/*private final ITableListener list = new ITableListener(){
		@Override
		public void valueChanged(ITable source, String key, Object value, boolean isNew) {
			if (key.equals("angle")){
				angle = (double) value;
			}else{
				distance = (double) value;
			}
		}
	};*/

	public void run(){
		for(;;){
			if (table.getNumber("angle", 0.0) == 500){
				try{
					Thread.sleep(5000);
				}catch(Exception e){
					
				}
			}
			target.setTime(System.nanoTime());
			target.setAngle(table.getNumber("angle", 0.0)); 	
			target.setDistance(table.getNumber("distance", 0.0));
		}
	}

}
