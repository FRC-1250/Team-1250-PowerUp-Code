/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1250.robot.subsystems.*;

import edu.wpi.first.wpilibj.DriverStation;
//import org.usfirst.frc.team1250.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
//import com.kauailabs.sf2.frc.navXSensor;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	Joystick Arcadepad = new Joystick(1);
	public static I2C i2c; 
	static DriverStation.Alliance color;
	public static final Sub_DriveTrain s_drivtrain 
			= new Sub_DriveTrain();
	public static final Sub_Shifter s_shifter
			= new Sub_Shifter();
	public static final Sub_Claw s_claw
			= new Sub_Claw();
	public static final Sub_Elevator s_elevator
			= new Sub_Elevator();
	public static OI m_oi;
	
	public static boolean shiftState = false;
	public static Timer robotTimer= new Timer();
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	static byte[] toSend = new byte[1];
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		i2c = new I2C(I2C.Port.kOnboard,84);
		m_oi = new OI();
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

		toSend[0] = 76;
		i2c.writeBulk(toSend,  1);

	}

	@Override
	public void disabledPeriodic() {
		color =  DriverStation.getInstance().getAlliance();

	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();

		}
		
		
		}
	

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		this.log();
		if(color == DriverStation.Alliance.Blue){
			toSend[0] = 72;
			i2c.writeBulk(toSend,  1);
		}
			else {
				toSend[0] = 74;
				i2c.writeBulk(toSend,  1);
		}

			
		}
		

	

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		this.log();
	}
	
	public void log() {
		SmartDashboard.putBoolean("Is Limit Seen???????", s_elevator.getEleSensor());
		SmartDashboard.putNumber("test", s_elevator.getLiftPosInTicks());
		SmartDashboard.putNumber("Joystick Val", m_oi.getArcadepad().getRawAxis(1));
		SmartDashboard.putNumber("sensor Pos", s_elevator.eleMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("error", s_elevator.eleMotor.getClosedLoopError(0));
	}
	
}
