package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.Talon;

public class DriveSystem {
	
	Talon fl, fr, bl, br;
	
	Controller con;
	
	
	public void init(){
		fl = new Talon(0);
		fr = new Talon(1);
		bl = new Talon(2);
		br = new Talon(3);
		
		con = new Controller();
	}
	
	public void right(double speed){
		fr.set(speed);
		br.set(speed);
	}
	public void left(double speed){
		fl.set(speed);
		bl.set(speed);
	}
	
	public void printSpeed(){
		System.out.printf("%.2f || %.2f\n",fl.get(), fr.get());
	}
	
	public void autoAngle(double heading){
		right(-heading / 360);
		left(heading / 360);
	}
	
	public void autoMove(double speed, double heading){
		right(speed - (heading / 360));
		left(speed + (heading / 360));
	}
	
	public void controlledMove(){
		right(con.getX() - con.getY());
		left(con.getX() + con.getY());
	}
	
	public void printCon(){
		System.out.println(con.getX());
	}
}
