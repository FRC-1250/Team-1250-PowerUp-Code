package org.usfirst.frc.team1250.robot.commandIntake;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ClawSpitFast extends TimedCommand {

    public ClawSpitFast(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.s_elevator.soloLiftUnPinch();
    	Robot.s_claw.dump();
    	Robot.s_claw.pinch();
    }

    // Called once after timeout
    protected void end() {
    	Robot.s_elevator.soloLiftPinch();
    	Robot.s_claw.stop();
    	Robot.s_claw.unpinch();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}