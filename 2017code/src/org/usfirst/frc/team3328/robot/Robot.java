package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends IterativeRobot {
	SpeedController fl = new Talon(0);
	SpeedController fr = new Talon(1);
	SpeedController bl = new Talon(2);
	SpeedController br = new Talon(3);
	Controller xbox = new SteamWorksController(false);
	DriveSystem drive = new SteamWorksDriveSystem(fl, fr, bl, br, xbox);
	Climber climb = new Climber(xbox);
	ADIS16448_IMU imu = new ADIS16448_IMU();
	Controller cont = new SteamWorksController(false);
	Comms comms = new Comms();
	Target target = new Target();
	NetworkTablesTargetProvider targetProvider;

	@Override
	public void robotInit() {
		targetProvider = new NetworkTablesTargetProvider();
		imu.init();
	}

	@Override
	public void autonomousInit() {
		//auto init code
	}

	@Override
	public void autonomousPeriodic() {
		//drive.autoAngle(0, imu.getAngleZ(), 0);
	}

	@Override
	public void teleopPeriodic() {
		drive.controlledMove();
		drive.printSpeed();
		/*comms.update();
		target.printValues();*/
		//System.out.println(drive.updateDisplacement(0, imu.getAngleZ()));
	}

	@Override
	public void testPeriodic() {
	}
}