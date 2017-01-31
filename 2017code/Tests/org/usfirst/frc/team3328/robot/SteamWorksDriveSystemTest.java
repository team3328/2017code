package org.usfirst.frc.team3328.robot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.wpi.first.wpilibj.SpeedController;

public class SteamWorksDriveSystemTest {
	
	FakeController fakeCont = new FakeController();
	FakeSpeedController fl = new FakeSpeedController();
	FakeSpeedController fr = new FakeSpeedController();
	FakeSpeedController bl = new FakeSpeedController();
	FakeSpeedController br = new FakeSpeedController();
	FakeADIS16448_IMU imu = new FakeADIS16448_IMU();
	SteamWorksDriveSystem drive = new SteamWorksDriveSystem(fl, fr, bl, br, fakeCont);

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
	
	
	
}
	
	// Arrange Act Assert
	