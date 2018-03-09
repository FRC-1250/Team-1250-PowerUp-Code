/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1250.robot.climber;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1250.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class Cmd_ClimberRetract extends Command {
	public Cmd_ClimberRetract() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.s_climber);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.s_climber.runMotorOut();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return !Robot.m_oi.getButtonState(8);
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.s_climber.stopMotor();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
