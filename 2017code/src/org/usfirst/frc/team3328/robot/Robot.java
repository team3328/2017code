package org.usfirst.frc.team3328.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	Controller xbox = new Controller(false);
	DriveSystem drive = new DriveSystem(xbox);
	Climber climb = new Climber(xbox);
	ADIS16448_IMU imu = new ADIS16448_IMU();
	Controller cont = new Controller(false);
	Comms comms = new Comms();
	TargetService provider = new TargetService();
	Target target = provider.provideTarget();
	Listener listener;

	@Override
	public void robotInit() {
		listener = new Listener("listenerThread", target);
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
		comms.update();
		target.printValues();
	}

	@Override
	public void testPeriodic() {
	}
}