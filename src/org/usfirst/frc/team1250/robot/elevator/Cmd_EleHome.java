package org.usfirst.frc.team1250.robot.elevator;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_EleHome extends Command {

	public Cmd_EleHome() {
		requires(Robot.s_elevator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(3);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.s_elevator.setLiftPosition(Robot.s_elevator.HOME_POS);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Robot.s_elevator.getLiftPosInTicks() == (Robot.s_elevator.ELE_TICKS * Robot.s_elevator.HOME_POS))
				|| !Robot.s_elevator.getEleSensor() || isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		if (!Robot.s_elevator.getEleSensor()) {
			Robot.s_elevator.setTicksToHome();
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
