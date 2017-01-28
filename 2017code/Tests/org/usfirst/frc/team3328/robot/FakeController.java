package org.usfirst.frc.team3328.robot;

public class FakeController implements Controller {

	double x;
	double y;
	
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	public void setX(double speed){
		x = speed;
	}
	
	public void setY(double speed){
		y = speed;
	}
	
	@Override
	public boolean getButton(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getButtonPress(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getPad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
