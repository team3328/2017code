package org.usfirst.frc.team3328.robot.networking;

import java.io.Serializable;

public class Target implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double pixel; 
	private double distance;
	private long lastTime = 0, time = 0;
	private boolean status = false;
	
	public double getPixel(){
		return pixel;
	}
	
	public void setPixel(double ang){
		//System.out.println("set pixel to " + ang);
		pixel = ang;
	}
	
	public double getDistance(){
		return distance;
	}
	
	public void setDistance(double dist){
		distance = dist;
	}
	
	public void setStatus(boolean stat){
		status = stat;
	}
	
	public boolean getStatus(){
		return status;
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
		System.out.printf("Pixel: %06.2f || Distance: %.2f || New: %b || Status: %b\n", getPixel(), getDistance(), isNew(), getStatus());
	}
}
