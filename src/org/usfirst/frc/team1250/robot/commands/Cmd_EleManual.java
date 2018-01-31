package org.usfirst.frc.team1250.robot.commands;

import org.usfirst.frc.team1250.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Cmd_EleManual extends Command {

	int currentTicks;
	int bumpVal;
	int loop;
    public Cmd_EleManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.s_elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Initialized to Home Position
    	Robot.s_elevator.setLiftPosition(0);
    	loop = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentTicks = Robot.s_elevator.getTicks();
    	bumpVal = (int) Robot.m_oi.getArcadepad().getRawAxis(1);
    	
//    	if (!Robot.s_elevator.getEleSensor() && bumpVal<0){
//    		bumpVal = 0;
//    	}
    	
    	if (loop > 100){
    		System.out.println(bumpVal);
    		loop = 0;
    	}
    	
    	Robot.s_elevator.setBump(bumpVal);
    	
    	loop +=1;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
