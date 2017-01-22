package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltralightBeam {
	
	AnalogInput ult;
	double store, inches;
	double vi = .009766;
	
	public UltralightBeam(){
		ult = new AnalogInput(0);
		store = (ult.getVoltage() / vi);
	}
	
	public void printRange(){
		inches = range();
			System.out.printf("%05.2f\n", inches);
	}
	
	public double range(){
		return (ult.getVoltage() / vi);
	}
	
}
