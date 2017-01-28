package org.usfirst.frc.team3328.robot;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.wpi.first.wpilibj.SpeedController;

public class SteamWorksDriveSystemTest {

	@Test
	public void controlledMove_yLargerThanX_rightMotorTurnsBackwards() {
		FakeController fakeCont = new FakeController();
		fakeCont.setY(1);
		fakeCont.setX(0);
		FakeSpeedController fl = new FakeSpeedController();
		FakeSpeedController fr = new FakeSpeedController();
		FakeSpeedController bl = new FakeSpeedController();
		FakeSpeedController br = new FakeSpeedController();
		SteamWorksDriveSystem drive = new SteamWorksDriveSystem(fl, fr, bl, br, fakeCont);
		drive.controlledMove();
		assertEquals(1.0, (fr.speed),  0);
	}
	
}
	
	//Function Arrange Act Assert
	