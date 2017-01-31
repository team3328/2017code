package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class Robot extends IterativeRobot {
	SpeedController fl;
	SpeedController fr;
	SpeedController bl;
	SpeedController br;
	SpeedController climbControl;
	Controller xbox;
	DriveSystem drive;
	Climber climb;
	IMU imu;
	Controller cont;
	Comms comms;
	Target target;
	NetworkTablesTargetProvider targetProvider;

	@Override
	public void robotInit() {
		fl = new Talon(0);
		fr = new Talon(1);
		bl = new Talon(2);
		br = new Talon(3);
		climbControl = new Talon(4);
		xbox = new SteamWorksXbox();
		drive = new SteamWorksDriveSystem(fl, fr, bl, br, xbox);
		climb = new Climber(climbControl, xbox);
		imu = new ADIS16448_IMU();
		comms = new Comms();
		target = new Target();
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
		//System.out.println(drive.getSpeed());
	}

	@Override
	public void testPeriodic() {
	}
}