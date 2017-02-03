package org.usfirst.frc.team3328.robot;

import org.usfirst.frc.team3328.robot.networking.Comms;
import org.usfirst.frc.team3328.robot.networking.NetworkTablesTargetProvider;
import org.usfirst.frc.team3328.robot.networking.Target;
import org.usfirst.frc.team3328.robot.subsystems.Climber;
import org.usfirst.frc.team3328.robot.subsystems.DriveSystem;
import org.usfirst.frc.team3328.robot.subsystems.SteamWorksClimber;
import org.usfirst.frc.team3328.robot.subsystems.SteamWorksDriveSystem;
import org.usfirst.frc.team3328.robot.utilities.ADIS16448_IMU;
import org.usfirst.frc.team3328.robot.utilities.Controller;
import org.usfirst.frc.team3328.robot.utilities.DriveEncoders;
import org.usfirst.frc.team3328.robot.utilities.IMU;
import org.usfirst.frc.team3328.robot.utilities.SteamWorksXbox;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Robot extends IterativeRobot {
	DriveEncoders encoders;
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
		drive = new SteamWorksDriveSystem(encoders, fl, fr, bl, br, xbox);
		climb = new SteamWorksClimber(climbControl, xbox);
		imu = new ADIS16448_IMU();
		comms = new Comms();
		targetProvider = new NetworkTablesTargetProvider();
		target = targetProvider.getTarget();
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
		/*drive.controlledMove();
		drive.printSpeed();*/
		//target.printValues();
		drive.track(target.getPixel());
		drive.printSpeed();
		
	}

	@Override
	public void testPeriodic() {
	}
}