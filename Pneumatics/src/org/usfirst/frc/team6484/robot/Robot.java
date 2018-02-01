/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6484.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	private Joystick m_stick;
	//private Timer m_timer;
	private static DoubleSolenoid Arm;

	
	 //This function is run when the robot is first started up and should be
	 // used for any initialization code.
	 
	@Override
	public void robotInit() {
		m_stick = new Joystick(0);
		//m_timer = new Timer();
	}
	
	 // This function is called once each time the robot enters teleoperated mode.
	 
	@Override
	public void teleopInit() {
		Arm = new DoubleSolenoid(0,1);
		
		//m_timer.start();
	}

	
	 // This function is called periodically during teleoperated mode.
	 
	@Override
	public void teleopPeriodic() {
		if (m_stick.getRawButton(1)) {
		Arm.set(DoubleSolenoid.Value.kForward);
		}
		else if (m_stick.getRawButton(2))  {
			Arm.set(DoubleSolenoid.Value.kReverse);
			}
	//	m_timer.get()
	}

	
	 //This function is called periodically during test mode.
	
	@Override
	public void testPeriodic() {
	}
}
