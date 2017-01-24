package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	DriveSystem drive = new DriveSystem();
	ADIS16448_IMU imu = new ADIS16448_IMU();

	@Override
	public void robotInit() {
		drive.init();
		imu.init();
	}

	@Override
	public void autonomousInit() {
		//auto init code
	}

	@Override
	public void autonomousPeriodic() {
		//auto code
	}

	@Override
	public void teleopPeriodic() {
		drive.controlledMove();
		drive.printSpeed();
	}

	@Override
	public void testPeriodic() {
	}
}

