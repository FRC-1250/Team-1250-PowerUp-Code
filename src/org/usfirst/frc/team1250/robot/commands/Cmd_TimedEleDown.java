package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class Cmd_TimedEleDown extends TimedCommand {

    public Cmd_TimedEleDown(double timeout) {
        super(timeout);
        requires(Robot.s_elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.s_elevator.eleDown();
    }

    // Called once after timeout
    protected void end() {
    	Robot.s_elevator.eleStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
