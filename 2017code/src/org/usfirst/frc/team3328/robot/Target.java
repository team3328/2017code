package org.usfirst.frc.team3328.robot;

import java.io.Serializable;

public class Target implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double angle; 
	private double distance;
	private long lastTime = 0, time = 0;
	
	public synchronized double getAngle(){
		return angle;
	}
	
	public void setAngle(double ang){
		angle = ang;
	}
	
	public double getDistance(){
		return distance;
	}
	
	public void setDistance(double dist){
		distance = dist;
	}
	
	public void setTime(long stamp){
		time = stamp;
	}
	
	public boolean isNew(){
		if (time != lastTime){
			lastTime = time;
			return true;
		}else{
			return false;
		}
	}
	
	public void printValues(){
		System.out.printf("Angle: %.2f || Distance: %.2f || New: %b\n", getAngle(), getDistance(), isNew());
	}
}
