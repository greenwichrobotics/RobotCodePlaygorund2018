/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Spark;

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together.
 */

public class Robot extends IterativeRobot {
	private static final int kMotorPort = 4;
	private static final int kJoystickPort = 0;
	private static final int Minimum = 0;
	private static final int Maximum = 180;
	private static final int Target = 90;
//	private static final int kEncoderPort = 6;

	private SpeedController m_motor;
	private Joystick m_joystick;
	private Encoder enc;

	@Override
	public void robotInit() {
		m_motor = new Spark(kMotorPort);
		m_joystick = new Joystick(kJoystickPort);
		enc = new Encoder(5, 6, false, Encoder.EncodingType.k4X);
		
	}

	@Override 
	public void teleopInit() {
		enc.reset();
	}
	@Override
	public void teleopPeriodic() {
		if (enc.get() > Minimum && enc.get() < Maximum) {
		m_motor.set(m_joystick.getY());
		//System.out.println(enc.getRate());
		}
		else if ((enc.get() >= Maximum && m_joystick.getY() > 0) || (enc.get() <= Minimum && m_joystick.getY() < 0)){
			m_motor.set(m_joystick.getY());
		}
		else {
			m_motor.set(0);
		}
		System.out.println(enc.get());
	
	if (m_joystick.getRawButton(2)) {
	
	MoveToTarget();
	}	
}
	
	public void MoveToTarget() {
	
		while (enc.get() > Target) {
		m_motor.set(1);
		System.out.println(enc.get());
		
		}
		while (enc.get() < Target) {
			m_motor.set(-1);
			System.out.println(enc.get());
		}
	}
	}
