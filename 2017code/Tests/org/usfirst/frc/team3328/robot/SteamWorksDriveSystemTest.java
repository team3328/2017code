package org.usfirst.frc.team3328.robot;

import static org.junit.Assert.*;
import org.junit.Test;
import org.usfirst.frc.team3328.robot.subsystems.SteamWorksDriveSystem;
import org.usfirst.frc.team3328.robot.utilities.DriveEncoders;
import org.usfirst.frc.team3328.robot.utilities.DriveTalons;

public class SteamWorksDriveSystemTest {
	
	DriveEncoders encoders = new DriveEncoders();
	FakeController fakeCont = new FakeController();
	FakeSpeedController fl = new FakeSpeedController();
	FakeSpeedController fr = new FakeSpeedController();
	FakeSpeedController bl = new FakeSpeedController();
	FakeSpeedController br = new FakeSpeedController();
	DriveTalons talons = new DriveTalons(fl, fr, bl, br);
	FakeADIS16448_IMU imu = new FakeADIS16448_IMU();
	SteamWorksDriveSystem drive = new SteamWorksDriveSystem(encoders, talons, fakeCont);

	@Test
	public void controlledMove_yLargerThanX_rightMotorTurnsBackwards() {
		fakeCont.setY(1);
		fakeCont.setX(0);
		drive.controlledMove();
		assertEquals(1.0, (fr.speed),  0);
	}
	
	@Test
	public void updateDisplacement_smallDisplacement_displacementSetToPoint5(){
		imu.setAngleZ(Math.random() / 20);
		assertEquals(drive.updateDisplacement(0, imu.getAngleZ()), .05, 0);
	}
	
	@Test
	public void autoAngle_robotTurnedRight_rightMotorTurnsForwards(){
		imu.setAngleZ(20);
		drive.autoAngle(0, imu.getAngleZ(), 0);
		assertTrue(fr.speed < 0 && br.speed < 0);
		
	}
	
}
	
	// Arrange Act Assert
	