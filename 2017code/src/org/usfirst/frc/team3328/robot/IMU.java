package org.usfirst.frc.team3328.robot;

public interface IMU {

	/**
	   * {@inheritDoc}
	   */
	void calibrate();

	/**
	   * {@inheritDoc}
	   */
	void reset();

	/**
	   * Delete (free) the spi port used for the IMU.
	   */
	void free();

	/**
	   * {@inheritDoc}
	   */
	double getAngle();

	/**
	   * {@inheritDoc}
	   */
	double getRate();

	double getAngleX();

	double getAngleY();

	double getAngleZ();

	double getRateX();

	double getRateY();

	double getRateZ();

	double getAccelX();

	double getAccelY();

	double getAccelZ();

	double getMagX();

	double getMagY();

	double getMagZ();

	double getPitch();

	double getRoll();

	double getYaw();

	double getLastSampleTime();

	double getBarometricPressure();

	double getTemperature();

	double getQuaternionW();

	double getQuaternionX();

	double getQuaternionY();

	double getQuaternionZ();

	double getCompAngleZ();

	void init();

	boolean getData(double data, int index, double deviation);

	double rateOfChange();

	double compFilter(double angle, double gyro, double acc, double dt);

	void printAngle();

	void printRate();

	void printAccel();

	void printMag();

	/**
	   * {@inheritDoc}
	   */
	void updateTable();

}